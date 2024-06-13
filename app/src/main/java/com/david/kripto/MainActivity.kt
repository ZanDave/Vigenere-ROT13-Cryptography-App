package com.david.kripto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.david.kripto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_vigenere -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentContainer.id, VigenereFragment())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_rot13 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentContainer.id, Rot13Fragment())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
        binding.bottomNavigation.selectedItemId = R.id.navigation_vigenere
    }
}
