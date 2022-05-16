package com.example.pincode

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity(R.layout.activity_result) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.buttonShare).setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, getString(R.string.profile_name_title))
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }
        findViewById<Button>(R.id.buttonEmail).setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "*/*"
                putExtra(Intent.EXTRA_EMAIL, "azatserzhan@gmail.com")
            }
            startActivity(intent)
        }
        findViewById<Button>(R.id.buttonCall).setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${getString(R.string.phone_number)}")
            }
            startActivity(intent)

        }
        findViewById<Button>(R.id.buttonCamera).setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }
}