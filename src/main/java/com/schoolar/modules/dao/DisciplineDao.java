package com.schoolar.modules.dao;

import com.schoolar.modules.model.Discipline;


import java.util.List;

public interface DisciplineDao {
    public void addDiscipline(Discipline discipline);
    public void updateDiscipline(Discipline discipline);
    public Discipline getDiscipline(int disciplineId);
    public void deleteDiscipline(int disciplineId);
    public List<Discipline> getDisciplines();
}
