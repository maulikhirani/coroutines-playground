package maulik.coroutinesplayground.repository

import androidx.lifecycle.MutableLiveData
import maulik.coroutinesplayground.api.NetworkManager
import maulik.coroutinesplayground.api.UsersApiService
import maulik.coroutinesplayground.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.lang.Exception

class UsersRepository {

    val usersLiveData = MutableLiveData<List<User>>()
    val errorLiveData = MutableLiveData<String>()

    suspend fun getUsers() {
        val usersApiService = NetworkManager.retrofit.create(UsersApiService::class.java)

        try {
            val users = usersApiService.getUsers()
            usersLiveData.value = users
        } catch (e: Exception) {
            errorLiveData.value = e.message
        }
    }

}