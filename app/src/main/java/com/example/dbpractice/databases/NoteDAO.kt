package com.example.dbpractice.databases

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {
    @Query("SELECT * FROM noteText")
    fun getAllNotes(): Flow<List<NoteText>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteText)
    @Delete
    suspend fun deleteNote(note: NoteText)
}