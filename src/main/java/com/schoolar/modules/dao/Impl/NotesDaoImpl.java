package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.NotesDao;
import com.schoolar.modules.model.Notes;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("notesDao")
public class NotesDaoImpl implements NotesDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addNote(Notes note) {
        sessionFactory.getCurrentSession().save(note);
    }

    public void updateNote(Notes note) {
        Notes notesToUpdate = getNote(note.getNoteId());
        notesToUpdate.setNotes(note.getNotes());
        sessionFactory.getCurrentSession().update(notesToUpdate);

    }

    public Notes getNote(int noteId) {
        Notes note = (Notes) sessionFactory.getCurrentSession().get(Notes.class, noteId);
        return note;
    }

    public void deleteNote(int noteId) {
        Notes note = getNote(noteId);
        if (note != null)
            sessionFactory.getCurrentSession().delete(note);
    }

    @SuppressWarnings("unchecked")
    public List<Notes> getNotes() {
        return sessionFactory.getCurrentSession().createCriteria(Notes.class).list();
    }

}
