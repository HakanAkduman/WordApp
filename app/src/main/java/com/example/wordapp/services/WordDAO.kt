package com.example.wordapp.services

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.wordapp.MVVM.Word

@Dao
interface WordDAO {

    @Insert
    suspend fun insertAll(vararg word : Word):List<Long>

    @Query("SELECT * FROM word")
    suspend fun getAllWords():ArrayList<Word>

    @Query("SELECT * FROM word WHERE id = :wordID")
    suspend fun getWord(wordID:Int):Word

    @Query("DELETE FROM word")
    suspend fun deleteAllWords()
}