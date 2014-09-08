package com.schoolar.modules.service.Impl;


import com.schoolar.modules.dao.NotesDao;
import com.schoolar.modules.model.Notes;
import com.schoolar.modules.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("notesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NotesServiceImpl implements NotesService {

    @Autowired
    @Qualifier(value = "notesDao")
    private NotesDao notesDao;

    @Override
    @Transactional(readOnly = false)
    public void saveNotes(Notes notes) {
        notesDao.saveNotes(notes);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateNotes(Notes notes) {
        notesDao.updateNotes(notes);
    }

    @Override
    @Transactional
    public Notes findByIdNotes(int noteId) {
        return notesDao.findByIdNotes(noteId);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteNotes(int noteId) {
        notesDao.deleteNotes(noteId);
    }

    @Override
    @Transactional
    public List<Notes> getNotesList() {
        return notesDao.getNotesList();
    }

    public NotesServiceImpl() {
    }
}
