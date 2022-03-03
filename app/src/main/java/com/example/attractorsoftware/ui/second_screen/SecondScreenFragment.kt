package com.example.attractorsoftware.ui.second_screen


import android.app.Activity
import android.content.Intent
import android.net.Uri
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

    private val binding by viewBinding(FragmentSecondScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //кнопка
        binding.btn.setOnClickListener {
            openGalleryForImages()
        }
    }

    //метод recycler view
    private fun recyclerSet(it: List<String>) {
        adapter = AdapterImages()
        binding.recyclerImages.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerImages.adapter = adapter
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

    //получение фоток
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            // много
            val photoList: ArrayList<String> = ArrayList()

            if (data!!.clipData != null) {
                val count = data.clipData!!.itemCount
                for (i in 0 until count) {
                    val imageUri: Uri = data.clipData?.getItemAt(i)!!.uri
                    photoList.add(imageUri.toString())
                }
                //recycler images
                recyclerSet(photoList)
                //одна
            } else if (data.data != null) {
                val imageUri: Uri = data.data!!
                Picasso.get().load(imageUri).into(binding.oneImage)
            }
        }
    }
}