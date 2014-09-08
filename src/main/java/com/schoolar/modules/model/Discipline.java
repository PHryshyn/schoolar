package com.schoolar.modules.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "discipline")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "discipline_id")
    private int disciplineId;


    @Column(name = "discipline")
    private String discipline;

    public Discipline(String discipline) {
        this.discipline = discipline;
    }

    public Discipline() {
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
