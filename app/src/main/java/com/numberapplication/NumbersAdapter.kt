package com.numberapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.numberapplication.databinding.ListItemBinding

class NumbersAdapter(private val items: List<Int>, private val context: Context) :
    RecyclerView.Adapter<NumbersAdapter.NumberViewHolder>() {

    var numberType: NumberType = NumberType.ALL

    class NumberViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val number = items[position]
        val word = Utils.numberToWord(number)
        holder.binding.numberText.text = "$number - $word"

        when {
            numberType == NumberType.EVEN && number % 2 == 0 -> {
                holder.binding.constraintLayout.setBackgroundColor(context.resources.getColor(R.color.light_blue))
            }

            numberType == NumberType.ODD && number % 2 != 0 -> {
                holder.binding.constraintLayout.setBackgroundColor(context.resources.getColor(R.color.light_green))
            }

            numberType == NumberType.PRIME && Utils.isPrime(number) -> {
                holder.binding.constraintLayout.setBackgroundColor(context.resources.getColor(R.color.light_yellow))
            }

            numberType == NumberType.FIBONACCI && Utils.isFibonacci(number) -> {
                holder.binding.constraintLayout.setBackgroundColor(context.resources.getColor(R.color.light_purple))
            }

            numberType == NumberType.PALINDROME && Utils.isPalindrome(number) -> {
                holder.binding.constraintLayout.setBackgroundColor(context.resources.getColor(R.color.light_red))
            }

            numberType == NumberType.PERFECT_SQUARE && Utils.isPerfectSquare(number) -> {
                holder.binding.constraintLayout.setBackgroundColor(context.resources.getColor(R.color.light_sky_blue))
            }

            numberType == NumberType.MULTIPLES_OF_THREE && number % 3 == 0 -> {
                holder.binding.constraintLayout.setBackgroundColor(context.resources.getColor(R.color.light_pink))
            }

            else -> {
                holder.binding.constraintLayout.setBackgroundColor(context.resources.getColor(R.color.white))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    enum class NumberType {
        EVEN, ODD, PRIME, FIBONACCI, PERFECT_SQUARE, PALINDROME, MULTIPLES_OF_THREE, ALL
    }
}