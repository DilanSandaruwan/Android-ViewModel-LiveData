package com.example.labsheet02

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LikeViewModel : ViewModel() {
//    var likeCount: Int = 0
    private var _likeCount = MutableLiveData(0)
    val likeCount : LiveData<Int>
        get() = _likeCount

    fun performlikeCount(){
//        likeCount++
        _likeCount.value = _likeCount.value!! + 1
    }
}