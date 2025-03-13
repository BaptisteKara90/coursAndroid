package fr.eni.ecole.mod6demo3.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fr.eni.ecole.mod6demo3.bo.Music

@Dao
interface MusicDao {

    @Insert
    suspend fun insert(music: Music): Long

    @Query("SELECT * FROM music")

    fun findAll(): List<Music>

    @Query("SELECT * FROM music WHERE id = :id")
    fun findById(id: Long): Music
}