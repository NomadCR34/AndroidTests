package com.example.esperssotest


import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MyMathTest{

    lateinit var myMath:MyMath

    @Before
    fun init(){
        myMath = MyMath()
    }

    @Test
    fun testSum(){
        assertEquals(3,myMath.sum(1,2))
    }

}