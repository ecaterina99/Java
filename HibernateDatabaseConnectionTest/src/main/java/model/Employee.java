package model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    public Employee(String firstName, String lastName, Integer idJob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idJob = idJob;
    }
    public Employee() {
    }

    @Id
    private int id;

    public int getId() {
        return id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
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
