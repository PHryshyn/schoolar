package com.schoolar.modules.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shedule")
public class Shedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shedule_id")
    private Integer sheduleId;


    @OneToMany
    private Set<Discipline> disciplines = new HashSet<Discipline>(0);

    public Shedule() {
    }

    public Shedule(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public Integer getSheduleId() {
        return sheduleId;
    }

    public void setSheduleId(Integer sheduleId) {
        this.sheduleId = sheduleId;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}