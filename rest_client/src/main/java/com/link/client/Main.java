package com.link.client;

import com.link.model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static boolean running = true;

    public static void main(String[] args) {

        String sid;
        String firstName;
        String lastName;
        Student student;
        List<Student> students;

        Scanner scanner = new Scanner(System.in);
        StudentApi restClient = new StudentApi();

        System.out.println("\n******************************************");
        System.out.println("Welcome to my first REST client.");
        System.out.println("******************************************");
        while (running){
            System.out.println("\n******************************************");
            System.out.println("What do you want to do?");
            System.out.println("read all students(1)");
            System.out.println("read one student(2)");
            System.out.println("add new student(3)");
            System.out.println("update student(4)");
            System.out.println("delete specific student(5)");
            System.out.println("delete all students(6)");
            System.out.println("exit(7)");

            int userChoice = scanner.nextInt();

            switch (userChoice){
                case 1:
                    //read all
                    students = restClient.getStudents();

                    for (Student std : students) {
                        System.out.println(std);
                    }
                    break;
                case  2:
                    //read one
                    System.out.print("SID:");
                    sid = scanner.next();
                    student = restClient.getStudent(sid);
                    System.out.print(student);
                    break;
                case 3:
                    //add new
                    System.out.print("SID:");
                    sid = scanner.next();
                    System.out.print("First name:");
                    firstName = scanner.next();
                    System.out.print("Last name:");
                    lastName = scanner.next();

                    student = new Student(sid, firstName, lastName);
                    students = restClient.addStudent(student);
                    for (Student std : students) {
                        System.out.println(std);
                    }

                    break;
                case 4:
                    //update existing
                    System.out.print("SID:");
                    sid = scanner.next();
                    System.out.print("First name:");
                    firstName = scanner.next();
                    System.out.print("Last name:");
                    lastName = scanner.next();

                    student = new Student(sid, firstName, lastName);
                    students = restClient.editStudent(student);
                    for (Student std : students) {
                        System.out.println(std);
                    }
                    break;
                case 5:
                    //delete one
                    System.out.print("SID:");
                    sid = scanner.next();
                    students = restClient.deleteOneStudent(sid);
                    for (Student std : students) {
                        System.out.println(std);
                    }
                    break;
                case 6:
                    //delete all
                    students = restClient.deleteAllStudents();

                    for (Student std : students) {
                        System.out.println(std);
                    }
                    break;
                case 7:
                    //close
                    running = false;
                    break;
                default:
                    break;
            }
        }

    }
}
