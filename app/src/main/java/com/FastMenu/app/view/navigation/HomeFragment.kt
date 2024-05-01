package com.FastMenu.app.view.navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.FastMenu.app.view.search.SearchMakananActivity
import com.FastMenu.app.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val cardView = view.findViewById<CardView>(R.id.cv_cari_makanan)
        cardView.setOnClickListener {
            val intent = Intent(activity, SearchMakananActivity::class.java)
            startActivity(intent)
        }
        return view
    }

}