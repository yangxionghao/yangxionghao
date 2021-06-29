package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Student;
import Dao.Dao;


@WebServlet("/Student_updateServlet")
public class Student_updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Student_updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	update(request,response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String Stuid = request.getParameter("Stuid");
		String Stuname=request.getParameter("Stuname");
		String Stusex = request.getParameter("Stusex");
		String Stuclass=request.getParameter("Stuclass");
		String Stuxueyuan = request.getParameter("Stuxueyuan");
	    Dao dao=new Dao();
	    Student stu = new Student(Stuid,Stuname,Stusex,Stuclass,Stuxueyuan,null);
	    Boolean f= dao.Stuupdate(stu);
	    if(f) {
	    	request.setAttribute("message", "修改成功");
	    	request.setAttribute("stu", stu);
	    	request.getRequestDispatcher("Student_update.jsp").forward(request, response);
	    }else {
	    	request.setAttribute("message", "修改失败");
	    	request.setAttribute("stu", stu);
	    	request.getRequestDispatcher("Student_update.jsp").forward(request, response);
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
