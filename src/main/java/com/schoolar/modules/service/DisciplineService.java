package com.schoolar.modules.service;


import com.schoolar.modules.model.Discipline;

import java.util.List;

public interface DisciplineService {
    void saveDiscipline(Discipline discipline);
    void updateDiscipline(Discipline discipline);
    Discipline findByIdDiscipline(int disciplineId);
    void deleteDiscipline(int disciplineId);
    List<Discipline> getDisciplineList();
}
