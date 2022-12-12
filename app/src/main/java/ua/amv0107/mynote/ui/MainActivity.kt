package ua.amv0107.mynote.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ua.amv0107.mynote.R
import ua.amv0107.mynote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var conf : AppBarConfiguration
    lateinit var navController: NavController
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.fragmentContainerView)
        conf = AppBarConfiguration(
            setOf(
                R.id.mainFragment,
                R.id.categoryFragment
            ), binding.drawer
        )
        navController.addOnDestinationChangedListener{ _, destination, _ ->
            // TODO: Hide toolbar
            if(destination.id == R.id.mainFragment){
                
            } else {

            }
        }
        binding.navView.setupWithNavController(navController)
    }
}