package com.example.skiplineplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val imgs = arrayOf<Int?>(
            R.drawable.history,
            R.drawable.profile,
            R.drawable.about
        )
        val recyclerView =
            inflater.inflate(R.layout.order_list, container, false) as RecyclerView

        val adapter = CartRecycler(resources.getStringArray(R.array.names), imgs)
        recyclerView.adapter = adapter

        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        return recyclerView
    }

}