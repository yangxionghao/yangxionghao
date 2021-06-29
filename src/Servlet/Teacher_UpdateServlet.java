package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Teacher;
import Dao.Dao;

/**
 * Servlet implementation class Teacher_UpdateServlet
 */
@WebServlet("/Teacher_UpdateServlet")
public class Teacher_UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Teacher_UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	update(request,response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String teacherid = request.getParameter("teacherid");
		System.out.println(teacherid+"...");
		String teachername = request.getParameter("teachername");
		String teachersex = request.getParameter("teachersex");
		String teacherxueyuan = request.getParameter("teacherxueyuan");
		String teachertype = request.getParameter("teachertype");
		Dao dao = new Dao();
		Teacher tea = new Teacher(teacherid,teachername,teachersex,teacherxueyuan,teachertype,"123");
		Boolean f =dao.updateTeacher(tea);
		
		if(f) {
			request.setAttribute("message", "修改成功");
			request.setAttribute("tea", tea);
			request.getRequestDispatcher("teacher_update.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "修改失败");
			request.getRequestDispatcher("teacher_update.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
