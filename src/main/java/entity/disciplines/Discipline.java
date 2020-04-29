package entity.disciplines;

import java.util.Objects;

public class Discipline {

    private int id;
    private String discipline;
    private int status = 1;

    public Discipline() {
    }

    public Discipline(int id, String discipline, int status) {
        this.id = id;
        this.discipline = discipline;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", discipline='" + discipline + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discipline)) return false;
        Discipline that = (Discipline) o;
        return getId() == that.getId() &&
                getStatus() == that.getStatus() &&
                Objects.equals(getDiscipline(), that.getDiscipline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDiscipline(), getStatus());
    }
}
