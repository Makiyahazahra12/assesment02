package org.d3if0059.assesment02.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.migration.Migration
import org.d3if0059.assesment02.model.Resep

@Database(entities = [Resep::class], version = 2)
abstract class ResepDb : RoomDatabase() {
    abstract fun dao(): ResepDao

    companion object {
        @Volatile
        private var INSTANCE: ResepDb? = null

        fun getInstance(context: Context): ResepDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ResepDb::class.java,
                        "resep.db"
                    )
                        .addMigrations(MIGRATION_1_2)
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

        // Migrasi dari versi 1 ke versi 2
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Menambahkan kolom "jenis" ke tabel "resep"
                db.execSQL("ALTER TABLE resep ADD COLUMN jenis TEXT")

                // Hapus kolom "new_column_name" jika sebelumnya telah ditambahkan
                db.execSQL("ALTER TABLE resep DROP COLUMN IF EXISTS new_column_name")
            }
        }

    }
}
