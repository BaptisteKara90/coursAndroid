package fr.eni.ecole.mod6demo3.bo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Music (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    val title: String,
    val author: String,
    @ColumnInfo(name = "duration")
    val lengthInSeconds: Int
)