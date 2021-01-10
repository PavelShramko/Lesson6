package com.homework.uilistshomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
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
        adapter1.items = MockUtil.getHeaderColorList(this@MainActivity)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab?.position == 0) {
                    binding.recyclerView.adapter = adapter1
                    adapter1.items = MockUtil.getHeaderColorList(this@MainActivity)
                } else {
                    binding.recyclerView.adapter = adapter2
                    adapter2.items = MockUtil.getCardItems(15)
                    }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //TODO("Not yet implemented")
            }


        })
    }
// Не работает, не могу разобраться
    fun deletedCard(position: Int) {
        MockUtil.getCardItems(15).removeAt(position)
    }
}
