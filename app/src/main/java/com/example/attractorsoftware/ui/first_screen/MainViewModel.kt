package com.example.attractorsoftware.ui.first_screen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attractorsoftware.models.UserMain
import com.example.attractorsoftware.repository.RepositoryJson
import kotlinx.coroutines.launch

class MainViewModel(private val repositoryJson: RepositoryJson) : ViewModel() {

    val userData = MutableLiveData<UserMain>()

    fun getUser() {
        viewModelScope.launch {
            try {
                userData.value = repositoryJson.getUserJson()
                Log.e("###", "Success")
            } catch (e: Exception) {
                Log.e("###", e.toString())
            }
        }
    }
}
