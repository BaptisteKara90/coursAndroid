package fr.eni.ecole.mod4tp1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class DiceGame : ViewModel() {

    private val _dice = MutableStateFlow<Int>(R.drawable.d1)
    private val _counterLeft = MutableStateFlow<Int>(0)
    private val _counterRight = MutableStateFlow<Int>(0)


    val dices = listOf(
        R.drawable.d1,
        R.drawable.d2,
        R.drawable.d3,
        R.drawable.d4,
        R.drawable.d5,
        R.drawable.d6
    )

    val counterLeft = _counterLeft.asStateFlow()
    val counterRight = _counterRight.asStateFlow()
    val dice = _dice.asStateFlow()

    var nbThrowsRight = 0
    var nbThrowsLeft = 0
    var nbThrowsAll = 0

    fun rollDiceLeft() {
        val roll = Random.nextInt(1, 7)
        _dice.value = dices[roll - 1]
        _counterLeft.value += roll
        nbThrowsLeft++
        nbThrowsAll++
    }

    fun rollDiceRight() {
        val roll = Random.nextInt(1, 7)
        _dice.value = dices[roll - 1]
        _counterRight.value += roll
        nbThrowsRight++
        nbThrowsAll++
    }

    fun reset() {
        _dice.value = dices[0]
        _counterLeft.value = 0
        _counterRight.value = 0
        nbThrowsRight = 0
        nbThrowsLeft = 0
        nbThrowsAll = 0
    }

}