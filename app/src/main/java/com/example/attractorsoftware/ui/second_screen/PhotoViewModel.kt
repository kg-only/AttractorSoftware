package com.example.attractorsoftware.ui.second_screen

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PhotoViewModel : ViewModel() {

    val setMultiPhoto = MutableLiveData<List<String>>()
    val setOnePhoto = MutableLiveData<String>()
    private val REQUEST_CODE = 200

    fun getPhoto(requestCode: Int, resultCode: Int, data: Intent?) {
        viewModelScope.launch {
            try {
                if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
                    // много фото
                    val photoList: ArrayList<String> = ArrayList()

                    if (data!!.clipData != null) {
                        val count = data.clipData!!.itemCount
                        for (i in 0 until count) {
                            val imageUri: Uri = data.clipData?.getItemAt(i)!!.uri
                            photoList.add(imageUri.toString())
                        }
                        //добавление фото в список
                        setMultiPhoto.value = photoList

                        //одно фото
                    } else if (data.data != null) {
                        val imageUri: Uri = data.data!!
                        //добавление 1 фото
                        setOnePhoto.value = imageUri.toString()
                    }
                }
                Log.e("###", "Success")
            } catch (e: Exception) {
                Log.e("###", e.toString())
            }
        }
    }
}
