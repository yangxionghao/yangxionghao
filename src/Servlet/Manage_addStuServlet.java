package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Student;
import Bean.Teacher;
import Dao.Dao;

/**
 * Servlet implementation class Manage_addStuServlet
 */
@WebServlet("/Manage_addStuServlet")
public class Manage_addStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Manage_addStuServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    addstu(request,response);
	}


	private void addstu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String Stuid = request.getParameter("Stuid");
			String Stuname = request.getParameter("Stuname");
			String Stusex = request.getParameter("Stusex");
			String Stuclass = request.getParameter("Stuclass");
			String Stuxueyuan = request.getParameter("Stuxueyuan");
			String password ="123";//设置初始密码为123;
			Student stu = new Student(Stuid,Stuname,Stusex,Stuclass,Stuxueyuan,password);
			Dao dao = new Dao();
			Boolean f= dao.addstudent(stu);
			if(f) {
				request.setAttribute("message", "添加成功！");
				request.getRequestDispatcher("Manage_addStu.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "添加成功！");
				request.getRequestDispatcher("Manage_addStu.jsp").forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
