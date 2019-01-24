package com.agefinder.hell

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import  kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
    }


    fun buSelect(view:View){
        val buSelected= view as Button
        var cellID=0
        when(buSelected.id){
            R.id.bt1-> cellID=1
            R.id.bt2-> cellID=2
            R.id.bt3-> cellID=3
            R.id.bt4-> cellID=4
            R.id.bt5-> cellID=5
            R.id.bt6-> cellID=6
            R.id.bt7-> cellID=7
            R.id.bt8-> cellID=8
            R.id.bt9-> cellID=9

        }
        // Toast.makeText(this,"ID:"+ cellID, Toast.LENGTH_LONG).show()

        PlayGame(cellID,buSelected)
        Thread.sleep(500)
    }

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var ActivePlayer=1

    fun PlayGame(cellID:Int,buSelected:Button){

        if(ActivePlayer==1){
            buSelected.text="X"
            buSelected.setTextColor(Color.parseColor("white"))
            buSelected.setBackgroundResource(R.color.black)
            player1.add(cellID)
            ActivePlayer=2
            //Thread.sleep(500)

            autoPlay()
        }else{
            buSelected.text="O"
            buSelected.setTextColor(Color.parseColor("black"))
            buSelected.setBackgroundResource(R.color.white)
            player2.add(cellID)
            ActivePlayer=1
        }


        buSelected.isEnabled=false
        CheckWiner()
    }



    fun  CheckWiner(){
        var winer=-1

        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winer=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winer=2
        }


        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winer=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winer=2
        }




        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winer=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winer=2
        }



        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winer=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winer=2
        }



        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winer=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winer=2
        }


        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winer=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winer=2
        }


        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winer=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winer=2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winer=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winer=2
        }

        if( winer != -1){

            if (winer==1){
                Toast.makeText(this," Player 1  win the game", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this," Computer  win the game", Toast.LENGTH_LONG).show()

            }

        }

    }

    //var buSelect:Button?=null

    fun autoPlay(){

        var buSelect:Button?=null

        val emptyCells=ArrayList<Int>()
        for ( cellID in 1..9){

            if(!( player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }


        val r=Random()
        val randIndex=r.nextInt(emptyCells.size-0)+0
        val cellID= emptyCells[randIndex]


        buSelect = when(cellID){
            1-> bt1
            2-> bt2
            3-> bt3
            4-> bt4
            5-> bt5
            6-> bt6
            7-> bt7
            8-> bt8
            9-> bt9
            else->{
                bt1
            }
        }

        //Thread.sleep(500)

        PlayGame(
            cellID,
            buSelect!!
        )

    }


}
