import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class View {
	
	public ArrayList<Student> control() throws ClassNotFoundException, SQLException {
	@SuppressWarnings("unchecked")
	ArrayList<Student> a = (ArrayList<Student>) DBHandler.list();
	
	
	
//	 for(Student s: a ) {
//		 
//		 out.print(s.getId());
//		 out.print(s.getName());	
//		 out.print(s.getBranch());
//		 out.print(s.getSemester());
//	 } 
	
	return a;
	}
	
	ResultSet s = DBHandler.list();
}
