package entities;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
/**
 *
 * @author djim
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Column(name = "date_creation")
    protected LocalDate dateCreation;

    public BaseEntity() {
        this.dateCreation = LocalDate.now();
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

}
