package co.coinwix.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import co.coinwix.R

class otp_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        var submitOtpButon = findViewById(R.id.submit_otp_button) as Button

//        continue button on click event
        submitOtpButon.setOnClickListener{
            var intent = Intent(this , ask_for_kyc::class.java)
            startActivity(intent)
        }
    }
}