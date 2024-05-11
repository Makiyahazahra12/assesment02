package org.d3if0059.assesment02.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if0059.assesment02.database.ResepDao
import org.d3if0059.assesment02.model.Resep

class MainViewModel(dao: ResepDao): ViewModel() {
    val data: StateFlow<List<Resep>> = dao.getResep().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

    private fun getDataDummy(): List<Resep> {
        val data = mutableListOf<Resep>()
        val resepOptions = listOf(
            "Makanan",
            "Minuman"
        )
        for (index in resepOptions.indices) {
            data.add(
                Resep(
                    judul = resepOptions[index],
                    bahan = resepOptions[index],
                    langkah = resepOptions[index],
                    tanggal = ""
                )
            )
        }
        return data
    }

}