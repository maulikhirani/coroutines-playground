package maulik.coroutinesplayground.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import maulik.coroutinesplayground.model.User
import maulik.coroutinesplayground.repository.UsersRepository

class UsersViewModel: ViewModel() {

    val repository = UsersRepository()
    val usersList = repository.usersLiveData
    val errorMessage = repository.errorLiveData

    fun getUsers() {
        viewModelScope.launch {
            repository.getUsers()
        }
    }

}