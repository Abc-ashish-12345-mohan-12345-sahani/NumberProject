package com.numberapplication

object Utils {

    fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        for (i in 2..Math.sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) return false
        }
        return true
    }

    fun isFibonacci(number: Int): Boolean {
        val perfectSquare1 = 5 * number * number + 4
        val perfectSquare2 = 5 * number * number - 4
        return isPerfectSquare(perfectSquare1) || isPerfectSquare(perfectSquare2)
    }

    fun isPerfectSquare(number: Int): Boolean {
        val sqrt = Math.sqrt(number.toDouble()).toInt()
        return sqrt * sqrt == number
    }
}