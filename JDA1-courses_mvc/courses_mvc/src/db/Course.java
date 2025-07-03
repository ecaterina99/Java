package db;

public class Course {
	public int id;
	public String title;
	public String description;
	
	@Override
	public String toString() {
		return id + "\t" + title + "\t" + description;
	}
}
