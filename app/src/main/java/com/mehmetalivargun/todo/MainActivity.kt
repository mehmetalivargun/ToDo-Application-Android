package com.mehmetalivargun.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.mehmetalivargun.todo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

private lateinit var  binding: ActivityMainBinding
private lateinit var  navController:NavController
private lateinit var appBarConfiguration: AppBarConfiguration
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFrag= supportFragmentManager.
        findFragmentById(R.id.fragmentHost) as NavHostFragment

        navController=navHostFrag.navController
        setupActionBarWithNavController(navController)
        appBarConfiguration= AppBarConfiguration(setOf(
            R.id.todoListFragment,
            R.id.addTodoFragment
        ))
    }
    //back from appBar
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) ||super.onSupportNavigateUp()
    }
}