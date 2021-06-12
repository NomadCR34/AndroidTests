package com.example.esperssotest

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MyViewModelTest{

    private lateinit var viewModel: MyViewModel

    @Before
    fun setup(){
        viewModel = MyViewModel()
    }

    @Test
    fun testViewModel(){
        //your test is here
        viewModel.showHelloWorld()
        
        val result = viewModel.liveData.getOrAwaitValue().toString()

        assertEquals("Hello World! :)",result)
    }

}