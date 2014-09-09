package com.schoolar.modules.dao;


import com.schoolar.modules.model.Notes;

import java.util.List;

public interface NotesDao extends BasicCrudDao<Notes, Integer> {

    public void updateNotes(Notes notes);

}
