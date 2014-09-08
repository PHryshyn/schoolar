package com.schoolar.modules.dao;


import com.schoolar.modules.model.Notes;

import java.util.List;

public interface NotesDao extends BasicCrudDao<Notes, Integer> {
    public void saveNotes(Notes notes);
    public void updateNotes(Notes notes);
    public Notes findByIdNotes(int noteId);
    public void deleteNotes(int noteId);
    public List<Notes> getNotesList();
}
