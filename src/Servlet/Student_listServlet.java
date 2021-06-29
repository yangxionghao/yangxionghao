package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Student;
import Bean.teacherclass;
import Dao.Dao;

/**
 * Servlet implementation class Student_listServlet
 */
@WebServlet("/Student_listServlet")
public class Student_listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_listServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
list(request,response);
	}

	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String classname = request.getParameter("classname");
		Dao dao = new Dao();
		java.util.List<String> stuid = dao.Student_list(classname);
		System.out.println(stuid);
//	java.util.List<Student> stu_list=null;
//		for(int i=0;i<stuid.size();i++) {
//		String test = (String)stuid.get(i);
//		System.out.println(test);
//		stu_list= dao.Student1_list(test);	
//		request.setAttribute("stu_list", stu_list);
//		} 
		request.setAttribute("stuid", stuid);
		request.getRequestDispatcher("Student_list1.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
