package com.example.attractorsoftware.repository

import com.example.attractorsoftware.models.UserMain
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class RepositoryJson {
     fun getUserJson(): UserMain {
        val jsonString =
            "{\"user\": {\"first_name\": \"Аман\",\"photo\" : \"https://ibb.co/gWW80PH\"," +
                    "\"second_name\": \"Канатбек\",\"education\": 2,\"company\": [{\"name\": \"Attractor Software\"," +
                    "\"position\": \"Android developer\"},{\"name\": \"Google\",\"position\": \"developer\"},{\"name\":" +
                    " \"Amazon\",\"position\": \"developer\"}]}}"

        return Gson().fromJson(jsonString, object : TypeToken<UserMain>() {}.type)
    }
}