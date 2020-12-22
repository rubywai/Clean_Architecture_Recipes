package com.example.foody.models

import android.os.Parcelable


data class ExtendedIngredient(

    val amount: Double,

    val consistency: String,

    val image: String,

    val name: String,

    val original: String,

    val unit: String
)