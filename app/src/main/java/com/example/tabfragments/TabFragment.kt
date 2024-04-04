package com.example.tabfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TabFragment : Fragment() {

    companion object {
        private const val ARG_TAB_NUMBER = "tab_number"

        fun newInstance(tabNumber: Int): TabFragment {
            val fragment = TabFragment()
            val args = Bundle()
            args.putInt(ARG_TAB_NUMBER, tabNumber)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_tab1, container, false)
        val textView: TextView = rootView.findViewById(R.id.textView)
        val tabNumber = arguments?.getInt(ARG_TAB_NUMBER) ?: 0

        // Set background color and text content based on tab number
        rootView.setBackgroundColor(getTabBackgroundColor(tabNumber))
        textView.text = getTabContent(tabNumber)
        textView.setTextColor(getTextColor(tabNumber))

        return rootView
    }

    // Function to determine background color based on tab number
    private fun getTabBackgroundColor(tabNumber: Int): Int {
        return when (tabNumber) {
            1 -> resources.getColor(R.color.tab1_background)
            2 -> resources.getColor(R.color.tab2_background)
            3 -> resources.getColor(R.color.tab3_background)
            else -> resources.getColor(R.color.default_background)
        }
    }

    // Function to determine text content based on tab number
    private fun getTabContent(tabNumber: Int): String {
        return when (tabNumber) {
            1 -> getString(R.string.tab1_content)
            2 -> getString(R.string.tab2_content)
            3 -> getString(R.string.tab3_content)
            else -> getString(R.string.default_content)
        }
    }

    // Function to determine text color based on tab number
    private fun getTextColor(tabNumber: Int): Int {
        return resources.getColor(R.color.text_color)
    }
}
