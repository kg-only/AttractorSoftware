package com.example.attractorsoftware.ui.first_screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.attractorsoftware.R
import com.example.attractorsoftware.adapter.AdapterCompany
import com.example.attractorsoftware.databinding.FragmentFirstScreenBinding
import com.example.attractorsoftware.models.Company
import org.koin.androidx.viewmodel.ext.android.viewModel

private lateinit var adapter: AdapterCompany

class FirstScreenFragment : Fragment(R.layout.fragment_first_screen) {

    //    private val viewModel = MainViewModel(Repository())
    private val viewModel by viewModel<MainViewModel>()
    private val binding by viewBinding(FragmentFirstScreenBinding::bind)

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //mvvm
        viewModel.getUser()
        viewModel.userData.observe(viewLifecycleOwner, {
            with(binding) {
                firstName.text = "Имя: " + it.user.firstName
                photo.text = "Фото: " + it.user.photo
                secondName.text = "Фамилия: " + it.user.secondName
                when (it.user.education) {
                    1 -> education.text ="Образование: " +  getString(R.string.high_school)
                    2 -> education.text ="Образование: " + getString(R.string.bachelor)
                    3 -> education.text ="Образование: " + getString(R.string.master)
                    4 -> education.text ="Образование: " + getString(R.string.doctoral)
                }
                //метод recycler view
                recyclerSet(it.user.company)
            }
        })
    }

    //метод recycler view
    private fun recyclerSet(it: List<Company>) {
        adapter = AdapterCompany()
        binding.recyclerCompany.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerCompany.adapter = adapter
        //адаптер
        adapter.setItems(it)
    }
}
