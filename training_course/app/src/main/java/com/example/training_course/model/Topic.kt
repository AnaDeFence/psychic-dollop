package com.example.training_course.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId:Int,
    val courceCount: Int,
    @DrawableRes val imageResourceId: Int
)
