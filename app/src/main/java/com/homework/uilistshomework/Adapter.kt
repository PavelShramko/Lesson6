package com.homework.uilistshomework

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.databinding.ItemCardviewBinding
import com.homework.uilistshomework.databinding.ItemColorBinding
import com.homework.uilistshomework.databinding.ItemHeaderBinding

class Adapter() : RecyclerView.Adapter<Adapter.BaseViewHolder>() {

    var items: List<Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            R.layout.item_color -> ColorViewHolder(parent)
            R.layout.item_header -> HeaderViewHolder(parent)
            else -> CardViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (val item = items[position]) {
            is Item.Header -> (holder as HeaderViewHolder).bind(item)
            is Item.Color -> (holder as ColorViewHolder).bind(item)
            is Item.Card -> (holder as CardViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Item.Color -> R.layout.item_color
            is Item.Header -> R.layout.item_header
            is Item.Card -> R.layout.item_cardview
        }
    }


    class ColorViewHolder(private val binding: ItemColorBinding) : BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
                ItemColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Color) {
            binding.root.backgroundTintList = ColorStateList.valueOf(item.color)
            binding.textView.text = item.colorName
        }
    }


    class HeaderViewHolder(private val binding: ItemHeaderBinding) : BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
                ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Header) {
            binding.textView.text = item.text
        }
    }


    class CardViewHolder(private val binding: ItemCardviewBinding) : BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
                ItemCardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        fun bind(item: Item.Card) {
            binding.imageCV.setImageResource(item.imageResource)
            binding.textHeading.text = item.text1
            binding.textDescription.text = item.text2


// Не работает, не могу разобраться
            binding.close.setOnClickListener {
                val position: Int = this.adapterPosition
                MainActivity().deletedCard(position)
                Adapter().notifyItemRemoved(position)
            }
        }
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

