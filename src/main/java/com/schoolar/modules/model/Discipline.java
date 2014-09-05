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

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Notes> notes;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Rating> ratings;



    public Discipline() {
    }

    public Discipline(String discipline, Set<Notes> notes, Set<Rating> ratings, UserData user) {
        this.discipline = discipline;
        this.notes = notes;
        this.ratings = ratings;

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

    public Set<Notes> getNotes() {
        return notes;
    }

    public void setNotes(Set<Notes> notes) {
        this.notes = notes;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }


}
