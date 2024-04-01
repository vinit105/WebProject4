

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controller.DBHandler;
import Controller.Operation;
import Controller.Student;
/* Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		boolean flag=false;
		int index=0;
		try {
			ArrayList<Student> list = DBHandler.list();
			for(int i=0; i<list.size()-1; i++) {
				if(id == list.get(i).getId()) {
					index=i+1;
					flag = true;
					Operation.find(index);
					response.sendRedirect("index.jsp");
				}
			}
			if(!flag) {
				response.sendRedirect("index.jsp");
				 JOptionPane.showMessageDialog(null, "No Id Found!..");	
				 
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
