package com.example.attractorsoftware.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.attractorsoftware.R
import com.example.attractorsoftware.databinding.FragmentFirstScreenBinding
import com.example.attractorsoftware.databinding.FragmentMainBinding
import com.example.attractorsoftware.ui.first_screen.FirstScreenFragment
import com.example.attractorsoftware.ui.second_screen.SecondScreenFragment

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeFragment(FirstScreenFragment())
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.fistScreen -> changeFragment(FirstScreenFragment())
                R.id.secondScreen -> changeFragment(SecondScreenFragment())
            }
            true
        }
    }

    fun changeFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}