package com.dhaliwal.secondbrainaisystem.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dhaliwal.secondbrainaisystem.data.local.Note
import com.dhaliwal.secondbrainaisystem.data.local.NoteTag
import com.dhaliwal.secondbrainaisystem.ui.components.NotesItem
import com.dhaliwal.secondbrainaisystem.ui.theme.SecondBrainAISystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SecondBrainAISystemTheme {
                MainScreen()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val tags = listOf(
        NoteTag(0, "All"),
        NoteTag(1, "Finance"),
        NoteTag(2, "Health"),
        NoteTag(3, "Learning"),
        NoteTag(4, "Work"),
        NoteTag(5, "Personal"),
        NoteTag(6, "Ideas"),
        NoteTag(7, "Projects"),
        NoteTag(8, "Travel"),
        NoteTag(9, "Books"),
        NoteTag(10, "Movies"),
        NoteTag(11, "Music"),
        NoteTag(12, "Recipes"),
        NoteTag(13, "Fitness"),
        NoteTag(14, "Wellness"),
        NoteTag(15, "Goals"),
        NoteTag(16, "Journals"),
        NoteTag(17, "Quotes"),
        NoteTag(18, "Events"),
        NoteTag(19, "Misc")
    )

    var selectedTag by rememberSaveable { mutableStateOf("All") }
    var query by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    val interactionSource = remember { MutableInteractionSource() }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {

                //Search Bar
                DockedSearchBar(
                    inputField = {
                        SearchBarDefaults.InputField(
                            query = query,
                            onQueryChange = { query = it },
                            onSearch = { active = false },
                            expanded = active,
                            onExpandedChange = { active = it },
                            placeholder = { Text("Search notes...") },
                            leadingIcon = {
                                Icon(Icons.Default.Search, contentDescription = null)
                            },
                            interactionSource = interactionSource
                        )
                    },
                    expanded = active,
                    onExpandedChange = { active = it },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Suggestions coming soon...",
                        modifier = Modifier.padding(16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Tag Row
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(tags) { tag ->

                        FilterChip(
                            selected = selectedTag == tag.name,
                            onClick = { selectedTag = tag.name },
                            label = { Text(tag.name) },
                            shape = RoundedCornerShape(50),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primary,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->

        // Content Area
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            Column(

            ) {
                NotesItem(
                    note = Note(
                        id = 1,
                        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                        tags = listOf(
                            "Lorem",
                            "Ipsum",
                            "Dolor",
                            "Sit",
                            "Amet",
                            "Consectetur",
                            "Adipiscing"
                        ),
                        createdAt = System.currentTimeMillis()
                    )
                )
                NotesItem(
                    note = Note(
                        id = 1,
                        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                        tags = listOf(
                            "Lorem",
                            "Ipsum",
                            "Dolor",
                            "Sit",
                            "Amet",
                            "Consectetur",
                            "Adipiscing"
                        ),
                        createdAt = System.currentTimeMillis()
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview(){
    SecondBrainAISystemTheme {
        MainScreen()
    }
}