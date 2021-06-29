package Bean;

public class User {
public String usertype;
public String userid;
public String userpass;
public String getUsertype() {
	return usertype;
}
public void setUsertype(String usertype) {
	this.usertype = usertype;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getUserpass() {
	return userpass;
}
public void setUserpass(String userpass) {
	this.userpass = userpass;
}
public User(String usertype, String userid, String userpass) {
	super();
	this.usertype = usertype;
	this.userid = userid;
	this.userpass = userpass;
}

}
