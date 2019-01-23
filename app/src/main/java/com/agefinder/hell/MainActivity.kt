package com.agefinder.hell

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // https://color.adobe.com/CS04-color-theme-1994456/edit/?copy=true&base=2&rule=Custom&selected=4&name=Copy%20of%20CS04&mode=rgb&rgbvalues=0.964706,0.968627,0.572549,0.199289,0.215578,0.27,0.465992,0.768536,0.827451,0.854902,0.929412,0.886275,0.917647,0.179088,0.287378&swatchOrder=0,1,2,3,4
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer:Int = 1


    fun buSelect(view:View){


        var butSelected = view as Button
        var callID = 0
        when(butSelected.id){
            R.id.bt1 -> callID = 1
            R.id.bt2 -> callID = 2
            R.id.bt3 -> callID = 3
            R.id.bt4 -> callID = 4
            R.id.bt5 -> callID = 5
            R.id.bt6 -> callID = 6
            R.id.bt7 -> callID = 7
            R.id.bt8 -> callID = 8
            R.id.bt9 -> callID = 9
        }

        //Log.d("cellId : ", callID.toString())
        //butSelected.setBackgroundResource(R.color.pink)



        PlayGame(callID, butSelected)

    }

    fun checkWinner(){

        var winner = -1

        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }



        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }



        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if(winner != -1){
            if(winner == 1){
                Toast.makeText(this, "Player1 Win the game", Toast.LENGTH_LONG).show()
            }else{Toast.makeText(this, "Player2 Win the game", Toast.LENGTH_LONG).show()}
        }


    }


    fun PlayGame(callID:Int, butSelected:Button){

        if (activePlayer == 1){
            butSelected.text = "X"
            butSelected.setBackgroundResource(R.color.pink)
            player1.add(callID)
            //Thread.sleep(1000)
            //autoplay()
            activePlayer = 2
        }else{
            butSelected.text = "O"
            butSelected.setBackgroundResource(R.color.colorPrimaryDark)
            player2.add(callID)
            activePlayer = 1
        }

        butSelected.isEnabled = false
        checkWinner()

    }

    /*fun autoplay(){

        val emptyCell = ArrayList<Int>()
        for(cell in 1..9){
            if(!(player1.contains(cell) || player2.contains(cell)))
                emptyCell.add(cell)
        }

        val r = Random()
        val randomIndex = r.nextInt(emptyCell.size)
        val cellId = emptyCell[randomIndex]
        var butSelect:Button?
        when(cellId){
            1-> butSelect = bt1
            2-> butSelect = bt2
            3-> butSelect = bt3
            4-> butSelect = bt4
            5-> butSelect = bt5
            6-> butSelect = bt6
            7-> butSelect = bt7
            8-> butSelect = bt8
            9-> butSelect = bt8
            else->{
                butSelect = bt1
            }
        }
        PlayGame(cellId, butSelect)
    }*/
}
