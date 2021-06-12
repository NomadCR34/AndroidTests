package com.example.esperssotest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread
import kotlin.math.absoluteValue
import kotlin.properties.Delegates

class MyViewModel : ViewModel() {

    private val _mutableLiveData = MutableLiveData<String>();
    val liveData: LiveData<String>
        get() = _mutableLiveData


    fun showHelloWorld() {
        _mutableLiveData.postValue("Hello World! :)")
    }

    fun getData(){
        viewModelScope.launch {

            var result = async { createData() }
            val sum = result.await()
            _mutableLiveData.postValue(sum.absoluteValue.toString())
        }
    }

    private suspend fun createData():Int{
        return withContext(Dispatchers.Default){
            calculate()
        }
    }

    private fun calculate():Int{
        var sum :Int= 0
        for( i in 1..1000){
            Thread.sleep(10)
            sum += i
        }
        return sum
    }
}