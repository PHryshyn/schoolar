package com.schoolar.modules.service;


import com.schoolar.modules.model.Discipline;

import java.util.List;

public interface DisciplineService {

    void updateDiscipline(Discipline discipline);
    List<Discipline> disciplineList();
    void save(Discipline discipline);
    void delete(Integer disciplineId);
    Discipline findById(Integer disciplineId);
}
