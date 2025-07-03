package ctrl;

import db.Db;
import ui.Ui;

import java.sql.SQLException;

public class Application {
	public static void launch() throws SQLException {
		System.out.println("courses editor V 001 is running!");
		
		Controller ctrl = new Controller();
		
		ctrl.db = new Db();
		ctrl.ui = new Ui();
		
		/*int selectMenuItem = ctrl.ui.menu();
		System.out.println(selectMenuItem);*/
		
		mainLoop:
		while(true) {
			//System.out.println(ctrl.ui.menu());
			
			switch(ctrl.ui.menu()) {
			
			case Ui.ShowCourses:
				ctrl.showCourses();
			break;
			
			case Ui.AddCourse:
				ctrl.addCourse();
			break;
			
			case Ui.UpdateCourse:
				ctrl.updateCourse();
			break;
			
			case Ui.DeleteCourse:
				ctrl.deleteCourse();
			break;
			
			//case 5:
			case Ui.ExitProgram:
				//System.exit(0);
				System.out.println("bye bye");
				break mainLoop;
			//break;
			}
		}
		
	}
}
