package Bean;

public class teacherclass {
public String classid;
public String classname;
public int classnumber;
public String classteachername;
public int nownumber;

public int getNownumber() {
	return nownumber;
}
public void setNownumber(int nownumber) {
	this.nownumber = nownumber;
}
public String getClassteachername() {
	return classteachername;
}
public void setClassteachername(String classteachername) {
	this.classteachername = classteachername;
}
public String getClassid() {
	return classid;
}
public void setClassid(String classid) {
	this.classid = classid;
}
public String getClassname() {
	return classname;
}
public void setClassname(String classname) {
	this.classname = classname;
}
public int getClassnumber() {
	return classnumber;
}
public void setClassnumber(int classnumber) {
	this.classnumber = classnumber;
}

public teacherclass(String classid, String classname, int classnumber, String classteachername, int nownumber) {
	super();
	this.classid = classid;
	this.classname = classname;
	this.classnumber = classnumber;
	this.classteachername = classteachername;
	this.nownumber = nownumber;
}


}
