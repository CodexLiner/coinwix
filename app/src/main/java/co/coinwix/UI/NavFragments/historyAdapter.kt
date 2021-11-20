package co.coinwix.UI.NavFragments

import android.content.Context
import android.icu.text.CaseMap
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle

class historyAdapter(val Contex: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            1 -> {
                return BuySellFragment()
            }
            2 -> {
                return DepositFragment()
            }
            else -> {
                return WithdrawFragment()
            }
        }
    }

//    val mList : ArrayList<String> = ArrayList();
//    val fList : ArrayList<Fragment> = ArrayList();
//
//
//
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return mList[position]
//    }
//    override fun getCount(): Int {
//        Log.d("TAG", "getCount: "+fList.size)
//        return fList.size
//    }
//
//    override fun getItem(position: Int): Fragment {
//       return fList[position]
//    }
//    fun addFragment(fragment: Fragment , title: String ){
//        fList.add(fragment)
//        mList.add(title)
//    }

}