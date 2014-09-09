package com.schoolar.modules.service;


import com.schoolar.modules.model.Notes;

import java.util.List;

public interface NotesService extends BasicService<Notes, Integer> {

    public void updateNotes(Notes notes);

}
