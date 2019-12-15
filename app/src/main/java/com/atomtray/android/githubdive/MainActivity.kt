package com.atomtray.android.githubdive

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.atomtray.android.githubdive.repositories.DataSingleTon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val searchTxtData:EditText = findViewById(R.id.searchText)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        searchBtn.setOnClickListener {
            if(searchTxtData.text.isEmpty()) {
                Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show()
                DataSingleTon.setID("0xpulsar")
            }
            else
                Toast.makeText(this,"Finding...",Toast.LENGTH_SHORT).show()
                DataSingleTon.setID(searchTxtData.text.toString())
        }

        DataSingleTon.isLoadingData.observe(this, Observer { newIsLoading ->
            if (newIsLoading)
                progressBar.visibility = View.VISIBLE
              else
                progressBar.visibility = View.INVISIBLE
        })

        DataSingleTon.statusText.observe(this, Observer {newStatus ->

            Toast.makeText(this,newStatus,Toast.LENGTH_LONG).show()
        })







    }
}
