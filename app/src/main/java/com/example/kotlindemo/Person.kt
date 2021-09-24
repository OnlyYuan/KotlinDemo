package com.example.kotlindemo

import android.os.Parcel
import android.os.Parcelable

class Person() :Parcelable {

    //姓名
    var name :String = ""
    //年龄
    var age:Int = 0
    //电话
    var num:Int = 0


    constructor(parcel: Parcel) : this() {
        readFromParcel(parcel)
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return Array(size){
                Person()
            }
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeInt(age)
        dest?.writeInt(num)
    }

    public fun readFromParcel(inParcel: Parcel) {
        name = inParcel.readString().toString()
        age = inParcel.readInt()
        num = inParcel.readInt()

    }

}