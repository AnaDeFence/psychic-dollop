package com.example.days30.data

import com.example.days30.R
import com.example.days30.model.Day

object DataSource {
    val days = listOf(
        Day(1, R.string.day_1_title, R.string.day_1_desc, getImage(1)),
        Day(2, R.string.day_2_title, R.string.day_2_desc, getImage(2)),
        Day(3, R.string.day_3_title, R.string.day_3_desc, getImage(3)),
        Day(4, R.string.day_4_title, R.string.day_4_desc, getImage(4)),
        Day(5, R.string.day_5_title, R.string.day_5_desc, getImage(5)),
        Day(6, R.string.day_6_title, R.string.day_6_desc, getImage(6)),
        Day(7, R.string.day_7_title, R.string.day_7_desc, getImage(7)),
        Day(8, R.string.day_8_title, R.string.day_8_desc, getImage(8)),
        Day(9, R.string.day_9_title, R.string.day_9_desc, getImage(9)),
        Day(10, R.string.day_10_title, R.string.day_10_desc, getImage(10)),
        Day(11, R.string.day_11_title, R.string.day_11_desc, getImage(11)),
        Day(12, R.string.day_12_title, R.string.day_12_desc, getImage(12)),
        Day(13, R.string.day_13_title, R.string.day_13_desc, getImage(13)),
        Day(14, R.string.day_14_title, R.string.day_14_desc, getImage(14)),
        Day(15, R.string.day_15_title, R.string.day_15_desc, getImage(15)),
        Day(16, R.string.day_16_title, R.string.day_16_desc, getImage(16)),
        Day(17, R.string.day_17_title, R.string.day_17_desc, getImage(17)),
        Day(18, R.string.day_18_title, R.string.day_18_desc, getImage(18)),
        Day(19, R.string.day_19_title, R.string.day_19_desc, getImage(19)),
        Day(20, R.string.day_20_title, R.string.day_20_desc, getImage(20)),
        Day(21, R.string.day_21_title, R.string.day_21_desc, getImage(21)),
        Day(22, R.string.day_22_title, R.string.day_22_desc, getImage(22)),
        Day(23, R.string.day_23_title, R.string.day_23_desc, getImage(23)),
        Day(24, R.string.day_24_title, R.string.day_24_desc, getImage(24)),
        Day(25, R.string.day_25_title, R.string.day_25_desc, getImage(25)),
        Day(26, R.string.day_26_title, R.string.day_26_desc, getImage(26)),
        Day(27, R.string.day_27_title, R.string.day_27_desc, getImage(27)),
        Day(28, R.string.day_28_title, R.string.day_28_desc, getImage(28)),
        Day(29, R.string.day_29_title, R.string.day_29_desc, getImage(29)),
        Day(30, R.string.day_30_title, R.string.day_30_desc, getImage(30))
    )

    // Эта функция зацикливает картинки от 1 до 8
    private fun getImage(dayNumber: Int): Int {
        val imageNumber = (dayNumber - 1) % 8 + 1
        return when (imageNumber) {
            1 -> R.drawable._1
            2 -> R.drawable._2
            3 -> R.drawable._3
            4 -> R.drawable._4
            5 -> R.drawable._5
            6 -> R.drawable._6
            7 -> R.drawable._7
            else -> R.drawable._8
        }
    }
}