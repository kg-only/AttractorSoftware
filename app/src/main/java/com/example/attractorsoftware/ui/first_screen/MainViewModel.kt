package com.example.attractorsoftware.ui.first_screen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attractorsoftware.repository.Repository
import com.example.attractorsoftware.models.UserMain
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val userData = MutableLiveData<UserMain>()

    fun getUser() {
        viewModelScope.launch {
            try {
                userData.value = repository.getUserJson()
                Log.e("###", "Success")
            } catch (e: Exception) {
                Log.e("###", e.toString())
            }
        }

    }
}
