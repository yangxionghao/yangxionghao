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
 * Servlet implementation class Teacher_listServlet
 */
@WebServlet("/Teacher_listServlet")
public class Teacher_listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher_listServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    list(request,response);
	    System.out.println("***************************");
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8"); 
		String tcname = request.getParameter("teachername");
		System.out.println(tcname);
	     Dao dao =new Dao();
		 Teacher tea = dao.listtea(tcname);
		 request.getSession().setAttribute("tea", tea);
		 request.getRequestDispatcher("Teacher_list.jsp").forward(request, response);
	}
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
