package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import Bean.teacherclass;
import Dao.Dao;

/**
 * Servlet implementation class Teacher_addclassServlet
 */
@WebServlet("/Teacher_addclassServlet")
public class Teacher_addclassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Teacher_addclassServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       addclass(request,response);
	}

	private void addclass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String classid = request.getParameter("classid");
		String classname = request.getParameter("classname");
		int classnumber = Integer.parseInt(request.getParameter("classnumber"));
		String classteachername = null;
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("tea")){
			classteachername = cookie.getValue();
			}
			}
System.out.println(classteachername);
		Dao dao = new Dao();
		teacherclass tc = new teacherclass(classid,classname,classnumber,classteachername,0);
		Boolean f = dao.addclass(tc);
		if(f) {
			request.setAttribute("message", "添加成功！");
			request.getRequestDispatcher("Teacher_addclass.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "添加失败！");
			request.getRequestDispatcher("Teacher_addclass.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
