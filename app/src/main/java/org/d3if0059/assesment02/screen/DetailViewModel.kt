package org.d3if0059.assesment02.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0059.assesment02.database.ResepDao
import org.d3if0059.assesment02.model.Resep
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: ResepDao) : ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(judul: String, bahan: String, langkah: String) {
        val resep = Resep(
            tanggal = formatter.format(Date()),
            judul = judul,
            bahan = bahan,
            langkah = langkah
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(resep)
        }
    }

    suspend fun getResep(id: Long): Resep? {
        return dao.getResepById(id)
    }
    fun update(id: Long, judul: String, bahan: String, langkah: String) {
        val resep = Resep(
            id = id,
            tanggal = formatter.format(Date()),
            judul = judul,
            bahan = bahan,
            langkah = langkah
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(resep)
        }
    }
    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}