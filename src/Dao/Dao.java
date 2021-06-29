package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Bean.Student;
import Bean.Teacher;
import Bean.User;
import Bean.teacherclass;
import DBUtil.DBUtil;


public class Dao {
public static String sql;
	public Boolean Managedenglu(User user) {
		if(user.usertype.equals("管理员")) {
		sql = "select * from xuanke where userid='"+user.getUserid()+"' and userpass='"+user.getUserpass()+"'";
		System.out.println(sql);
		}
		if(user.usertype.equals("教师")){
			sql = "select * from xuanke_teacher where teacherid='"+user.getUserid()+"' and password='"+user.getUserpass()+"'";	
		}
		if(user.usertype.equals("同学")){
			sql = "select * from xuanke_Stu where Stuid='"+user.getUserid()+"' and password='"+user.getUserpass()+"'";	
		}
		Connection conn = DBUtil.getConn();
		Statement Stat = null;
		Boolean f= false;
		try {
			Stat = conn.createStatement();
			ResultSet rs=Stat.executeQuery(sql);
			if(rs.next()) {
				f =  true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public Boolean addteacher(Teacher teacher) {
		String sql = "insert into xuanke_teacher(teacherid,teachername,teachersex,teacherxueyuan,teachertype,password)values('"+teacher.getTeacherid()+"','"+teacher.getTeachername()+"','"+teacher.getTeachersex()+"','"+teacher.getTeacherxueyuan()+"','"+teacher.getTeachertype()+"','"+teacher.getPassword()+"')";
		System.out.println(sql);
		Connection conn =DBUtil.getConn();
		Statement Stat = null;
		try {
			Stat=conn.createStatement();
			Stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally //finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），经常被用在需要释放资源的情况下。
		 {
			 DBUtil.close(Stat, conn); //close释放资源
		 }
		return true;
	}

	public Boolean addstudent(Student stu) {
		String sql = "insert into xuanke_stu(Stuid,Stuname,Stusex,Stuclass,Stuxueyuan,password)values('"+stu.getStuid()+"','"+stu.getStuname()+"','"+stu.getStusex()+"','"+stu.getStuclass()+"','"+stu.getStuxueyuan()+"','"+stu.getPassword()+"')";
		System.out.println(sql);
		Connection conn =DBUtil.getConn();
		Statement Stat = null;
		try {
			Stat=conn.createStatement();
			Stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally //finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），经常被用在需要释放资源的情况下。
		 {
			 DBUtil.close(Stat, conn); //close释放资源
		 }
		return true;
	}

	public Boolean addclass(teacherclass tc) {
	 String sql = "insert into xuanke_class(classid,classname,classnumber,tcname)values('"+tc.getClassid()+"','"+tc.getClassname()+"','"+tc.getClassnumber()+"','"+tc.getClassteachername()+"')";
	 System.out.println(sql);
	Connection conn =DBUtil.getConn();
	Statement Stat = null;
	try {
			Stat=conn.createStatement();
			Stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally //finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），经常被用在需要释放资源的情况下。
		 {
			 DBUtil.close(Stat, conn); //close释放资源
		 }
		return true;
	}

	public Teacher find(String userid) {//查找老师姓名，发送到添加课程的页面！
		String sql = "select * from xuanke_teacher where teacherid='"+userid+"'";
		System.out.println(sql);
		Connection conn = DBUtil.getConn();
		Statement stat = null;
		Teacher tea = null;
		try {
			stat=conn.createStatement();
			//ResultSet rs=Stat.executeQuery(sql);
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				String id = rs.getString("teacherid");
				String name= rs.getString("teachername");
				String sex= rs.getString("teachersex");
				String xueyuan=rs.getString("teacherxueyuan");
				String type = rs.getString("teachertype");
				tea = new Teacher(id,name,sex,xueyuan,type,"123");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return tea;
	}

	public teacherclass findtea(String classname) {//查找课程详细信息
		String sql = "select * from xuanke_class where classname='"+classname+"'";
		System.out.println(sql);
		Connection conn = DBUtil.getConn();
		Statement stat = null;
		teacherclass tea = null;
		try {
			stat=conn.createStatement();
			//ResultSet rs=Stat.executeQuery(sql);
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				String id = rs.getString("classid");
				String name= rs.getString("classname");
				int  classnumber= rs.getInt("classnumber");
				String tcname1=rs.getString("tcname");
				int nownumber = rs.getInt("nownumber");
				tea = new teacherclass(id,name,classnumber,tcname1,nownumber);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return tea;
	}
	
	public Boolean updateTeacher(Teacher tea) {
		String sql = "update xuanke_teacher set teachername='"+tea.getTeachername()+"',teachersex='"+tea.getTeachersex()+"',teacherxueyuan='"+tea.getTeacherxueyuan()+"' where teacherid='"+tea.getTeacherid()+"'";
		System.out.println(sql);
		Boolean f = null;
		Connection conn =DBUtil.getConn();
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			f=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			f=false;
		}
		
		return f;
	}



public List<teacherclass> list(String classteachername) {
	String sql = "select * from xuanke_class where tcname='"+classteachername+"'";
	System.out.println(sql);
	System.out.println(classteachername+"++++++++");
	List<teacherclass> list =new ArrayList<>();
	Connection conn =DBUtil.getConn();
	Statement stat = null;
	ResultSet rs = null;
	try {
		stat = conn.createStatement();
		rs=stat.executeQuery(sql);
		teacherclass tc = null;
		while(rs.next()) //这里表示，当rs.next()有值得时候，即收到查询结果
		{
			String classid=rs.getString("classid"); //注意：这里用双引号，ID是表grade_student里的ID列
			System.out.println("!"+classid);
			String classname=rs.getString("classname");
			int classnumber=rs.getInt("classnumber");
			int nownumber=rs.getInt("nownumber");
	        String teachername = rs.getString("tcname");
			tc=new teacherclass(classid,classname,classnumber,teachername,nownumber);
			list.add(tc); //表示，把bean里的数据存入到list当中
		}
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

			return list;
}

public Boolean Stuupdate(Student stu) {
      String sql="update xuanke_stu set Stuname='"+stu.getStuname()+"',Stusex='"+stu.getStusex()+"',Stuclass='"+stu.getStuclass()+"',Stuxueyuan='"+stu.getStuxueyuan()+"' where Stuid='"+stu.getStuid()+"'";
	 System.out.println("update stu "+sql);
	 Connection conn =DBUtil.getConn();
	 Statement stat = null;
	 Boolean f = true;
	 try {
		stat =conn.createStatement();
		stat.executeUpdate(sql);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		f=false;
	}
	 
      return f;
}

public Student findStu(String userid) {
	String sql = "select * from xuanke_stu where Stuid='"+userid+"'";
	System.out.println(sql);
	Connection conn = DBUtil.getConn();
	Statement stat = null;
	Student stu = null;
	try {
		stat=conn.createStatement();
		//ResultSet rs=Stat.executeQuery(sql);
		ResultSet rs = stat.executeQuery(sql);
		if(rs.next()) {
			String Stuid = rs.getString("Stuid");
			String Stuname= rs.getString("Stuname");
			String Stusex= rs.getString("Stusex");
			String Stuclass=rs.getString("Stuclass");
			String Stuxueyuan = rs.getString("Stuxueyuan");
			stu = new Student(Stuid,Stuname,Stusex,Stuclass,Stuxueyuan,"123");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return stu;
}

public List<teacherclass> clastulist() {
	String sql ="select * from xuanke_class";
	Connection conn = DBUtil.getConn();
	Statement stat = null;
	List<teacherclass> list = new ArrayList<>();
	ResultSet rs = null;
	teacherclass claStu= null;
	try {
		stat=conn.createStatement();
		rs=stat.executeQuery(sql);
		while(rs.next()) {
			String tcname= rs.getString("tcname");
			String classid = rs.getString("classid");
			String classname = rs.getString("classname");
			int classnumber = rs.getInt("classnumber");
			int nownumber = rs.getInt("nownumber");
			claStu= new teacherclass(classid,classname,classnumber,tcname,nownumber);
			list.add(claStu);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return list;
}

public List<teacherclass> xuankelist() {
	String sql ="select * from xuanke_class";
	Connection conn = DBUtil.getConn();
	Statement stat = null;
	List<teacherclass> list = new ArrayList<>();
	ResultSet rs = null;
	teacherclass claStu= null;
	try {
		stat=conn.createStatement();
		rs=stat.executeQuery(sql);
		while(rs.next()) {
			int classnumber = rs.getInt("classnumber");
			int nownumber = rs.getInt("nownumber");
			if(classnumber>nownumber) {
			String tcname= rs.getString("tcname");
			String classid = rs.getString("classid");
			String classname1 = rs.getString("classname");
		
			claStu= new teacherclass(classid,classname1,classnumber,tcname,nownumber);
			list.add(claStu);
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}

public int numberclass(String classteachername) {

	return 0;
}

public Boolean addxuanke_(teacherclass cla, String stuid,int number) {
	String sql = "insert into xuanke1 values('"+stuid+"','"+cla.getClassteachername()+"','"+cla.getClassid()+"','"+cla.getClassname()+"','"+number+"','"+cla.getClassnumber()+"')";
	System.out.println("xuanke  "+sql);
	Connection conn = DBUtil.getConn();
	Statement stat = null;
	try {
		stat=conn.createStatement();
		stat.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return true;
}

public int updatenumber(String classname,int nownumber) {
	nownumber++;
	String sql ="update xuanke_class set nownumber='"+nownumber+"' where classname='"+classname+"'" ;
	Connection conn=DBUtil.getConn();
	Statement stat =null;
	int number=nownumber;
	try {
		stat=conn.createStatement();
		stat.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return number;
}

public Boolean check(String stuid, String classname) {
	String sql ="select * from xuanke1 where stuid='"+stuid+"' and classname='"+classname+"'";
	System.out.println(sql);
	Connection conn =DBUtil.getConn();
	Statement stat = null;
	try {
		stat =conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		if(rs.next()) {
			return false;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return true;
}

public Teacher listtea(String tcname) {
	String sql = "select * from xuanke_teacher where teachername = '"+tcname+"'";
	System.out.println(sql);
	Connection conn =DBUtil.getConn();
	Statement stat = null;
	Teacher tea = null;
	try {
		stat =conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			String id = rs.getString("teacherid");
			String name = rs.getString("teachername");
			String sex = rs.getString("teachersex");
			String xueyuan = rs.getString("teacherxueyuan");
			String type = rs.getString("teachertype");
		tea = new Teacher(id,name,sex,xueyuan,type,null);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	return tea;
}

public List<String> Student_list(String classname) {
	String sql = "select * from xuanke1 where classname='"+classname+"'";
	System.out.println(sql);
	Connection conn = DBUtil.getConn();
	Statement stat = null;
	List<String> list = new ArrayList<>();
	ResultSet rs = null;
	try {
		stat=conn.createStatement();
		rs=stat.executeQuery(sql);
		
		while(rs.next()) {
			String stuid = rs.getString("stuid");

			list.add(stuid);
			}
		}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}

public List<Student> Student1_list(String test) {
	String sql = "select * from xuanke_stu where Stuname='"+test+"'";
	System.out.println(sql);
	Connection conn = DBUtil.getConn();
	Statement stat = null;
	List<Student> list = new ArrayList<>();
	ResultSet rs = null;
	Student stu = null;
	try {
		stat=conn.createStatement();
		rs=stat.executeQuery(sql);
		
		while(rs.next()) {
			String stuid = rs.getString("Stuid");
            String name =rs.getString("Stuname");
            String sex =rs.getString("Stusex");
            String sclass =rs.getString("Stuclass");
            String xueyuan =rs.getString("Stuxueyuan");
           stu=new Student(stuid,name,sex,sclass,xueyuan,null);
			list.add(stu);
			}
		}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}

public Student Student_select(String stuid) {
 String sql="select * from xuanke_stu where Stuid='"+stuid+"'";
 System.out.println(sql);
 Connection conn = DBUtil.getConn();
 ResultSet rs = null;
 Student stu=null;
 Statement stat = null;
 try {
	stat=conn.createStatement();
	rs=stat.executeQuery(sql);
	if(rs.next()) {
		String Stuid = rs.getString("Stuid");
		String Stuname= rs.getString("Stuname");
		String Stusex= rs.getString("Stusex");
		String Stuclass=rs.getString("Stuclass");
		String Stuxueyuan = rs.getString("Stuxueyuan");
		stu = new Student(Stuid,Stuname,Stusex,Stuclass,Stuxueyuan,"123");
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
 
	return stu;
}

public Teacher test() {
	String sql = "select * from xuanke_teacher";
	System.out.println(sql);
	Connection conn =DBUtil.getConn();
	Statement stat = null;
	Teacher tea = null;
	try {
		stat =conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			String id = rs.getString("teacherid");
			String name = rs.getString("teachername");
			String sex = rs.getString("teachersex");
			String xueyuan = rs.getString("teacherxueyuan");
			String type = rs.getString("teachertype");
		tea = new Teacher(id,name,sex,xueyuan,type,null);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return tea;
}




}
