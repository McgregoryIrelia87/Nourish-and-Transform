// Defining the main function
def nourishAndTransform ( ) : Unit = {

// 1. Printing a message to the console
println("Let's nourish and transform the world!")

// 2. Defining a function to calculate the sum of a list of integers
def sumList(list: List[Int]): Int = {
   if (list.isEmpty) 0
   else list.head + sumList(list.tail)
}

// 3. Declaring an array of integers
val list = Array(3, 9, 12, 22)

// 4. Computing the sum of the array elements
val total = sumList(list.toList)

// 5. Printing the total to the console
println("The sum of all the numbers is: "+total)

// 6. Defining a function to multiply all elements of a list
def multiplyList(list: List[Int], factor: Int): List[Int] = {
   if (list.isEmpty) Nil
   else List(list.head * factor) ++ multiplyList(list.tail, factor)
}

// 7. Creating a new list with doubled elements
val listDoubled = multiplyList(list.toList, 2)

// 8. Printing the new list to the console
println("The double of the numbers is: "+listDoubled.mkString(","))

// 9. Defining a function to apply a given operation to each element of a given list
def applyOperation(list: List[Int], operation: (Int) => (Int)): List[Int] = {
   if (list.isEmpty) Nil
   else List(operation(list.head)) ++ applyOperation(list.tail, operation)
}

// 10. Defining a function to square a given number
def squareNum(num: Int): Int = {
   num * num
}

// 11. Applying the square function to all elements of the original list
val listSquared = applyOperation(list.toList, squareNum)

// 12. Printing the new list to the console
println("The squares of the elements is: "+listSquared.mkString(","))

// 13. Defining a function to calculate the maximum of a given list
def maxList(list: List[Int]): Int = {
   if (list.isEmpty) Int.MinValue
   else {
      val headMax = maxList(list.tail)
      if (list.head > headMax) list.head
      else headMax
   }
}

// 14. Calculating the maximum of the original list
val max = maxList(list.toList)

// 15. Printing the maximum to the console
println("The maximum of the elements is: "+max)

// 16. Defining a function to calculate the minimum of a given list
def minList(list: List[Int]): Int = {
   if (list.isEmpty) Int.MaxValue
   else {
      val headMin = minList(list.tail)
      if (list.head < headMin) list.head
      else headMin
   }
}

// 17. Calculating the minimum of the list
val min = minList(list.toList)

// 18. Printing the minimum to the console
println("The minimum of the elements is: "+min)

// 19. Defining a function to reverse a given list
def reverseList(list: List[Int]): List[Int] = {
   if (list.isEmpty) Nil
   else reverseList(list.tail) ++ List(list.head)
}

// 20. Reversing the original list
val listReversed = reverseList(list.toList)

// 21. Printing the reversed list to the console
println("The reversed list is: "+listReversed.mkString(","))

// 22. Defining a function to compute the average of a given list
def averageList(list: List[Int]): Double = {
   if (list.isEmpty) 0.0
   else list.reduce(_+_).toDouble / list.size
}

// 23. Calculating the average of the list
val average = averageList(list.toList)

// 24. Printing the average to the console
println("The average of the elements is: "+average)

// 25. Defining a function to remove all duplicate elements from a given list
def removeDuplicates(list: List[Int]): List[Int] = {
   if (list.isEmpty) Nil
   else if (!list.tail.contains(list.head)) List(list.head) ++ removeDuplicates(list.tail)
   else removeDuplicates(list.tail)
}

// 26. Removing all duplicate elements from the list
val listNoDuplicates = removeDuplicates(list.toList)

// 27. Printing the new list to the console
println("The list with no duplicates is: "+listNoDuplicates.mkString(","))

// 28. Defining a function to sort a given list
def sortList(list: List[Int]): List[Int] = {
   if (list.isEmpty || list.tail.isEmpty) list
   else {
      val pivot = list.head
      val smaller = sortList(list.tail.filter(_<pivot))
      val larger = sortList(list.tail.filter(_>=pivot))
      smaller ++ List(pivot) ++ larger
   }
}

// 29. Sorting the list
val sortedList = sortList(list.toList)

// 30. Printing the sorted list to the console
println("The sorted list is: "+sortedList.mkString(","))

// 31. Defining a function to check if a given number is prime
def isPrime(num: Int): Boolean = {
   if (num < 2) false
   else if (num == 2) true
   else !(2 to Math.sqrt(num).toInt).exists(num % _ == 0)
}

// 32. Defining a function to filter prime numbers
def filterPrimes(list: List[Int]): List[Int] = { 
   if (list.isEmpty) Nil
   else if (isPrime(list.head)) List(list.head) ++ filterPrimes(list.tail)
   else filterPrimes(list.tail)
}

// 33. Filtering prime numbers from the original list
val listPrimes = filterPrimes(list.toList)

// 34. Printing the prime numbers to the console
println("The prime numbers in the list are: "+listPrimes.mkString(","))

// 35. Defining a function to calculate the greatest common divisor
def getGCD(a: Int, b: Int): Int = {
   if (b == 0) a
   else getGCD(b, a%b)
}

// 36. Defining a function to calculate the least common multiple
def getLCM(a: Int, b: Int): Int = {
   (a*b)/getGCD(a,b)
}

// 37. Calculating the greatest common divisor of the list
val gcd = list.foldLeft(list.head)(getGCD)

// 38. Calculating the least common multiple of the list
val lcm = list.foldLeft(list.head)(getLCM)

// 39. Printing the GCD and LCM to the console
println("The greatest common divisor is: "+gcd)
println("The least common multiple is: "+lcm)

// 40. Defining a function to check if a given number is palindrome
def isPalindrome(num: Int): Boolean = {
   num.toString == num.toString.reverse
}

// 41. Defining a function to filter out palindromes
def filterPalindromes(list: List[Int]): List[Int] = {
   if (list.isEmpty) Nil
   else if (isPalindrome(list.head)) List(list.head) ++ filterPalindromes(list.tail)
   else filterPalindromes(list.tail)
}

// 42. Filtering out palindromes from the list
val listPalindromes = filterPalindromes(list.toList)

// 43. Printing the palindromes to the console
println("The palindromes in the list are: "+listPalindromes.mkString(","))

// 44. Defining a function to calculate the Fibonacci of a given number
def getFibonacci(num: Int): Int = {
   if (num == 0) 0
   else if (num == 1) 1
   else getFibonacci(num-1) + getFibonacci(num-2)
}

// 45. Defining a function to get the first n Fibonacci numbers
def getFibonacciSeries(n: Int): List[Int] = { 
   if (n <= 0) Nil
   else List(getFibonacci(n)) ++ getFibonacciSeries(n-1) 
} 

// 46. Getting the first 10 Fibonacci numbers
val fibonacciSeries = getFibonacciSeries(10)

// 47. Printing the Fibonacci series to the console
println("The first 10 Fibonacci numbers are: "+fibonacciSeries.mkString(","))

// 48. Defining a function to find the nth element of the Fibonacci series
def getNthFibonacci(n: Int): Int = {
   if (n == 0) 0
   else if (n == 1) 1
   else getFibonacci(n-1) + getFibonacci(n-2)
}

// 49. Computing the 9th Fibonacci number
val nthFibonacci = getNthFibonacci(9)

// 50. Printing the 9th Fibonacci number to the console
println("The 9th Fibonacci number is: "+nthFibonacci)

// 51. Defining a function to calculate the factorial of a given number
def getFactorial(num: Int): Int = { 
   if (num == 0) 1
   else num * getFactorial(num - 1) 
} 

// 52. Computing the factorial of 5
val factorial = getFactorial(5)

// 53. Printing the factorial of 5 to the console
println("The factorial of 5 is: "+factorial)

// 54. Defining a function to calculate the sum of factorials of all numbers in a given list
def sumOfFactorials(list: List[Int]): Int = { 
   if (list.isEmpty) 0
   else getFactorial(list.head) + sumOfFactorials(list.tail) 
}

// 55. Computing the sum of factorials of the list
val sumFactorials = sumOfFactorials(list.toList)

// 56. Printing the sum of factorials to the console
println("The sum of factorials is: "+sumFactorials)

// 57. Defining a function to calculate the sum of the first n natural numbers
def sumNaturalNumbers(n: Int): Int = {
   if (n == 0) 0
   else n + sumNaturalNumbers(n-1)
}

// 58. Computing the sum of the first 10 natural numbers
val sumNaturalNumbers10 = sumNaturalNumbers(10)

// 59. Printing the sum to the console
println("The sum of the first 10 natural numbers is: "+sumNaturalNumbers10)

// 60. Defining a function to calculate the sum of squares of a given list
def sumOfSquare(list: List[Int]): Int = {
   if (list.isEmpty) 0
   else list.head * list.head + sumOfSquare(list.tail)
}

// 61. Computing the sum of squares of the list
val sumOfSquareElements = sumOfSquare(list.toList)

// 62. Printing the sum of squares to the console
println("The sum of squares of the elements is: "+sumOfSquareElements)

// 63. Defining a function to calculate the product of all elements of a list
def productList(list: List[Int]): Int = {
   if (list.isEmpty) 1
   else list.head * productList(list.tail)
}

// 64. Calculating the product of all elements of the list
val product = productList(list.toList)

// 65. Printing the product to the console
println("The product of all the elements is: "+product)

// 66. Defining a function to check if a given number is Armstrong
def isArmstrong(num: Int): Boolean = {
   val digits = num.toString.map(_.asDigit).toList
   val len = digits.length
   val sumDigitsPowLen = sumOfPower(digits, len)
   num == sumDigitsPowLen
}

// 67. Defining a function to compute the sum of the power of each element of a list
def sumOfPower(list: List[Int], n: Int): Int = {
   if (list.isEmpty) 0
   else power(list.head, n) + sumOfPower(list.tail, n)
}

// 68. Defining a function to compute the power of a number
def power(x: Int, n: Int): Int = {
   if (n == 0) 1
   else x * power(x, n-1)
}

// 69. Computing the Armstrong numbers in the list
val listArmstrong = list.filter(isArmstrong(_)).toList

// 70. Printing the Armstrong numbers to the console
println("The Armstrong numbers in the list are: "+listArmstrong.mkString(","))

// 71. Defining a function to calculate the number of element occurrences
def countElements(list: List[Int], element: Int): Int = {
   if (list.isEmpty) 0
   else if (list.head == element) 1 + countElements(list.tail, element)
   else countElements(list.tail, element)
}

// 72. Computing the number of occurrences of 6 in the list
val countElementSix = countElements(list.toList, 6)

// 73. Printing the number of occurrences to the console
println("The number of occurrences of 6 is: "+countElementSix)

// 74. Defining a function to calculate the sum of the digits of a given number
def sumOfDigits(num: Int): Int = {
   if (num == 0) 0
   else num%10 + sumOfDigits(num/10)
}

// 75. Computing the sum of digits of 12345
val sumDigits12345 = sumOfDigits(12345)

// 76. Printing the sum of digits to the console
println("The sum of digits of 12345 is: "+sumDigits12345)

// 77. Defining a function to calculate the sum of all multi