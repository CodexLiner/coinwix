package co.coinwix.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import co.coinwix.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        send otp button click event
        var buttonSendOtpp  = findViewById(R.id.send_otp_button) as Button
        buttonSendOtpp.setOnClickListener {
           var intent = Intent( this , otp_activity::class.java)
            startActivity(intent)
        }
    }
}