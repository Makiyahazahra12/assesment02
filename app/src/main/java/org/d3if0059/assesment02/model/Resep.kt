package org.d3if0059.assesment02.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resep")
data class Resep(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val judul: String,
    val bahan: String,
    val langkah: String,
    val tanggal: String
)

