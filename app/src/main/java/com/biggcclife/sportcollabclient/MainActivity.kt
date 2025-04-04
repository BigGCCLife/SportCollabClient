package com.biggcclife.sportcollabclient

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.biggcclife.sportcollabclient.databinding.ActivityMainBinding
//import com.yandex.mapkit.MapKitFactory
//import com.yandex.mapkit.mapview.MapView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var mapView: MapView // For Yandex maps

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_groups, R.id.navigation_map, R.id.navigation_goals, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //For Yandex maps
        //MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
        //MapKitFactory.initialize(this)
        //mapView = findViewById(R.id.mapview)
    }

    override fun onStart() {
        super.onStart()
        //MapKitFactory.getInstance().onStart()
        //mapView.onStart()
    }

    override fun onStop() {
        //mapView.onStop()
        //MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}