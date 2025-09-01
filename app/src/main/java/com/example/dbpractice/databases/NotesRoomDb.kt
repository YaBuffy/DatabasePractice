package com.example.dbpractice.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteText::class], version = 1)
abstract class NotesRoomDb : RoomDatabase(){
    abstract val DAO: NoteDAO
    companion object{
        fun createDataBase(context: Context): NotesRoomDb{
            return Room.databaseBuilder(
                context,
                NotesRoomDb::class.java,
                "test.db"
            ).build()
        }
    }
}