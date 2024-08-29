package com.numberapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.numberapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NumbersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val numbers = (1..100).toList()
        adapter = NumbersAdapter(numbers, this@MainActivity)

        binding.recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        binding.recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_even -> {
                adapter.numberType = NumbersAdapter.NumberType.EVEN
                showSnackbar("even")
            }

            R.id.menu_odd -> {
                adapter.numberType = NumbersAdapter.NumberType.ODD
                showSnackbar("odd")
            }

            R.id.menu_prime -> {
                adapter.numberType = NumbersAdapter.NumberType.PRIME
                showSnackbar("prime")
            }

            R.id.menu_multiples_of_three -> {
                adapter.numberType = NumbersAdapter.NumberType.MULTIPLES_OF_THREE
                showSnackbar("multiples_of_three")
            }

            R.id.menu_perfect_squares -> {
                adapter.numberType = NumbersAdapter.NumberType.PERFECT_SQUARE
                showSnackbar("perfect_squares")
            }

            R.id.menu_fibonacci -> {
                adapter.numberType = NumbersAdapter.NumberType.FIBONACCI
                showSnackbar("fibonacci")
            }

            R.id.menu_palindrome -> {
                adapter.numberType = NumbersAdapter.NumberType.PALINDROME
                showSnackbar("palindrome")
            }

            else -> adapter.numberType = NumbersAdapter.NumberType.ALL
        }
        adapter.notifyDataSetChanged()
        return true
    }

    private fun showSnackbar(type: String) {
        val count = when (type) {
            "even" -> (1..100).count { it % 2 == 0 }
            "odd" -> (1..100).count { it % 2 != 0 }
            "prime" -> (1..100).count { Utils.isPrime(it) }
            "multiples_of_three" -> (1..100).count { it % 3 == 0 }
            "perfect_squares" -> (1..100).count {
                Math.sqrt(it.toDouble()).toInt() * Math.sqrt(it.toDouble()).toInt() == it
            }
            "fibonacci" -> (1..100).count { Utils.isFibonacci(it) }
            "palindrome" -> (1..100).count { Utils.isPalindrome(it) }
            else -> 0
        }

        val message = when (type) {
            "even" -> getString(R.string.total_even_numbers_is, count)
            "odd" -> getString(R.string.total_odd_numbers_is, count)
            "prime" -> getString(R.string.total_prime_numbers_is, count)
            "multiples_of_three" -> getString(R.string.total_multiples_of_3_is, count)
            "perfect_squares" -> getString(R.string.total_perfect_squares_is, count)
            "fibonacci" -> getString(R.string.total_fibonacci_numbers_is, count)
            "palindrome" -> getString(R.string.total_palindrome_numbers_is, count)
            else -> ""
        }

        val snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction(getString(R.string.dismiss)) {
            snackbar.dismiss()
        }
        snackbar.show()
    }
}
