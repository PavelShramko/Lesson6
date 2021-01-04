package com.homework.uilistshomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homework.uilistshomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val adapter1 = Adapter()
    private val adapter2 = Adapter()

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter1
        adapter1.items = MockUtil.getHeaderColorList(this)

       // val cardItems = MockUtil.getCardItems(this, 15)
        //adapter2.items = cardItems
    }
}
