package ctrl;

import db.Course;
import db.Db;
import ui.Ui;

import java.sql.SQLException;
import java.util.List;

public class Controller {
	public Db db;
	public Ui ui;
	
	public void showCourses() throws SQLException {
		List allCourses = db.getAllCourses();
		
		System.out.println("id\ttitle\tdescription");
		System.out.println("-----------------------------------------------------");
		for(Object o : allCourses) {
			Course course = (Course) o;
			System.out.println(course);
		}
	}
	
	public void addCourse() throws SQLException {
		Course toAdd = ui.getCourse();
		db.insertCourse(toAdd);
	}
	
	public void deleteCourse() throws SQLException {
		int id = ui.getCourseId();
		db.deleteCourse(id);
	}
	
	public void updateCourse() throws SQLException {
		int id = ui.getCourseId();
		Course courseToUpdate = db.getCourse(id);
		if(courseToUpdate == null) {
			System.out.println("course does not exist in database");
			return;
		} else {
		ui.updateCourse(courseToUpdate);
		db.updateCourse(courseToUpdate);
		}
	}
}
