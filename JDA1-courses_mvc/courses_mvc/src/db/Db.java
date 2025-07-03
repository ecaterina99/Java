package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Db {
	public Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/courses", "root", "root");
		return conn;
	}
	
	public void insertCourse(Course course) throws SQLException {
		Connection conn = connect();
		Statement st = conn.createStatement();
		String query =
				"insert into courses values (null, '" + course.title + "','" + course.description +
						"')";
		st.execute(query);

		conn.close();
	}
	
	public void deleteCourse(int id) throws SQLException {
		Connection conn = connect();
		Statement st = conn.createStatement();
		String query = "delete from courses where id = " + id;
		st.execute(query);
		st.close();
		conn.close();
	}
	
	public void updateCourse(Course course) throws SQLException {
		Connection conn = connect();
		PreparedStatement st = conn.prepareStatement("update courses set title = ?, description = ? where id = ?");
		st.setString(1, course.title);
		st.setString(2, course.description);
		st.setInt(3, course.id);
		st.execute();
		st.close();
		conn.close();
	}
	
	public List<Course> getAllCourses() throws SQLException {
		List res = new ArrayList();
		
		Connection conn = connect();
		Statement st = conn.createStatement();
		String query = "select * from courses";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			Course course = new Course();
			course.id = rs.getInt("id");
			course.title = rs.getString("title");
			course.description = rs.getString("description");
			
			res.add(course);
		}
		
		st.close();
		conn.close();
		
		return res;
	}
	
	public Course getCourse(int id) throws SQLException {
		Course course = null;
		
		Connection conn = connect();
		
		PreparedStatement st = conn.prepareStatement("select * from courses where id = ?");
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			course = new Course();
			course.id = rs.getInt("id");
			course.title = rs.getString("title");
			course.description = rs.getString("description");
		}
		
		rs.close();
		st.close();
		conn.close();
		
		return course;
	}
}
