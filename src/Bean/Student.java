package Bean;

public class Student {
public String stuid;
public String stuname;
public String stusex;
public String stuclass;
public String stuxueyuan;
public String password ;
public String getStuid() {
	return stuid;
}
public void setStuid(String stuid) {
	this.stuid = stuid;
}
public String getStuname() {
	return stuname;
}
public void setStuname(String stuname) {
	this.stuname = stuname;
}
public String getStusex() {
	return stusex;
}
public void setStusex(String stusex) {
	this.stusex = stusex;
}
public String getStuclass() {
	return stuclass;
}
public void setStuclass(String stuclass) {
	this.stuclass = stuclass;
}
public String getStuxueyuan() {
	return stuxueyuan;
}
public void setStuxueyuan(String stuxueyuan) {
	this.stuxueyuan = stuxueyuan;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Student(String stuid, String stuname, String stusex, String stuclass, String stuxueyuan, String password) {
	super();
	this.stuid = stuid;
	this.stuname = stuname;
	this.stusex = stusex;
	this.stuclass = stuclass;
	this.stuxueyuan = stuxueyuan;
	this.password = password;
}


}
