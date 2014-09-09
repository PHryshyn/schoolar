package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.NotesDao;
import com.schoolar.modules.model.Notes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("notesDao")
public class NotesDaoImpl extends BasicCrudDaoImpl<Notes, Integer> implements NotesDao {

    protected NotesDaoImpl() {
        super(Notes.class);
    }


    @Override
    public void saveNotes(Notes notes) {
        save(notes);
    }

    @Override
    public void updateNotes(Notes notes) {
        Notes notesToUpdate = findByIdNotes(notes.getNoteId());
        notesToUpdate.setNotes(notes.getNotes());
        notesToUpdate.setHomework(notes.getHomework());
        notesToUpdate.setDiscipline(notes.getDiscipline());
        notesToUpdate.setNoteDate(notes.getNoteDate());
        notesToUpdate.setUser(notes.getUser());
        update(notes);
    }

    @Override
    public Notes findByIdNotes(int noteId) {
        return findById(noteId);
    }

    @Override
    public void deleteNotes(int noteId) {
        Notes notes = findByIdNotes(noteId);
        if (notes != null)
        delete(notes);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Notes> getNotesList() {
        return getCurrentSession().createCriteria(Notes.class).list();
    }
}
