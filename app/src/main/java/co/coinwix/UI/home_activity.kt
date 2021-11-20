package co.coinwix.UI

import CustomAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.coinwix.R
import co.coinwix.UI.NavFragments.DashBoardFragment
import co.coinwix.UI.NavFragments.ExchangeFragment
import co.coinwix.UI.NavFragments.HistoryFragment
import co.coinwix.UI.NavFragments.SettingFragment
import co.coinwix.UI.exchnage_activity

import co.coinwix.topCurrency.model
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.collections.ArrayList

class home_activity : AppCompatActivity() {
    var bottomNavigationView : BottomNavigationView ? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView?.selectedItemId = R.id.homeButtonNav
// setting bottom Navigation Bar
        setFragment(DashBoardFragment())
        bottomNavigationView?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeButtonNav -> {

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
                    val intent = Intent(this , setting_activity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)

                }
            }
            true
        }

    }

    override fun onResume() {
        super.onResume()
        bottomNavigationView?.selectedItemId = R.id.homeButtonNav
    }

    override fun onBackPressed() {

    }
    private fun setFragment(fragment: Fragment) {
        if (fragment != null) {
            supportFragmentManager.beginTransaction().apply() {
                replace(R.id.NavFrameLayout, fragment)
                addToBackStack(null);
                commit()

            }
        }
    }
}