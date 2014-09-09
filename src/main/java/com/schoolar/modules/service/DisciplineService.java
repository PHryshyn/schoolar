package com.schoolar.modules.service;


import com.schoolar.modules.model.Discipline;

import java.util.List;

public interface DisciplineService extends BasicService<Discipline, Integer> {

    void updateDiscipline(Discipline discipline);

}
