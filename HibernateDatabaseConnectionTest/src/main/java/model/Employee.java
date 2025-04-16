package model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "employees")
@Getter
@NoArgsConstructor

public class Employee {

    public Employee(String firstName, String lastName, Integer idJob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idJob = idJob;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;


    @Column(name = "job_id", nullable = false)
    private int idJob;

    @Column(name = "birth_date")
    private Date birthDate;

    public int getIdJob() {
        return idJob;
    }
    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }


    @Override
    public String toString() {
        return
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idJob=" + idJob;
    }
}
