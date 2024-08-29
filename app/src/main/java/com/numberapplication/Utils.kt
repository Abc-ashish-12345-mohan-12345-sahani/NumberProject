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

    fun isPalindrome(number: Int): Boolean {
        val str = number.toString()
        return str == str.reversed()
    }

    fun numberToWord(number: Int): String {
        val words = mapOf(
            1 to "One", 2 to "Two", 3 to "Three", 4 to "Four", 5 to "Five",
            6 to "Six", 7 to "Seven", 8 to "Eight", 9 to "Nine", 10 to "Ten",
            11 to "Eleven", 12 to "Twelve", 13 to "Thirteen", 14 to "Fourteen", 15 to "Fifteen",
            16 to "Sixteen", 17 to "Seventeen", 18 to "Eighteen", 19 to "Nineteen", 20 to "Twenty",
            21 to "Twenty-One", 22 to "Twenty-Two", 23 to "Twenty-Three", 24 to "Twenty-Four", 25 to "Twenty-Five",
            26 to "Twenty-Six", 27 to "Twenty-Seven", 28 to "Twenty-Eight", 29 to "Twenty-Nine", 30 to "Thirty",
            31 to "Thirty-One", 32 to "Thirty-Two", 33 to "Thirty-Three", 34 to "Thirty-Four", 35 to "Thirty-Five",
            36 to "Thirty-Six", 37 to "Thirty-Seven", 38 to "Thirty-Eight", 39 to "Thirty-Nine", 40 to "Forty",
            41 to "Forty-One", 42 to "Forty-Two", 43 to "Forty-Three", 44 to "Forty-Four", 45 to "Forty-Five",
            46 to "Forty-Six", 47 to "Forty-Seven", 48 to "Forty-Eight", 49 to "Forty-Nine", 50 to "Fifty",
            51 to "Fifty-One", 52 to "Fifty-Two", 53 to "Fifty-Three", 54 to "Fifty-Four", 55 to "Fifty-Five",
            56 to "Fifty-Six", 57 to "Fifty-Seven", 58 to "Fifty-Eight", 59 to "Fifty-Nine", 60 to "Sixty",
            61 to "Sixty-One", 62 to "Sixty-Two", 63 to "Sixty-Three", 64 to "Sixty-Four", 65 to "Sixty-Five",
            66 to "Sixty-Six", 67 to "Sixty-Seven", 68 to "Sixty-Eight", 69 to "Sixty-Nine", 70 to "Seventy",
            71 to "Seventy-One", 72 to "Seventy-Two", 73 to "Seventy-Three", 74 to "Seventy-Four", 75 to "Seventy-Five",
            76 to "Seventy-Six", 77 to "Seventy-Seven", 78 to "Seventy-Eight", 79 to "Seventy-Nine", 80 to "Eighty",
            81 to "Eighty-One", 82 to "Eighty-Two", 83 to "Eighty-Three", 84 to "Eighty-Four", 85 to "Eighty-Five",
            86 to "Eighty-Six", 87 to "Eighty-Seven", 88 to "Eighty-Eight", 89 to "Eighty-Nine", 90 to "Ninety",
            91 to "Ninety-One", 92 to "Ninety-Two", 93 to "Ninety-Three", 94 to "Ninety-Four", 95 to "Ninety-Five",
            96 to "Ninety-Six", 97 to "Ninety-Seven", 98 to "Ninety-Eight", 99 to "Ninety-Nine", 100 to "One Hundred"
        )
        return words[number] ?: number.toString()
    }
}