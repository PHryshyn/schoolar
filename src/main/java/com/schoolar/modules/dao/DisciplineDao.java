package com.schoolar.modules.dao;

import com.schoolar.modules.model.Discipline;


import java.util.List;

public interface DisciplineDao extends CrudInterface {

    void update(Discipline discipline);

    void add(Discipline discipline);



}
