package com.schoolar.modules.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "discipline")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "discipline_id")
    private Integer disciplineId;

    @NotEmpty
    @Column(name = "discipline")
    @Pattern(regexp = "[a-zA-Z]*")
    private String discipline;

    public Discipline(String discipline) {
        this.discipline = discipline;
    }

    public Discipline() {
    }

    public Discipline(Integer DisciplineId, String discipline) {
        this.disciplineId = disciplineId;
        this.discipline = discipline;
    }


    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
