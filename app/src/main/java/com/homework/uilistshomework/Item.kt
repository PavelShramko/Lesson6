package com.homework.uilistshomework

sealed class Item{
    data class Card (val imageResource: Int, val text1: String, val text2: String): Item()
    data class Color (val color: Int, val colorName: String): Item()
    data class Header (val text: String) : Item()
}
