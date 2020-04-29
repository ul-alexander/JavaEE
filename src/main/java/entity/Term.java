package entity;

import entity.disciplines.Discipline;

import java.util.LinkedList;
import java.util.Objects;

public class Term {

    private int id;
    private String name;
    private String duration;

    private LinkedList<Discipline> disciplines = new LinkedList<Discipline>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


    public LinkedList<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(LinkedList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public void addDiscipline(Discipline discipline) {
        disciplines.add(discipline);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;
        Term term = (Term) o;
        return getId() == term.getId() &&
                Objects.equals(getName(), term.getName()) &&
                Objects.equals(getDuration(), term.getDuration()) &&
                Objects.equals(getDisciplines(), term.getDisciplines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDuration(), getDisciplines());
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", disciplines=" + disciplines +
                '}';
    }
}
