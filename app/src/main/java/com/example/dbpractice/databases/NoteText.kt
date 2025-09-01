package com.example.dbpractice.databases

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteText")
data class NoteText (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 0,
    @ColumnInfo(name = "text")
    var noteText: String? = null)