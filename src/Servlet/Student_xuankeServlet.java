package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Bean.teacherclass;
import Dao.Dao;

/**
 * Servlet implementation class Student_lookclassServlet
 */
@WebServlet("/Student_xuankeServlet")
public class Student_xuankeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Student_xuankeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		list(request,response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Dao dao = new  Dao();
		java.util.List<teacherclass> stuc = dao.xuankelist();
		request.setAttribute("List", stuc);
		request.getRequestDispatcher("Student_xuanke.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
