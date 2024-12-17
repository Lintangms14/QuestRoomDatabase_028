package com.example.quest6.viewmodel

import com.example.quest6.data.entity.mahasiswa
import com.example.quest6.ui.theme.viewmodel.MahasiswaEvent

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