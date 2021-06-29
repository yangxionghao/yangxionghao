package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Student;
import Bean.Teacher;
import Bean.User;
import Dao.Dao;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ManagerServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Managedenglu(request,response);
		
	}
	
	private void Managedenglu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String usertype = request.getParameter("usertype");
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		User user = new User(usertype,userid,userpass);
		Dao dao =new Dao();
		Boolean f =dao.Managedenglu(user);
		System.out.println(f);
		if(f) {
		request.setAttribute(usertype,usertype);
		if(usertype.equals("管理员")) {
		request.getSession().setAttribute("usertype", usertype);
		request.setAttribute("message", "登陆成功！");
		request.getRequestDispatcher("Managehoutai.jsp").forward(request, response);
		}
		if(usertype.equals("教师")) {
			find(request,response);
			request.getSession().setAttribute("usertype", usertype);
			request.setAttribute("message", "登陆成功！");
			request.getRequestDispatcher("teacherhoutai.jsp").forward(request, response);
			}
		if(usertype.equals("同学")) {
			findStu(request,response);
			request.getSession().setAttribute("usertype", usertype);
			request.setAttribute("message", "登陆成功！");
			request.getRequestDispatcher("Studenthoutai.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("message", "用户编号或密码错误！");
			request.getRequestDispatcher("denglu.jsp").forward(request, response);
		}
	}
	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	Dao dao = new Dao();
	Teacher tea = dao.find(userid);
	request.getSession().setAttribute("tea", tea);
	   Cookie cookie = new Cookie("tea",tea.teachername);
	   cookie.setPath("/ChooseClass_System");
	   response.addCookie(cookie);
	}
	private void findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");
      String userid = request.getParameter("userid");
      System.out.println(userid+"ooo");
	  Dao dao = new Dao();
	  Student stu = dao.findStu(userid);
	  request.getSession().setAttribute("stu",stu);
	  System.out.println(stu.stuname+"fandstu");
	   Cookie cookie = new Cookie("stu",stu.stuid);
	   cookie.setPath("/ChooseClass_System");
	   response.addCookie(cookie);
	 //request.getRequestDispatcher("Student_update.jsp").forward(request, response);
	  // request.getAttribute("Student_update.jsp");
//	   Cookie cookie = new Cookie("stu",stu.teachername);
//	   cookie.setPath("/ChooseClass_System");
//	   response.addCookie(cookie);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
