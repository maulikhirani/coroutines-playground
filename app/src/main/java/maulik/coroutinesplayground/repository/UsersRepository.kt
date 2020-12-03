package maulik.coroutinesplayground.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import maulik.coroutinesplayground.api.NetworkManager
import maulik.coroutinesplayground.api.UsersApiService
import maulik.coroutinesplayground.model.ErrorResponse
import maulik.coroutinesplayground.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.lang.Exception

class UsersRepository {

    val usersLiveData = MutableLiveData<List<User>>()
    val errorLiveData = MutableLiveData<String>("")

    suspend fun getUsers() {
        val usersApiService = NetworkManager.retrofit.create(UsersApiService::class.java)

        try {
            val users = usersApiService.getUsers()
            usersLiveData.value = users
        } catch (e: Exception) {
            if (e is HttpException) {
                handleErrorResponse(e)
            } else {
                errorLiveData.value = e.message
            }
        }
    }

    private fun handleErrorResponse(e: HttpException) {
        val body: String? = e.response()?.errorBody()?.string()
        val errorResponse: ErrorResponse? = Gson().fromJson(body.toString(), ErrorResponse::class.java)
        errorLiveData.value = errorResponse?.message
    }

}