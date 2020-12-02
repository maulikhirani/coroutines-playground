package maulik.coroutinesplayground.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import maulik.coroutinesplayground.R
import maulik.coroutinesplayground.databinding.ActivityMainBinding
import maulik.coroutinesplayground.viewmodel.UsersViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: UsersViewModel by viewModels()
    private val usersAdapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.rvUsers.adapter = usersAdapter

        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
        }

        viewModel.usersList.observe(this) {
            it?.let {
                usersAdapter.setUsersList(it.toMutableList())
            }
        }

        viewModel.getUsers()
    }
}