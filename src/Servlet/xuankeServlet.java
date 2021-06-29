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
 * Servlet implementation class xuankeServlet
 */
@WebServlet("/xuankeServlet")
public class xuankeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xuankeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 设置从jsp或HTML中请求数据的值，也就是设置为中文，防止乱码
		String method = request.getParameter("method");
//		if("findclass".equals(method)) {
//		findclass(request,response);
//		}
//		if("findteacher".equals(method)) {
//			findteacher(request,response);
//		}
	//	if("xuanke".equals(method)) {
			xuanke(request,response);
		
	}

	private void xuanke(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		   String tcname= request.getParameter("classteachername");
		   String classname = request.getParameter("classname");
		   int nownumber =Integer.parseInt(request.getParameter("nownumber"));
			String stuid=null;
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie1 : cookies){
				if(cookie1.getName().equals("stu")){
				stuid = cookie1.getValue();
				System.out.println(stuid);
				}
				}
			Dao dao = new Dao();
		    Boolean b = dao.check(stuid,classname);
			if(b) {
			teacherclass cla = dao.findtea(classname);
			int number = dao.updatenumber(classname,nownumber);
		    Boolean f = dao.addxuanke_(cla,stuid,number); 
            request.setAttribute("message", "选课成功");
            request.getRequestDispatcher("Student_xuankeServlet").forward(request, response);
            }else {
            	request.setAttribute("message", "重复选课");
                request.getRequestDispatcher("Student_xuankeServlet").forward(request, response);
            }
	}

//	private void findteacher(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private void findclass(HttpServletRequest request, HttpServletResponse response) {
//	   String tcname= request.getParameter("classteachername");
//	   String classname = request.getParameter("classname");
//	   int nownumber =Integer.parseInt(request.getParameter("nownumber"));
//		String stuid=null;
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies){
//			if(cookie.getName().equals("stu")){
//			stuid = cookie.getValue();
//			System.out.println(stuid);
//			}
//			}
//		Dao dao = new Dao();
//		teacherclass cla = dao.findtea(classname);
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
