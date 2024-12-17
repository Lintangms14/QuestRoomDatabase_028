package com.example.quest6.viewmodel

import androidx.lifecycle.ViewModel
import com.example.quest6.data.entity.mahasiswa
import com.example.quest6.repository.repositoryMhs
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

data class HomeUiState(
    val listMhs: List<mahasiswa> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessages: String = ""
)