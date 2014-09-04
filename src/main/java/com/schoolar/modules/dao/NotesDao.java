package com.schoolar.modules.dao;


import com.schoolar.modules.model.Notes;

import java.util.List;

public interface NotesDao {
    public void addNote(Notes note);
    public void updateNote(Notes note);
    public Notes getNote(int noteId);
    public void deleteNote(int noteId);
    public List<Notes> getNotes();
}
