package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun bClick(view: View){
        val button: Button = view as Button
        var cid = 0
        when(button.id) {
            R.id.button1 -> cid = 1
            R.id.button2 -> cid = 2
            R.id.button3 -> cid = 3
            R.id.button4 -> cid = 4
            R.id.button5 -> cid = 5
            R.id.button6 -> cid = 6
            R.id.button7 -> cid = 7
            R.id.button8 -> cid = 8
            R.id.button9 -> cid = 9
        }
        mark(cid, button)
    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer: Int = 1
    private fun mark(cid: Int, button: Button) {
        if(activePlayer == 1) {
            button.text = "X"
            button.setBackgroundColor(Color.RED)
            player1.add(cid)
            activePlayer = 2
        }
        else {
            button.text = "O"
            button.setBackgroundColor(Color.BLUE)
            player2.add(cid)
            activePlayer = 1
        }
        button.isEnabled = false
        checkWinner()
    }
    private fun checkWinner() {
        var winner = -1
        if((player1.contains(1) && player1.contains(2) && player1.contains(3))||(player1.contains(4) && player1.contains(5) && player1.contains(6))
            ||(player1.contains(7) && player1.contains(8) && player1.contains(9))||(player1.contains(1) && player1.contains(4) && player1.contains(7))||
            (player1.contains(2) && player1.contains(5) && player1.contains(8))||(player1.contains(3) && player1.contains(6) && player1.contains(9))||
            (player1.contains(1) && player1.contains(2) && player1.contains(3))||(player1.contains(1) && player1.contains(5) && player1.contains(9))||(player1.contains(3) && player1.contains(5) && player1.contains(7))) {
            winner = 1
        }
        if((player2.contains(1) && player2.contains(2) && player2.contains(3))||(player2.contains(4) && player2.contains(5) && player2.contains(6))
            ||(player2.contains(7) && player2.contains(8) && player2.contains(9))||(player2.contains(1) && player2.contains(4) && player2.contains(7))||
            (player2.contains(2) && player2.contains(5) && player2.contains(8))||(player2.contains(3) && player2.contains(6) && player2.contains(9))||
            (player2.contains(1) && player2.contains(2) && player2.contains(3))||(player2.contains(1) && player2.contains(5) && player2.contains(9))||(player2.contains(3) && player2.contains(5) && player2.contains(7))) {
            winner = 2
        }
        if(winner == 1) {
            Toast.makeText(this,"Player 1 is the Winner", Toast.LENGTH_SHORT).show()
        }
        if(winner==2) {
            Toast.makeText(this,"Player 2 is the Winner", Toast.LENGTH_SHORT).show()
        }
    }
}