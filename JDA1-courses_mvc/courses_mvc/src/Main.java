import ctrl.Application;
import db.Course;
import db.Db;
import ui.Ui;

import java.sql.SQLException;

public class Main extends Application {
	public static void main(String[] args) throws SQLException {
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/courses", "root",
		// "root");
		
		//Statement st = conn.createStatement();
		//Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		//st.execute("insert into courses values (null, 'core java','java fundamentals')");
		
		//ResultSet rs = st.executeQuery("select * from courses");
		
		//boolean hasNext = rs.next();
		/*System.out.println(hasNext);
		
		hasNext = rs.next();
		System.out.println(hasNext);*/
		
		//rs.next();
		
		//int rowId = rs.getInt("id");
		/*int rowId = rs.getInt(1);
		System.out.println(rowId);*/
		 
		/*	String courseTitle = rs.getString("title");
		System.out.println(courseTitle);*/
		 
		/*rs.updateString("title", "core java");
		rs.updateRow();*/
	
		/*Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.nextLine());*/
		
		//Ui ui = new Ui();
		//ui.menu();
	/*	int selectedOption = ui.menu();
		System.out.println(selectedOption);*/
		
	/*	int selectedId = ui.getCourseId();
		System.out.println(selectedId);*/
		
		/*Course course = ui.getCourse();
		System.out.println(course);*/
		
		/*Course course = new Course();
		course.id = 5;
		course.title = "My Java Course ";
		course.description = "Something about Java";
		
		System.out.println(course);
		ui.updateCourse(course);
		System.out.println(course);*/
		
		//Course course= ui.getCourse();
		//Db db = new Db();
		//db.insertCourse(course);
		
		
	/*	int deleteid = ui.getCourseId();
		db.deleteCourse(deleteid);*/
		
		/*Course c = new Course();
		c.id = 1;
		c.title = "Hello";
		c.description = "world";
		
		db.updateCourse(c);*/
		
		//System.out.println(db.getAllCourses());
		
		//Course course = db.getCourse(3);
		/*Course course = db.getCourse(5);
		System.out.println(course);*/
		
		//Application.launch();
		launch();
	}
	
}
