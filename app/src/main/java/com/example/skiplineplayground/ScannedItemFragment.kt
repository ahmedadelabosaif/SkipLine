package com.example.skiplineplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ScannedItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scanned_item, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(toolbar)

            val bottomNavView = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation)
            bottomNavView?.visibility = View.GONE


            //val productCode = intent?.getStringExtra("productCode")

//        val productName = intent?.getStringExtra("productName")
//        itemNameTxt.text = "${itemNameTxt.text}دوريتوس 5ج"
//        val kind = intent?.getStringExtra("kind")
//        kindTxt.text = "${kindTxt.text}كيس"
//        val price = intent?.getStringExtra("price")
//        priceTxt.text = "${priceTxt.text}5ج"
//        val pDate = intent?.getStringExtra("pDate")
//        pDAteTxt.text = "${pDAteTxt.text}+pDate"
//        val exDate = intent?.getStringExtra("exDate")
//        exDateTxt.text = "${exDateTxt.text}+exDate"

            }

//            val addItem = activity?.findViewById<Button>(R.id.add_btn)
//            addItem?.setOnClickListener {
//
//                val transaction = activity?.supportFragmentManager?.beginTransaction()
//                transaction?.replace(R.id.drawer_host_fragment, CartFragment())
//                transaction?.disallowAddToBackStack()
//                transaction?.commit()
//            }

        }


}