package com.example.viewpagersample

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var buttonMenu: ImageButton
    private lateinit var buttonFirstFragment: MaterialButton
    private lateinit var buttonSecondFragment: MaterialButton

    private val pagerAdapter by lazy {
        PagerAdapter(this)
    }

    private val viewPagerCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Log.e(">>>>", "current fragment: ${viewPager.currentItem}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        viewPager.adapter = pagerAdapter

        viewPager.registerOnPageChangeCallback(viewPagerCallback)

        buttonFirstFragment.setOnClickListener {
            viewPager.currentItem = 0
        }

        buttonSecondFragment.setOnClickListener {
            viewPager.currentItem = 1
        }

        buttonMenu.setOnClickListener {
            PopupMenu(context = this, mode = viewPager.currentItem) { id ->
                Log.e(">>>>", "click on item: $id")
            }.showPopup(buttonMenu)
        }
    }

    override fun onDestroy() {
        viewPager.unregisterOnPageChangeCallback(viewPagerCallback)
        super.onDestroy()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        buttonMenu = findViewById(R.id.buttonMenu)
        buttonFirstFragment = findViewById(R.id.buttonFirstFragment)
        buttonSecondFragment = findViewById(R.id.buttonSecondFragment)
    }
}