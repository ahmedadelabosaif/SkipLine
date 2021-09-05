package com.example.skiplineplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val title = arrayOf<String?>("History", "Profile", "About")
        val imgs = arrayOf<Int?>(
            R.drawable.history,
            R.drawable.profile,
            R.drawable.about,
            R.drawable.product
        )


        val recyclerView =
            inflater.inflate(R.layout.product_list, container, false) as RecyclerView

        val adapter = ProductRecycler(
            resources.getStringArray(R.array.names),
            resources.getStringArray(R.array.prices),
            imgs
        )
        recyclerView.adapter = adapter

        val gridLayoutManager = GridLayoutManager(activity, 2)
        recyclerView.layoutManager = gridLayoutManager
        return recyclerView
    }


}