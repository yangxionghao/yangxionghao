package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Teacher;
import Dao.Dao;

/**
 * Servlet implementation class Manage_addteaServlet
 */
@WebServlet("/Manage_addteaServlet")
public class Manage_addteaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manage_addteaServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     addteacher(request,response);
	}

	private void addteacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String teacherid = request.getParameter("teacherid");
		String teachername = request.getParameter("teachername");
		String teachersex = request.getParameter("teachersex");
		String teacherxueyuan = request.getParameter("teacherxueyuan");
		String teachertype = request.getParameter("teachertype");
		String password ="123";
		Teacher teacher = new Teacher(teacherid,teachername,teachersex,teacherxueyuan,teachertype,password);
		Dao dao = new Dao();
		Boolean f= dao.addteacher(teacher);
		if(f) {
			
			request.setAttribute("message", "添加成功！");
			request.getRequestDispatcher("Manage_addtea.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "添加成功！");
			request.getRequestDispatcher("Manage_addtea.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
