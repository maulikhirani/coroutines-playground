package maulik.coroutinesplayground.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import maulik.coroutinesplayground.model.User
import maulik.coroutinesplayground.repository.UsersRepository

class UsersViewModel: ViewModel() {

    private val repository = UsersRepository()
    val usersList: MutableLiveData<List<User>> = repository.usersLiveData
    val errorMessage: MutableLiveData<String> = repository.errorLiveData

    fun getUsers() {
        repository.getUsers()
    }

}