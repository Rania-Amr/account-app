package com.dbrecords;

public class AccountInfo {
	
	private String email;
	private String fname;
	private String lname;
	private String phone;
	private String birthdate;
	private String password;
	private String lastSeen;
	private String department;
	public void reset(){
        
        this.birthdate = "";
                this.department = "";
                this.email  = "";
                this.fname  = "";
                this.lastSeen  = "";
                this.lname  = "";
                this.password  = "";
                this.phone  = "";
   }

	
	public void setEmail(String email) {
        this.email = email;
    }
	public void setFname(String fname) {
        this.fname = fname;
    }
	public void setLname(String lname) {
        this.lname = lname;
    }
	public void setPhone(String phone) {
        this.phone = phone;
    }
	public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
	public void setPassword(String password) {
        this.password = password;
        
    }
	public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
        
    }
	public void setDepartment(String department) {
        this.department = department;
        
    }
	

    public String getEmail() {
        return email;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public String getPhone() {
        return phone;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public String getPassword() {
        return password;
    }
    public String getLastSeen() {
        return lastSeen;
    }
    public String getDepartment() {
        return department;
    }
}
