package com.example.pagingapps

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagingapps.adapter.QuoteListAdapter
import com.example.pagingapps.databinding.ActivityMainBinding
import com.example.pagingapps.ui.MainViewModel
import com.example.pagingapps.ui.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels {
        ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = QuoteListAdapter()
        binding.rvQuote.layoutManager = LinearLayoutManager(this)
        binding.rvQuote.adapter = adapter

        mainViewModel.quote.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }

}
