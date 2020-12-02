package maulik.coroutinesplayground.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import maulik.coroutinesplayground.model.User
import maulik.coroutinesplayground.repository.UsersRepository

class UsersViewModel: ViewModel() {

    val repository = UsersRepository()
    val usersList = repository.usersLiveData
    val errorMessage = repository.errorLiveData

    fun getUsers() {
        repository.getUsers()
    }

}