package com.homework.uilistshomework

import android.content.Context
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import kotlin.random.Random

object MockUtil {
    private val colors = listOf(
            R.color.red,
            R.color.teal,
            R.color.yellow,
            R.color.design_default_color_primary_variant,
            R.color.purple_200
    )


    @ExperimentalStdlibApi
    fun getColorList(context: Context, size: Int = 50) = buildList(size) {
        for (i in 0 until size) add(getRandomColorItem(context))
    }

    private fun getRandomColorItem(context: Context): Item.Color {
        val color = ContextCompat.getColor(context, getRandomRes())
        return Item.Color(color, "#${Integer.toHexString(color)}")
    }

    private fun getRandomRes(): Int = colors[Random.nextInt(colors.size)]

    @ExperimentalStdlibApi
    fun getHeaderColorList(context: Context) = listOf(Item.Header("Мои любимые цвета")) +
            getColorList(context, 3) + Item.Header("Мои нелюбимые цвета") +
            getColorList(context, 10)


    fun getCardItems(context: Context, size: Int): ArrayList<Item.Card> {
        val list = ArrayList<Item.Card>()

        for (i in 0 until size) {
            val image = when (i % 3) {
                0 -> R.drawable.ic_baseline_mood_24
                1 -> R.drawable.ic_baseline_done_24
                else -> R.drawable.ic_baseline_spa_24
            }
            val text1 = "Заголовок $i"
            val text2 = "Описание $i"
            val item = Item.Card(image, text1, text2)
            list += item
        }
        return list
    }
}