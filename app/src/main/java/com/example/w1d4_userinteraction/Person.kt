package com.example.w1d4_userinteraction

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(val name:String, val age:Int) : Parcelable