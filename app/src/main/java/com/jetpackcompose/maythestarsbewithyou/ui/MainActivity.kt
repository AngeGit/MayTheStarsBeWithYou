package com.jetpackcompose.maythestarsbewithyou.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jetpackcompose.maythestarsbewithyou.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavView= findViewById<BottomNavigationView>(R.id.bottomNavView) //Obtenemos la bottombar
        val navHostFrg = supportFragmentManager.findFragmentById(R.id.nav_host_frg) as NavHostFragment //Obtenemos en NavHostFrg
        navController=navHostFrg.navController //seteamos el navController
        bottomNavView.setupWithNavController(navController)//y lo seteamos en al view del bottomNav
    }
}