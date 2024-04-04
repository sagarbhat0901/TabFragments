package com.example.tabfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the ViewPager and TabLayout views from the layout XML
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        // Set up ViewPager with fragments
        setupViewPager(viewPager)

        // Connect TabLayout with ViewPager
        tabLayout.setupWithViewPager(viewPager)
    }

    /**
     * Sets up the ViewPager with the adapter containing fragments.
     * @param viewPager The ViewPager to set up.
     */
    private fun setupViewPager(viewPager: ViewPager) {
        // Create an instance of the adapter for managing fragments
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // Add fragments to the adapter along with their titles
        adapter.addFragment(TabFragment.newInstance(1), "News")
        adapter.addFragment(TabFragment.newInstance(2), "Drama")
        adapter.addFragment(TabFragment.newInstance(3), "Movies")

        // Set the adapter to the ViewPager
        viewPager.adapter = adapter
    }
}

