package com.xrest.tikrak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity() {
    var player = mutableListOf<Int>()
    var player2= mutableListOf<Int>()
    var symbol ='X'
    var type ="player"


    var p1 =0
    var p2=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }

    fun check(){





        var row = mutableListOf<Int>(1,2,3)
       var mrow = mutableListOf<Int>(4,5,6)
       var lrow = mutableListOf<Int>(7,8,9)
       var col = mutableListOf<Int>(1,4,7)
       var mcol = mutableListOf<Int>(2,5,8)
       var lcol = mutableListOf<Int>(3,6,9)
        var cross = mutableListOf<Int>(1,5,9)
        var cross2 = mutableListOf<Int>(3,5,7)
var p11 :TextView= findViewById(R.id.p1)
var p22 :TextView = findViewById(R.id.p2)
        var ans = mutableListOf<List<Int>>(row,mrow,lrow,col,mcol,lcol,cross,cross2)


            for (l in ans) {
                if (player.containsAll(l)) {

                    Toast.makeText(applicationContext, "Winner is Player1", Toast.LENGTH_LONG).show()
                    p1 += 1
                    reset()



                } else if (player2.containsAll(l)) {

                    Toast.makeText(applicationContext, "Winner is Player2", Toast.LENGTH_LONG).show()
                    p2 += 1

                    reset()


                } else if (player.size + player2.size == 9) {
                    Toast.makeText(applicationContext, "Draw", Toast.LENGTH_SHORT).show()

reset()
                }


            }

p11.text ="Player1: ${p1.toString()}"
p22.text ="Player2: ${p2.toString()}"
        if(p1+p2==5)
        {
            if(p1>p2)
            {
                p11.text = "Player1:W"
                p22.text ="Player2:L"
            }
            else if(p2>p1)
            {
                p22.text = " Player2:W"
                p11.text ="Player1:L"

            }
            var b: Button = findViewById(R.id.reset)
            b.isVisible=true
            b.setOnClickListener(){
                p1=0
                p2=0

                reset()
                p11.text=""
                p22.text=""

                b.isVisible=false
            }

        }




        }
fun reset(){

    var btn1: Button = findViewById(R.id.btn1)
    var btn2: Button = findViewById(R.id.btn2)
    var btn3: Button = findViewById(R.id.btn3)
    var btn4: Button = findViewById(R.id.btn4)
    var btn5: Button = findViewById(R.id.btn5)
    var btn6: Button = findViewById(R.id.btn6)
    var btn7: Button = findViewById(R.id.btn7)
    var btn8: Button = findViewById(R.id.btn8)
    var btn9: Button = findViewById(R.id.btn9)

    player.clear()
    player2.clear()
    btn1.text =""
    btn1.isEnabled=true
    type="player"
    btn2.isEnabled=true
    btn2.text =""
    btn3.isEnabled=true
    btn3.text =""
    btn4.isEnabled=true
    btn4.text =""
    btn5.isEnabled=true
    btn5.text =""
    btn6.isEnabled=true
    btn6.text =""
    btn7.isEnabled=true
    btn7.text =""
    btn8.isEnabled=true
    btn8.text =""
    btn9.isEnabled=true
    btn9.text =""
}

    fun btnClick(view: View) {

        var click =0
        val tbns: Button = view as Button

        when(tbns.id)
        {
           R.id.btn1->click =1
            R.id.btn2->click =2
          R.id.btn3->click =3
            R.id.btn4->click =4
            R.id.btn5->click =5
            R.id.btn6->click =6
            R.id.btn7->click =7
            R.id.btn8->click =8
            R.id.btn9->click =9

        }
        Log.d("",tbns.id.toString())

        play(click,tbns)
    }

    fun play(click: Int,tbns:Button)
    {
        if(type.equals("player"))
        {

            symbol='X'
            tbns.text = symbol.toString()
            player.add(click)

            tbns.isEnabled = false
            type="player2"
            check()


        }
        else if(type.equals("player2"))
        {

            symbol ='O'
            tbns.text =symbol.toString()
            player2.add(click)


            tbns.isEnabled = false
            type="player"
            check()

        }


    }


}