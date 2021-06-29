package Bean;

public class Teacher {
public String teacherid;
public String teachername;
public String teachersex;
public String teacherxueyuan;
public String teachertype;
public String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = "123";
}
public String getTeacherid() {
	return teacherid;
}
public void setTeacherid(String teacherid) {
	this.teacherid = teacherid;
}
public String getTeachername() {
	return teachername;
}
public void setTeachername(String teachername) {
	this.teachername = teachername;
}
public String getTeachersex() {
	return teachersex;
}
public void setTeachersex(String teachersex) {
	this.teachersex = teachersex;
}
public String getTeacherxueyuan() {
	return teacherxueyuan;
}
public void setTeacherxueyuan(String teacherxueyuan) {
	this.teacherxueyuan = teacherxueyuan;
}
public String getTeachertype() {
	return teachertype;
}
public void setTeachertype(String teachertype) {
	this.teachertype = teachertype;
}
public Teacher(String teacherid, String teachername, String teachersex, String teacherxueyuan, String teachertype,String password) {
	super();
	this.teacherid = teacherid;
	this.teachername = teachername;
	this.teachersex = teachersex;
	this.teacherxueyuan = teacherxueyuan;
	this.teachertype = teachertype;
	this.password=password;
}

}
