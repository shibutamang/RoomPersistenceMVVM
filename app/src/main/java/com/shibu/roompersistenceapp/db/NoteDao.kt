package com.shibu.roompersistenceapp.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface NoteDao {
    @Insert
    fun insert(note:Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("select * from note")
    fun getNotes(): LiveData<List<Note>>
}