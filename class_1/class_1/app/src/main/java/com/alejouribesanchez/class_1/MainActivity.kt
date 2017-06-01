package com.alejouribesanchez.class_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Hello, world kotlin!")

        //Explicit Types
        val double:Double = 70.0
        println(double)

        //Type Coercion
        val label = "the widht is"
        val width = 94
        val widthLabel = label + width
        println(widthLabel)

        //String interpolation
        val knight = 3
        val rook = 5
        val pointSummary = "I have ${knight + rook} " + "points"
        println(pointSummary)

        //Range Operator
        val names = arrayOf("Kasparov","Fisher","Karpov","Capablanca")
        val count = names.count()
        println(count)
        val count2 = names.size
        println(count2)

        for(i in 0..count-1){
            println("Person ${i + 1} is called ${names[i]}")
        }

        //Inclusive Range Operator
        for(index in 1..5) {
            println("$index times 5 is ${index*5}")
        }

        //Arrays
        val piecesList = arrayOf("Queen", "King", "Rook", "Pawn", "Bishop", "Knight")
        piecesList[1] = "King"
        println(piecesList)

        //Maps
        val occupations  = mutableMapOf("King" to "0", "Queen" to "10", "Rook" to 5f)
        occupations["Pawn"] = "1"
        println(occupations)

        //Empty Collections
        val emptyArray = arrayOf<String>()
        val emptyMap = mapOf<String, Float>()

        //Functions
        picesValue("Knight", 3f)
        picesValue("Rook",occupations["Rook"] as Float)

        //Tuple Return
        println(getPiecesValues().queen)
        println(getPiecesValues().bishop)
        println(getPiecesValues().pawn)

        //Variable number of arguments
        println(sumOf(42, 234, 23, 5))
        println(sumOf(1,2,3))
        println(sumOf(5))
        println(sumOfshort(42, 234, 23, 5))
        println(sumOfshort(1,2,3))
        println(sumOfshort(5))

        //Function Type
        val increment = makeIncrementer()
        increment(7)
        val incrementShort = makeIncrementerShort()
        incrementShort(7)

        //MAP
        val numbers = listOf(1,2,3,4,5,6)
        numbers.map {3 * it}
        println("Map: $numbers")

        //SORT
        val orderList = listOf(3,4,1,2).sorted()
        println(orderList)

        //NamedArguments
        val a = area(width=2, height = 3)
        val b = area(height = 3, width=2)
        val c = area(2, height = 2)

        //Classes
        var chess = Chess()
        chess.numberofSquares = 64
        println(chess.simpleDescription())

        var chess2 = ChessBoard(20.0,"Stauton")
        chess2.piecesValues()
        chess2.simpleDescription()

        //Checkking Type
        var  listPieces = arrayOf(Queen(), King(), Queen(), Queen())
        var  kingCount = 0
        var  queenCount = 0
        for(item in listPieces) {
            if(item is Queen) ++queenCount
            if(item is King) ++kingCount
        }
        println("Number of queens $queenCount")
        println("Number of kings $kingCount")

        //Pattern Matching
        val digit = 42
        numberDigits(42)

        //DownCasting
        for (current in listPieces) {
            if(current is Queen){
                println("Name: ${current.name}  position: ${current.position}")
            }
        }

        //Extensions
        val oneInch = 25.4.mm
        println("One inch is $oneInch meters")
        val threeFeet = 3.0.ft
        println("Three feet is $threeFeet meters")

    }

    //

    fun picesValue(name:String, value:Float): String {
        return "Name: $name Value: $value"
    }

    data class PiecesValues(val queen:Double, val bishop:Double, val pawn:Double)
    fun getPiecesValues() = PiecesValues(10.0,3.0,1.0)

    fun sumOf(vararg numbers: Int):Int {
        var sum = 0
        for(number in numbers) {
            sum +=number
        }
        return sum
    }

    fun sumOfshort(vararg numbers: Int) = numbers.sum()

    fun makeIncrementer(): (Int) -> Int {
        val addOne = fun(number: Int): Int {
            return 1 + number
        }
        return addOne
    }

    fun makeIncrementerShort() = fun(number: Int) = 1 + number

    fun area(width: Int, height: Int) = width*height

    class Chess {
        var numberofSquares = 0
        fun simpleDescription() = "Number of squares $numberofSquares"
    }

    class Queen {
        var value = 0
        var name = "Queen"
        var position = "d1"
    }

    class King {
        var value = 0
    }


    open class Board(val name: String) {
        var numberofSquares = 0
        open fun simpleDescription() = "Number of squares $numberofSquares"
    }

    class ChessBoard(var pieces:Double, name: String):Board(name) {
        init {
            numberofSquares = 64
        }

        fun piecesValues() = pieces
        override fun simpleDescription(): String {
            return "Number of chess squares $numberofSquares"
        }
    }

    fun numberDigits(value:Int) {
        when (value) {
            in 0..7,8,9 -> println("Single Digit")
            10 -> println("double digits")
            in 11..99 -> println("double digits")
            in 100..999 -> println("triple digits")
            else -> println("four or more digits")
        }
    }

    fun selectOffer(value:Int) {
        when (value) {
            in 0..3 -> println("Yes, I accept")
            else -> println("Yes, I accept")
        }
    }

    interface Nameable {
        fun name(): String
    }

}

//Extensions

val Double.km: Double get() = this * 1000
val Double.m: Double get() = this
val Double.cm: Double get() = this / 100
val Double.mm: Double get() = this / 1000
val Double.ft: Double get() = this / 3.28084
