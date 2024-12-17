package com.example.quest6.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quest6.data.entity.mahasiswa
import com.example.quest6.repository.repositoryMhs
import com.example.quest6.ui.navigation.alamatnavigation
import com.example.quest6.viewmodel.MahasiswaEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class DetailMhsUiState(
    val detailUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
){
    val isUiEventEmpty: Boolean
        get()= detailUiEvent == MahasiswaEvent()
    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != MahasiswaEvent()
}
fun mahasiswa.toDetailUiEvent(): MahasiswaEvent {
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        jenisKelamin = jeniskelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan
    )
}

class DetailMhsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: repositoryMhs,

    ) : ViewModel() {
    private val _nim: String = checkNotNull(savedStateHandle[alamatnavigation.DestinasiDetail.NIM])

    val detailUiState: StateFlow<DetailMhsUiState> = repositoryMhs.getMhs(_nim)
        .filterNotNull()
        .map {
            DetailMhsUiState(
                detailUiEvent = it.toDetailUiEvent(),
                isLoading = false,
            )
        }
        .onStart {
            emit(DetailMhsUiState(isLoading = true))
            delay(600)
        }
        .catch {
            emit(
                DetailMhsUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi Kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(2000),
            initialValue = DetailMhsUiState(
                isLoading = true
            ),
        )
    fun deleteMhs() {
        detailUiState.value.detailUiEvent.toMahasiswaEntity().let {
            viewModelScope.launch {
                repositoryMhs.deleteMhs(it)
            }
        }
    }
}