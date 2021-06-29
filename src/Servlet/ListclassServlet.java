package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.teacherclass;
import Dao.Dao;

/**
 * Servlet implementation class ListclassServlet
 */
@WebServlet("/ListclassServlet")
public class ListclassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListclassServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		list(request,response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String classteachername = null;
	Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("tea")){
			classteachername = cookie.getValue();
			}
			}
		System.out.println(classteachername);
		Dao dao = new  Dao();
		java.util.List<teacherclass> tclass = dao.list(classteachername);
		request.setAttribute("List", tclass);
		request.getRequestDispatcher("ListStu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
