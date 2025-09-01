package com.example.dbpractice

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dbpractice.databases.NoteText

@Composable
fun ListItem(
    note: NoteText,
    onClick: (NoteText)->Unit,
    onClickDelete: (NoteText)->Unit
){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .clickable{}){
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable{onClick(note)},
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(note.noteText.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(10.dp)
            )
            IconButton(onClick = {onClickDelete(note)}) {
                Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete"
            ) }
        }
    }
}