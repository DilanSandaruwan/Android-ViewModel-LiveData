package com.example.labsheet02

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LikeViewModel(application: Application) : AndroidViewModel(application),
    SharedPreferences.OnSharedPreferenceChangeListener {

    //    var likeCount: Int = 0
    private var _likeCount = MutableLiveData(0)

    val likeCount: LiveData<Int>
        get() = _likeCount

    private val sharedPreferences =
        application.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

    var spLikeKey: String = ""
        get() = field
        set(value) {
            field = value
        }

    init {
        _likeCount.value = sharedPreferences.getInt(spLikeKey, 0)
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    fun performlikeCount() {
//        likeCount++
        _likeCount.value = _likeCount.value!! + 1
        sharedPreferences.edit().putInt(spLikeKey, _likeCount.value ?: 0).apply()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == spLikeKey) {
            _likeCount.value = sharedPreferences?.getInt(key, 0)
        }
    }

}