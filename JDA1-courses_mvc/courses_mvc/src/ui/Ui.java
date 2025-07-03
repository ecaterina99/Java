package ui;

import db.Course;

import java.util.Scanner;

public class Ui {
	
	public final static int invalidCommand = 0;
	public final static int ShowCourses = 1;
	public final static int AddCourse = 2;
	public final static int UpdateCourse = 3;
	public final static int DeleteCourse = 4;
	public final static int ExitProgram = 5;
	
	public int menu() {
		System.out.println("" + ShowCourses + " – Show courses, " + AddCourse + " – Add course, " +
				                   UpdateCourse + " - Update course, " + DeleteCourse +
				                   " – Delete course, " + ExitProgram + " - Exit program");
		
		Scanner scanner = new Scanner(System.in);
		int selectedOption = 0;
		while(true) {
			try {
				selectedOption = Integer.parseInt(scanner.nextLine());
				
				if(selectedOption < 1 || selectedOption > 5) {
					System.out.println("Menu item does not exist, try again");
					continue;
				}
				
				break;
			}
			catch(Exception e) {
				System.out.println("please, enter valid menu item number");
			}
		}
		
		//return 0;
		return selectedOption;
	}
	
	public int getCourseId() {
		System.out.println("insert course id");
		
		Scanner scanner = new Scanner(System.in);
		int selectedId = 0;
		while(true) {
			try {
				selectedId = Integer.parseInt(scanner.nextLine());
				
				break;
			}
			catch(Exception e) {
				System.out.println("please, enter valid id");
			}
		}
		
		return selectedId;
	}
	
	public Course getCourse() {
		Course res = new Course();
		Scanner scanner = new Scanner(System.in);
		
		while(res.title == null) {
			System.out.println("enter course title");
			String title = scanner.nextLine();
			if(title.isEmpty()) {
				System.out.println("title cannot be empty");
				continue;
			}
			res.title = title;
			System.out.println("enter course description");
			res.description = scanner.nextLine();
			
		}
		return res;
	}
	
	public void updateCourse(Course course) {
		Scanner scanner = new Scanner(System.in);
		
		//while(true) {
		System.out.println("enter course title");
		String title = scanner.nextLine();
		if(!title.isEmpty()) {
			course.title = title;
		}
		
		System.out.println("enter course description");
		String description = scanner.nextLine();
		if(!description.isEmpty()) {
			course.description = description;
		}
		//}
	}
}
