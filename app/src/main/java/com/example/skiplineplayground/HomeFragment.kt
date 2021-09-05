package com.example.skiplineplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class HomeFragment : Fragment() {
private val username = activity?.findViewById<TextView>(R.id.user_name)
private val user = activity?.findViewById<TextView>(R.id.user)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        username?.text = "${user?.text}+!"
    }


}
