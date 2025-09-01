package com.example.dbpractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainScreen(vm: NoteViewModel = viewModel(factory = NoteViewModel.factory)){
    val noteList = vm.noteList.collectAsState(initial = emptyList())
    Column(modifier = Modifier
        .systemBarsPadding()
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)){
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically)
        {
            TextField(
                value = vm.newNoteText.value,
                onValueChange = {
                    vm.newNoteText.value = it
                },
                label = {
                    Text("Name...")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 5.dp)
            )
            IconButton(onClick = {
                vm.insertItem()
            }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add"
                ) }
        }
        Spacer(Modifier.height(10.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(noteList.value){note->
                ListItem(
                    note,
                    {
                        vm.noteText = it
                        vm.newNoteText.value = it.noteText.toString()
                    },
                    {
                        vm.deleteItem(it)
                    }
                    )
            }
        }
    }
}
