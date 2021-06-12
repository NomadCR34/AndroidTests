package com.example.esperssotest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(

        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "id")
        var id:Int,

        @ColumnInfo(name = "name")
        var name:String,

        @ColumnInfo(name = "lastName")
        var lastName:String

)


