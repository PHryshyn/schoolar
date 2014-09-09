package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.NotesDao;
import com.schoolar.modules.model.Notes;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("notesDao")
public class NotesDaoImpl extends BasicCrudDaoImpl<Notes, Integer> implements NotesDao {

    protected NotesDaoImpl() {
        super(Notes.class);
    }

    @Override
    public void updateNotes(Notes notes) {
        Notes notesToUpdate = findById(notes.getNoteId());
        notesToUpdate.setNotes(notes.getNotes());
        notesToUpdate.setHomework(notes.getHomework());
        notesToUpdate.setDiscipline(notes.getDiscipline());
        notesToUpdate.setNoteDate(notes.getNoteDate());
        notesToUpdate.setUser(notes.getUser());
        update(notes);
    }

}
