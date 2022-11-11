package com.example.mvvm1.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvvm1.databinding.ActivityMainBinding
import com.example.mvvm1.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar nuestra info
        //lamar a nuestro model, quoteviewmodel
        //y llamamos a onCreate
        quoteViewModel.onCreate()

        //setContentView(R.layout.activity_main)
        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })
        quoteViewModel.isLoading.observe(this, Observer{
            binding.progress.isVisible=it
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

    }


}