package com.example.attractorsoftware.ui.second_screen


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.attractorsoftware.R
import com.example.attractorsoftware.adapter.AdapterImages
import com.example.attractorsoftware.databinding.FragmentSecondScreenBinding
import com.squareup.picasso.Picasso

private lateinit var adapter: AdapterImages

class SecondScreenFragment : Fragment(R.layout.fragment_second_screen) {

    private val viewModel = PhotoViewModel()
    private val binding by viewBinding(FragmentSecondScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //кнопка
        binding.btn.setOnClickListener {
            openGalleryForImages()
        }
        //много фото
        viewModel.setMultiPhoto.observe(viewLifecycleOwner, { recyclerSet(it) })
        //одно фото
        viewModel.setOnePhoto.observe(viewLifecycleOwner, {
            Picasso.get().load(it).into(binding.oneImage)
        })
    }

    //метод recycler view
    private fun recyclerSet(it: List<String>) {
        adapter = AdapterImages()
        binding.recyclerImages.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerImages.adapter = adapter
        //адаптер
        adapter.setItems(it)
    }

    private val REQUEST_CODE = 200

    //метод выбора фоток
    private fun openGalleryForImages() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE);
    }

    //получение фото
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //метод из view model
        viewModel.getPhoto(requestCode, resultCode, data)
    }
}