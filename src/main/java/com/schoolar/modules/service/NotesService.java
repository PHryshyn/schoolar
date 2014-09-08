package com.schoolar.modules.service;


import com.schoolar.modules.model.Notes;

import java.util.List;

public interface NotesService {
    public void saveNotes(Notes notes);
    public void updateNotes(Notes notes);
    public Notes findByIdNotes(int noteId);
    public void deleteNotes(int noteId);
    public List<Notes> getNotesList();
}
