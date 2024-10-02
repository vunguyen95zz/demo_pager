package com.example.viewpagersample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagersample.fragments.FirstFragment
import com.example.viewpagersample.fragments.SecondFragment

class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment.newInstance()
            else -> SecondFragment.newInstance()
        }
    }

}