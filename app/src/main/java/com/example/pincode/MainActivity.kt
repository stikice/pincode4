package com.example.pincode

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import android.os.Vibrator
import java.util.*

private const val KEY_COUNTER = "COUNTER"
private const val KEY_COLOR = "COLOR"
class MainActivity : AppCompatActivity() {
    //can be val
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pin: TextView = findViewById(R.id.pin)

        savedInstanceState?.getString(KEY_COUNTER)?.let { counter ->
            pin.text = counter
        }

        savedInstanceState?.getInt(KEY_COLOR)?.let { color ->
            pin.setTextColor(color)
        }

        val b1: Button = findViewById(R.id.button1)
        val b2: Button = findViewById(R.id.button2)
        val b3: Button = findViewById(R.id.button3)
        val b4: Button = findViewById(R.id.button4)
        val b5: Button = findViewById(R.id.button5)
        val b6: Button = findViewById(R.id.button6)
        val b7: Button = findViewById(R.id.button7)
        val b8: Button = findViewById(R.id.button8)
        val b9: Button = findViewById(R.id.button9)
        val b0: Button = findViewById(R.id.button0)
        val bc: Button = findViewById(R.id.buttonC)
        val ok: Button = findViewById(R.id.buttonOK)

        b1.setOnClickListener(){
//          pin.text = pin.text.toString() + b1.text.toString()
            pin.append("1") //записывает в buffer
        }
        b2.setOnClickListener(){
//            pin.text = pin.text.toString() + b2.text.toString()
            pin.append("2")
        }
        b3.setOnClickListener(){
//            pin.text = pin.text.toString() + b3.text.toString()
            pin.append("3")
        }
        b4.setOnClickListener(){
//            pin.text = pin.text.toString() + b4.text.toString()
            pin.append("4")
        }
        b5.setOnClickListener(){
//            pin.text = pin.text.toString() + b5.text.toString()
            pin.append("5")
        }
        b6.setOnClickListener(){
//            pin.text = pin.text.toString() + b6.text.toString()
            pin.append("6")
        }
        b7.setOnClickListener(){
//            pin.text = pin.text.toString() + b7.text.toString()
            pin.append("7")
        }
        b8.setOnClickListener(){
//            pin.text = pin.text.toString() + b8.text.toString()
            pin.append("8")
        }
        b9.setOnClickListener(){
//            pin.text = pin.text.toString() + b9.text.toString()
            pin.append("9")
        }
        b0.setOnClickListener(){
//            pin.text = pin.text.toString() + b0.text.toString()
            pin.append("0")
        }
        ok.setOnClickListener(){
            if(pin.text.contentEquals(getString(R.string.pin))){
                pin.setTextColor(ContextCompat.getColor(this, R.color.blue))
                Toast.makeText(this, getString(R.string.correct_text), Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                startActivity(intent)
            }else{
                pin.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
                pin.setTextColor(ContextCompat.getColor(this, R.color.red))
            }
            /*if(pin.text.equals(getString(R.string.pin))){
                Toast.makeText(this, getString(R.string.correct_text), Toast.LENGTH_SHORT).show()
            }*/

            //OK
        }
        bc.setOnClickListener(){
            if(pin.text.isNotEmpty()){
                pin.text = pin.text.substring(0, pin.text.length-1)
            }
        }
        bc.setOnLongClickListener() {
            if(pin.text.isNotEmpty()){
                pin.text = ""
            }
            return@setOnLongClickListener true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val pin: TextView = findViewById(R.id.pin)
        outState.putString(KEY_COUNTER, pin.text.toString())
        outState.putInt(KEY_COLOR, pin.currentTextColor)
    }
}