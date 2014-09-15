package com.schoolar.modules.service;


import com.schoolar.modules.model.Notes;

import java.util.List;

public interface NotesService  {

    public void updateNotes(Notes notes);
    void save(Notes notes);
    Notes findById(Integer noteId);
    void delete(Integer noteId);
    List<Notes> getList();

}
