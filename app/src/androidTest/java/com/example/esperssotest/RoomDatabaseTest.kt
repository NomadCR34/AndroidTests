package com.example.esperssotest

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {
    private lateinit var userDao:UserDao
    private lateinit var db:AppDatabase

    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        userDao = db.userDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDB(){
        db.close()
    }


    @Test
    @Throws(Exception::class)
    fun writeUser(){
        val user = User(
            id = 1,
            name = "Amin",
            lastName = "Rooholamini"
        )
        userDao.insert(user)

        val userList = userDao.getUsers()
        assertThat(userList[0],equalTo(user))
    }


}