package com.link.client;

import com.link.model.Student;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class StudentApi {

    public List<Student> getStudents() {
        List<Student> students;
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target("http://localhost:8080/rest_service")
                    .path("student")
                    .request("application/json")
                    .get();
            students = response.readEntity(new GenericType<>() {
            });
        }
        return students;
    }

    public Student getStudent(String sid) {

        Student student = new Student();
        try (Client client = ClientBuilder.newClient()) {

            Response response = client

                    .target("http://localhost:8080/rest_service")
                    .path("student")
                    .queryParam("sid", sid)
                    .request("application/json")
                    .get();

            List<Student> students = response.readEntity(new GenericType<>() {
            });

            student = students.get(0);
        }

        return student;

    }


    public List<Student> addStudent(Student studentNew){

        List<Student> students;

        try (Client client = ClientBuilder.newClient()){

            Response response = client

                    .target("http://localhost:8080/rest_service")

                    .path("student")

                    .request("application/json")

                    .post(Entity.entity(studentNew, MediaType.APPLICATION_JSON));

            students = response.readEntity(new GenericType<>() {});
            response.close();

        }
        return students;
    }

    public List<Student> editStudent(Student studentExisting){
        List<Student> students;
        try (Client client = ClientBuilder.newClient()){
            Response response = client
                    .target("http://localhost:8080/rest_service")
                    .path("student")
                    .request("application/json")
                    .put(Entity.entity(studentExisting, MediaType.APPLICATION_JSON));
            students = response.readEntity(new GenericType<>() {});
            response.close();
        }
        return students;
    }


    public List<Student> deleteOneStudent(String sid) {
        List<Student> students;
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target("http://localhost:8080/rest_service")
                    .path("student")
                    .queryParam("sid", sid)
                    .request("application/json")
                    .delete();
            students = response.readEntity(new GenericType<>() {
            });
            response.close();
        }
        return students;
    }


    public List<Student> deleteAllStudents() {
        List<Student> students;

        try (Client client = ClientBuilder.newClient()){
            Response response = client
                    .target("http://localhost:8080/first_rest_service")
                    .path("student")
                    .request("application/json")
                    .delete();
            students = response.readEntity(new GenericType<>() {});
            response.close();
        }
        return students;
    }

}