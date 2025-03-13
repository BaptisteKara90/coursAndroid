package fr.eni.ecole.mod6demo3

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.eni.ecole.mod6demo3.bo.Music
import fr.eni.ecole.mod6demo3.room.AppDataBase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MusicDbTest {
    private lateinit var db: AppDataBase

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDataBase::class.java
        ).build()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun testInsertMusic() = runTest {
        val music = Music(
            0L,
            "White van",
            "Lamborghini Girls",
            250
        )
        val id = db.musicDao().insert(music)
        assertTrue(id > 0)

        val musicFromDb = db.musicDao().findById(id)
        assertNotNull(musicFromDb)
        assertNotNull(musicFromDb.title)
        assertEquals(music.title, musicFromDb.title)
        assertNotNull(musicFromDb.author)
        assertEquals(music.author, musicFromDb.author)
    }
}


