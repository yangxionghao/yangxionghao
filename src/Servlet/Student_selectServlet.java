package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Student;
import Dao.Dao;

/**
 * Servlet implementation class Student_selectServlet
 */
@WebServlet("/Student_selectServlet")
public class Student_selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Student_selectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuid =request.getParameter("stuid");
		System.out.println(stuid);
		Dao dao =new Dao();
		Student stu =dao.Student_select(stuid);
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("Student_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
