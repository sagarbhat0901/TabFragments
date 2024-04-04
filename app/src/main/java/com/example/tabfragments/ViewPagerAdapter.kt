package com.example.tabfragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Adapter for managing fragments within a ViewPager.
 * @param fm The fragment manager that will interact with this adapter.
 */
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // List to hold the fragments and their corresponding titles
    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    /**
     * Returns the fragment at the specified position.
     * @param position The position of the fragment.
     * @return The fragment at the specified position.
     */
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    /**
     * Returns the total number of fragments managed by this adapter.
     * @return The total number of fragments.
     */
    override fun getCount(): Int {
        return fragmentList.size
    }

    /**
     * Adds a fragment to the adapter with the specified title.
     * @param fragment The fragment to add.
     * @param title The title associated with the fragment.
     */
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    /**
     * Returns the title of the fragment at the specified position.
     * @param position The position of the fragment.
     * @return The title of the fragment.
     */
    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }
}
