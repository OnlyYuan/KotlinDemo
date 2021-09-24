// IMyAidlInterface.aidl
package com.example.kotlindemo;

// Declare any non-default types here with import statements
import com.example.kotlindemo.Person;

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    String getName();

    String getPerson(inout Person person);
}