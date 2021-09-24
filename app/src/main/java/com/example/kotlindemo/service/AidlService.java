package com.example.kotlindemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.example.kotlindemo.IMyAidlInterface;

public class AidlService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    class MyBinder extends IMyAidlInterface.Stub{


        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getName() throws RemoteException {
            return "====>链接成功";
        }

        @Override
        public String getPerson(com.example.kotlindemo.Person person) throws RemoteException {
            return "name: " + person.getName()
                    +"age: " + person.getAge()
                    +"num: " + person.getNum();
        }
    }

}
