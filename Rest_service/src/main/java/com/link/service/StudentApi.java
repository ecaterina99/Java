package com.link.service;

import jakarta.ws.rs.*;
import com.link.model.Student;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/student")
public class StudentApi {

    private final static ArrayList<Student> students = new ArrayList<Student>() {{
        add(new Student("11/22", "Chad", "Farley"));
        add(new Student("24/22", "Dominic", "Bonilla"));
        add(new Student("15/21", "Mario", "Donovan"));
    }};

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> getStudents(@QueryParam("sid") String sid) {
        {
            if (sid == null) {
                return students;
            } else {
                return students.stream().filter(x -> x.getSid().equals(sid)).collect(Collectors.toList());
            }
        }
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public List<Student> postStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
        return students;
    }


    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public List<Student> editStudent(Student student) {

        Student studentEdit = null;
        if (student != null) {
            studentEdit = students.stream().filter(std -> std.getSid().equals(student.getSid())).findFirst().orElse(null);
        }
        if (studentEdit != null) {
            studentEdit.setFirstName(student.getFirstName());
            studentEdit.setLastName(student.getLastName());
        }
        return students;
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public List<Student> removeStudent(@QueryParam("sid") String sid) {

        if (sid != null) {
            students.removeIf(student -> student.getSid().equals(sid));
        } else {
            students.clear();
        }
        return students;

    }
}
