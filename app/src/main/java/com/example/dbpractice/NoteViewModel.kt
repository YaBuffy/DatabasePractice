package com.example.dbpractice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dbpractice.databases.NoteText
import com.example.dbpractice.databases.NotesRoomDb
import kotlinx.coroutines.launch


class NoteViewModel(val database: NotesRoomDb): ViewModel() {

    val noteList = database.DAO.getAllNotes()
    val newNoteText = mutableStateOf("")
    var noteText: NoteText? = null

    fun insertItem() = viewModelScope.launch {
        val nameText = noteText?.copy(noteText = newNoteText.value)
            ?: NoteText(noteText = newNoteText.value)
        database.DAO.insertNote(nameText)
        noteText = null
        newNoteText.value = ""
    }
    fun deleteItem(noteText: NoteText) = viewModelScope.launch {
        database.DAO.deleteNote(noteText)
    }

    companion object{
        val factory: ViewModelProvider.Factory = object: ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T: ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras): T{
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return NoteViewModel(database) as T
            }
        }
    }
}