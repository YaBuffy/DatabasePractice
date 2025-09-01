package com.example.dbpractice

import android.app.Application
import com.example.dbpractice.databases.NotesRoomDb

class App : Application() {
    val database by lazy { NotesRoomDb.createDataBase(this) }
}
