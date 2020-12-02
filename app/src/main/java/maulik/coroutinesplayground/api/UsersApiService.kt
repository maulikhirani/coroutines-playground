package maulik.coroutinesplayground.api

import maulik.coroutinesplayground.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UsersApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}