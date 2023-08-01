package com.example.webtoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.webtoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val container = binding.fragmentContainer

        binding.button1.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, WebViewFragment())
                commit()
            }
        }

        binding.button2.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, BFragment())
                commit()
            }
        }
    }

    override fun onBackPressed() {
       val currentFragment = supportFragmentManager.fragments[0]
        if(currentFragment is WebViewFragment) {
            if(currentFragment.canGoBack()){
                currentFragment.goBack()
            }else {
                super.onBackPressed()
            }
        }else {
            super.onBackPressed()
        }
//        super.onBackPressed()
    }
}