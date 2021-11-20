package co.coinwix.UI.NavFragments

import CustomAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.coinwix.R
import co.coinwix.topCurrency.model

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashBoardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashBoardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        recycler view for top Currencies
        val topCurrencyRecyclerView = view.findViewById<RecyclerView>(R.id.topCurrName)
        val layoutManager = LinearLayoutManager(activity , RecyclerView.HORIZONTAL , false)
        topCurrencyRecyclerView.layoutManager = layoutManager
        val data = ArrayList<model>()
        data.add(model("BTC"))
        data.add(model("ETH"))
        data.add(model("LRC"))
        data.add(model("DOGE"))
        data.add(model("SHI"))
        data.add(model("LTE"))
        data.add(model("WZX"))
        data.add(model("WIN"))
        val adapter = CustomAdapter(data)
        topCurrencyRecyclerView.adapter = adapter
//        running top currency view in loop
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(object : Runnable {
            override fun run() {

                if (layoutManager.findFirstCompletelyVisibleItemPosition() < adapter.itemCount - 1){
                    layoutManager.smoothScrollToPosition( topCurrencyRecyclerView , RecyclerView.State() , layoutManager.findLastVisibleItemPosition() + 1)
                }else if(layoutManager.findFirstCompletelyVisibleItemPosition() == adapter.itemCount - 1){
                    // layoutManager.smoothScrollToPosition( topCurrencyRecyclerView , RecyclerView.State() , 0)
                    topCurrencyRecyclerView.scrollToPosition( 0)
                }
                mainHandler.postDelayed(this, 10000 )
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashBoardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashBoardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}