package com.example.kotlindemo

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.os.EnvironmentCompat
import androidx.databinding.DataBindingUtil
import com.example.kotlindemo.model.api.ApiService
import com.example.kotlindemo.model.bean.ImageBackBean
import com.example.kotlindemo.model.bean.WordTokenBackBean
import com.example.kotlindemo.databinding.ActivityMainBinding
import com.example.kotlindemo.utils.PhotoRotateUtil
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : Activity(), View.OnClickListener {
    lateinit var cameraBinding: ActivityMainBinding
    var mCameraImagePath: String? = null
    var mCameraUri: Uri? = null
    val CAMERA_PERMSSION_CODE: Int = 1
    val TAKE_CAMERA_CODE: Int = 10002
    var isAndroidQ: Boolean = true
    var mTokenString: String = ""
    var mImage: String = ""
    val TAG: String = "MainActivity"


    private var handler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 1) { //10以上的处理

                getImageMsg(mImage, mTokenString)

            } else if (msg.what == 2) {//10以下的处理
                var bitmap: Bitmap
                var bitmapString: String
                bitmap = msg.data.getParcelable<Bitmap>("ImageBit")!!
                bitmapString = msg.data.getString("ImageString")!!

                photoImg.setImageBitmap(bitmap)
                getImageMsgByOK(bitmapString, mTokenString)
                // getImageMsg(imageString,mTokenString)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cameraBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBtn.setOnClickListener(this)
        checkPermssion();
        getTokenMsg();
        //getTokenMsgByOK();
  
    }


    /**
     * 申请读写权限
     */
    private fun checkPermssion() {
        println("---->检测读写权限")
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE),
                100);
        } else {
            println("---->已经有读写权限")
        }
    }


    /**
     * 获取权限
     */
    private fun checkPermssionPic() {

        var hasPermission: Int = ContextCompat.checkSelfPermission(
            application,
            android.Manifest.permission.CAMERA
        )

        if (hasPermission == PackageManager.PERMISSION_GRANTED) {//有权限

            takePicture()
        } else {

            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(android.Manifest.permission.CAMERA),
                CAMERA_PERMSSION_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        println("---》权限返回=======123213")
        if (requestCode == CAMERA_PERMSSION_CODE) {//拍照权限
            println("---》权限返回")
            takePicture();
        } else {
            Toast.makeText(this@MainActivity, "授权失败", Toast.LENGTH_SHORT).show()
        }

    }


    /**
     * 创建
     */
    private fun createImageUrl(): Uri {
        //是否有sd卡
        var status = Environment.getExternalStorageState();

        //是否有sd卡
        if (status == Environment.MEDIA_MOUNTED) {
            return contentResolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                ContentValues()
            )!!
        } else {
            return contentResolver.insert(
                MediaStore.Images.Media.INTERNAL_CONTENT_URI,
                ContentValues()
            )!!
        }
    }


    /**
     * 10以下的处理 保存图片
     */
    private fun createImageFile(): File? {

        var imageName: String =
            SimpleDateFormat("yyyymmdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (!storageDir!!.exists()) {
            storageDir.mkdir();
        }

        var tempFile: File = File(storageDir, imageName + ".jpg")
        if (!Environment.MEDIA_MOUNTED.equals(EnvironmentCompat.getStorageState(tempFile))) {
            println("返回了空值")
            return null
        }

        return tempFile
    }


    /**
     * 拍照
     */
    private fun takePicture() {
        println("--->准备拍照")
        var cameraIntent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        isAndroidQ = Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q

        //判断是否有相机
        if (cameraIntent.resolveActivity(packageManager) != null) {
            var photoFile: File? = null
            var photoUri: Uri? = null

            if (isAndroidQ) {
                //适配android10
                println("---》10以上")
                photoUri = createImageUrl()
            } else {
                println("---》10以下、、、、、、、")
                try {
                    photoFile = createImageFile()
                } catch (e: IOException) {
                    e.printStackTrace()
                }


                if (photoFile != null) {
                    println("---》进入10以下111111111111111")
                    mCameraImagePath = photoFile.absolutePath

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        photoUri = FileProvider.getUriForFile(this,
                            packageName + ".fileprovider",
                            photoFile)
                    } else {
                        println("---》7以下33333333333333")
                        photoUri = Uri.fromFile(photoFile)
                    }
                }
            }
            mCameraUri = photoUri;
            if (photoUri != null) {
                println("---》准备拍照-------------》》》》$photoUri")
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                cameraIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                startActivityForResult(cameraIntent, TAKE_CAMERA_CODE)
                //  startActivityForResult(cameraIntent, TAKE_CAMERA_CODE)
            }
        }

    }


    override fun onClick(v: View?) {
        when (v) {
            mBtn -> checkPermssionPic()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TAKE_CAMERA_CODE) {//拍照返回
            println("---》进入拍照反馈成功0000")

            if (isAndroidQ) {

                photoImg.setImageURI(mCameraUri)
                if (mCameraUri != null) {
                    var bitmap: Bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(
                        mCameraUri!!))
                    //压缩图片
                    var mbitMap: Bitmap = PhotoRotateUtil.compressImage(bitmap)
                    //上传图片，返回文字
                    var base64Bitmap: String = PhotoRotateUtil.BitmapToBase64(mbitMap)
                    mImage = PhotoRotateUtil.toUrlEncode(base64Bitmap)
                }

                Log.i(TAG, mTokenString)
               // handler.sendEmptyMessage(1)
                getImageMsg(mImage, mTokenString)
                println("---》进入拍照反馈成功1111111111111111")
            } else {
                println("---》进入拍照反馈成功2222222222222222222")

                //  var bitmap: Bitmap = BitmapFactory.decodeFile(mCameraImagePath)
                // var degree = PhotoRotateUtil.getBitmapDegree(mCameraImagePath)
                //   bitmap = PhotoRotateUtil.rotateBitmapByDegree(bitmap, degree)
//                //压缩图片
//                var mBitmap:Bitmap =PhotoRotateUtil.compressImage(bitmap)

                //  //上传图片，返回文字
                // var base64Bitmap:String=PhotoRotateUtil.BitmapToBase64(mBitmap)
                //var imageString= PhotoRotateUtil.toUrlEncode(base64Bitmap)
                //  Log.i(TAG, mTokenString)

                //   photoImg.setImageBitmap(bitmap)

                Thread {
                    var bitmap: Bitmap = BitmapFactory.decodeFile(mCameraImagePath)
                    var degree = PhotoRotateUtil.getBitmapDegree(mCameraImagePath)
                    bitmap = PhotoRotateUtil.rotateBitmapByDegree(bitmap, degree)
                    //压缩图片
//                    var mBitmap:Bitmap =PhotoRotateUtil.compressImage(bitmap)
                    //上传图片，返回文字

                    var base64Bitmap:String=PhotoRotateUtil.BitmapToBase64(bitmap)
                   // var imageString= PhotoRotateUtil.toUrlEncode(base64Bitmap)

                    var msg = Message()
                    msg.what = 2
                    var bundle = Bundle()

                    bundle.putParcelable("ImageBit", bitmap)
                    bundle.putString("ImageString", base64Bitmap)
                    msg.data = bundle
                    handler.sendMessage(msg)

                }.start()


//                  getImageMsg(mImage)
            }
        }
    }


    /**
     * 获取token
     */
    fun getTokenMsg() {
        Log.v("MainActivity", "---->开始请求")
        //日志拦截器(body)
        var httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        var httpLoggingInterceptor2 = HttpLoggingInterceptor()
        httpLoggingInterceptor2.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        var okHttpClient = OkHttpClient.Builder()
        // okHttpClient.addInterceptor(httpLoggingInterceptor)
        okHttpClient.addInterceptor(httpLoggingInterceptor2)


        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://aip.baidubce.com/oauth/2.0/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()

        var api: ApiService = retrofit.create(ApiService::class.java)
        api.getToken("client_credentials",
            "SsaAPHe4xuKztqAUS1Stjqlp",
            "YL8AnKVDtuUzOBqyQy6RrFn6Qcm7aYaX").enqueue(object : Callback<WordTokenBackBean> {
            override fun onResponse(
                call: Call<WordTokenBackBean>,
                response: Response<WordTokenBackBean>,
            ) {
                Log.v("MainActivity",
                    "---->请求成功${response.body().toString()} 和 ${response.body()?.access_token}")
                mTokenString = response.body()!!.access_token
            }

            override fun onFailure(call: Call<WordTokenBackBean>, t: Throwable) {
                Log.v("MainActivity", "---->请求失败")
            }
        })
    }


    /**
     * 用okhttp来获取返回值
     */
    fun getImageMsgByOK(iamge: String, token: String) {

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .protocols(Collections.singletonList(Protocol.HTTP_1_1))
            .build()

        var formBody: RequestBody = FormBody.Builder()   //创建表单请求
            .add("access_token", token)
            .add("image", iamge)      //
            .build()
        val mUrlString: String = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic"

        // 创建一个Request
        // 创建一个Request
        val request = Request.Builder()
            .url(mUrlString)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .post(formBody)
            .build()

        okHttpClient
            .newCall(request)
            .enqueue(object : okhttp3.Callback {
                override fun onFailure(call: okhttp3.Call, e: IOException) {

                    Log.i(TAG, "---->sshibai${e.toString()}")

                }

                override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                    Log.i(TAG, "---->成功121212${response.body!!.string()}")
//                    Toast.makeText(this@MainActivity,
//                        "---->成功1212",
//                        Toast.LENGTH_SHORT).show()
                }
            })
    }


    /**
     * 获取图片返回信息
     * @param token
     */
    fun getImageMsg(iamge: String, token: String) {

        var httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        var okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(httpLoggingInterceptor)

        var retrofit: Retrofit = Retrofit.Builder()

            .baseUrl("https://aip.baidubce.com/rest/2.0/ocr/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()

        var api: ApiService = retrofit.create(ApiService::class.java)
        api.upLoadImage(token,
            iamge).enqueue(object : Callback<ImageBackBean> {
            override fun onResponse(call: Call<ImageBackBean>, response: Response<ImageBackBean>) {
                Log.i(TAG, "---->识别成功")
                Toast.makeText(this@MainActivity,
                    "---->识别成功${response.body()?.words_result_num}",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ImageBackBean>, t: Throwable) {
                Log.i(TAG, "---->识失败")
                Log.i(TAG, "---->识别成功")
                Toast.makeText(this@MainActivity,
                    "---->识别失败",
                    Toast.LENGTH_SHORT).show()
            }

        })

    }


}



