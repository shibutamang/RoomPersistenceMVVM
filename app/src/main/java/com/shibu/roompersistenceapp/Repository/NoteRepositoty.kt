package com.shibu.roompersistenceapp.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.shibu.roompersistenceapp.db.Note
import com.shibu.roompersistenceapp.db.NoteDao
import com.shibu.roompersistenceapp.db.NoteDatabase

class NoteRepositoty {
    lateinit var noteDao: NoteDao
    lateinit var allNotes: LiveData<List<Note>>

    constructor(app: Application){
        val db = NoteDatabase.getInstance(app)
        noteDao = db.noteDao()
        allNotes = noteDao.getNotes()
    }

    fun getNotes(): LiveData<List<Note>>{
        return  allNotes
    }

    fun insertNote(note: Note){

    }


}