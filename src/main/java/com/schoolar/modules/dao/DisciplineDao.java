package com.schoolar.modules.dao;

import com.schoolar.modules.model.Discipline;

import java.util.List;

public interface DisciplineDao extends BasicCrudDao<Discipline, Integer> {

    void updateDiscipline(Discipline discipline);
    List<Discipline> disciplineList();

}
