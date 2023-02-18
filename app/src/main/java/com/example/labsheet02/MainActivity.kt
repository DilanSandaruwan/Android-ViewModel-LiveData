package com.example.labsheet02

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.labsheet02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // this is by default public unless they are declared private
    private val viewModel: LikeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val buttonLike:Button = findViewById(R.id.btnLike)
//        val textViewLikeCount: TextView = findViewById(R.id.tvLikeCount)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.likeVM = viewModel
        binding.lifecycleOwner = this // this must be added to awake the viewModel+ui intersection
        binding.btnLike.setOnClickListener {
            viewModel.performlikeCount()
//            binding.tvLikeCount.text = viewModel.likeCount.toString()
        }

        // creating observer to observe the changes with the
        val liveObserver = Observer<Int> {
            // do whatever needed once the value change is observed
                newValue ->
            binding.tvLikeCount.text = newValue.toString()
        }
        viewModel.likeCount.observe(this, liveObserver)
    }
}