package maulik.coroutinesplayground.repository

import androidx.lifecycle.MutableLiveData
import maulik.coroutinesplayground.api.NetworkManager
import maulik.coroutinesplayground.api.UsersApiService
import maulik.coroutinesplayground.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersRepository {

    val usersLiveData = MutableLiveData<List<User>>()
    val errorLiveData = MutableLiveData<String>()

    fun getUsers() {
        val usersApiService = NetworkManager.retrofit.create(UsersApiService::class.java)

        usersApiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>,
                                    response: Response<List<User>>) {
                if (response.isSuccessful) {
                    usersLiveData.value = response.body()
                } else {
                    errorLiveData.value = response.errorBody()?.string()
                    usersLiveData.value = mutableListOf()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                errorLiveData.value = t.message
            }

        })
    }

}