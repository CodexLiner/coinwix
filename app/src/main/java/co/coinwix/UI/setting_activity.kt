package co.coinwix.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.coinwix.R
import co.coinwix.UI.NavFragments.DashBoardFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class setting_activity : AppCompatActivity() {
    var bottomNavigationView : BottomNavigationView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView?.selectedItemId = R.id.homeButtonNav
// setting bottom Navigation Bar
        bottomNavigationView?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeButtonNav -> {
                    val intent = Intent(this , home_activity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)
                }
                R.id.ExchangeButtonNav -> {
                    val intent = Intent(this , exchnage_activity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)

                }
                R.id.HistoryButtonNav -> {
                    val intent = Intent(this , History_Activity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)

                }
                R.id.SettingButtonNva -> {


                }
            }
            true
        }

    }
    override fun onResume() {
        super.onResume()
        bottomNavigationView?.selectedItemId = R.id.SettingButtonNva
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(0,0)
    }
}