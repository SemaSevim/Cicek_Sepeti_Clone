package com.example.odev5.ui.screen

import com.example.odev5.R

data class Urun(
    val resimId: Int,
    val ad: String,
    val fiyat:String,
    val eskiFiyat: String,
    val indirim: String,
    val yildiz: Float,
    val degerlendirmeSayisi: Int,
    val teslimat: String
) {
}