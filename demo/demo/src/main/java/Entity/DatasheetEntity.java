package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Datasheet", schema = "startcode", catalog = "")
public class DatasheetEntity {
    private int id;
    private String semester;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "semester")
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatasheetEntity that = (DatasheetEntity) o;
        return id == that.id && Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, semester);
    }
}
