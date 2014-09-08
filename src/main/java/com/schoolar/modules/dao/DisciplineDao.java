package com.schoolar.modules.dao;

import com.schoolar.modules.model.Discipline;

import java.util.List;

public interface DisciplineDao extends BasicCrudDao<Discipline, Integer> {

    void saveDiscipline(Discipline discipline);
    void updateDiscipline(Discipline discipline);
    Discipline findByIdDiscipline(int disciplineId);
    void deleteDiscipline(int disciplineId);
    List<Discipline> getDisciplineList();



}
