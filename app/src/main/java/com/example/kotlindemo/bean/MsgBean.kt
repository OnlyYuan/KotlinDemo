package com.example.kotlindemo.bean

data class MsgBean(var response_data:Response? =null) {


    data class Response(var user_list:ArrayList<User>? =null){

    }


    data class User(var user_info:UserMsg? = null){

    }

    data class UserMsg(var nickname:String = "",
                       var follower_count:String= "",
                       var versatile_display:String =" ",
                       var total_favorited:String = ""){

    }
}