package com.caren.dailyinspirationalquote

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.caren.dailyinspirationalquote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var authorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button = binding.button
        textView = binding.text
        authorTextView = binding.authorText

        viewModel.currentlyDisplayedQuote.observe(this,
            { textView.text = it?.quote
                authorTextView.text = it?.author
            })

        getNewQuote()
    }

    private fun getNewQuote() {
        button.setOnClickListener {
            viewModel.getNewQuote()
        }
    }
}