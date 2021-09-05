package com.example.skiplineplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment

class NotificationsFragment : ListFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val notifications = arrayOf<String?>("notification 1", "notification 2", "notification 3")
        val adapter =
            ArrayAdapter(inflater.context, android.R.layout.simple_list_item_1, notifications)
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }



}