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

    public NotesServiceImpl() {
    }

    @Override
    @Transactional(readOnly = false)
    public void updateNotes(Notes notes) {
        notesDao.updateNotes(notes);
    }

    @Override
    public void save(Notes notes) {
        notesDao.save(notes);
    }

    @Override
    public Notes findById(Integer noteId) {
        return notesDao.findById(noteId);
    }

    @Override
    public void delete(Integer noteId) {
        notesDao.delete(noteId);
    }

    @Override
    public List<Notes> getList() {
        return notesDao.getList();
    }
}
