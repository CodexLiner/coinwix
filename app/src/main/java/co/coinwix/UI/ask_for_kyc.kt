package co.coinwix.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import co.coinwix.R

class ask_for_kyc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ask_for_kyc)
        val homeButton = findViewById<Button>(R.id.homeButton)
        val kycButton = findViewById<Button>(R.id.completeKycButton)
        kycButton.setOnClickListener{
            starthome()
        }
        homeButton.setOnClickListener{
            starthome()
        }
    }
    fun starthome() {
        val intent =  Intent(this , home_activity::class.java)
        startActivity(intent)
    }
}