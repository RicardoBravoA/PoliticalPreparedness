package com.udacity.political.preparedness.data.storage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.udacity.political.preparedness.data.storage.entity.SavedElectionDetailEntity
import com.udacity.political.preparedness.data.storage.entity.ElectionEntity

@Database(
    entities = [ElectionEntity::class, SavedElectionDetailEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ElectionDatabase : RoomDatabase() {

    abstract val electionDao: ElectionDao

    abstract val savedElectionDetailDao: SavedElectionDetailDao

    companion object {

        @Volatile
        private var INSTANCE: ElectionDatabase? = null

        fun getInstance(context: Context): ElectionDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ElectionDatabase::class.java,
                        "election_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }

    }

}