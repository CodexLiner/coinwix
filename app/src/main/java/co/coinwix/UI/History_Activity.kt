package co.coinwix.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import co.coinwix.R
import co.coinwix.UI.NavFragments.DashBoardFragment
import co.coinwix.UI.NavFragments.historyAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class History_Activity : AppCompatActivity() {
    var bottomNavigationView : BottomNavigationView ? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
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


                }
                R.id.SettingButtonNva -> {
                    val intent = Intent(this , setting_activity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)

                }
            }
            true
        }
        val historyTabLayout =  findViewById<TabLayout>(R.id.history_tablayout)
        val historyViewPager =  findViewById<ViewPager>(R.id.histor_tab_pager)
        //making tabs

        historyTabLayout!!.addTab(historyTabLayout.newTab().setText("Buy/Sell"))
        historyTabLayout.addTab(historyTabLayout.newTab().setText("Deposit"))
        historyTabLayout.addTab(historyTabLayout.newTab().setText("Withdraw"))

        // attaching viewpager with tablelayout
        val adapter = historyAdapter(this,  supportFragmentManager)
        historyViewPager.adapter = adapter
        historyViewPager!!.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                historyTabLayout
            )
        )
        historyTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    historyViewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                return
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                return
            }

        })
    }
    override fun onResume() {
        super.onResume()
        bottomNavigationView?.selectedItemId = R.id.HistoryButtonNav
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(0,0)
    }

}