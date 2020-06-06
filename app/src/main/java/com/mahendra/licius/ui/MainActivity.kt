package com.mahendra.licius.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahendra.licius.R
import com.mahendra.licius.databinding.ActivityMainBinding
import com.mahendra.licius.ui.grid.MeatGridListFragment
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)

        loadListFragment()
    }

    private fun loadListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootView,MeatGridListFragment.newInstance(),MeatGridListFragment::class.java.name)
            .commit()
    }
}
