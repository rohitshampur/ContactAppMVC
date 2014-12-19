package com.rohit.java;

public class LogBean {
	public LogBean() {
		// TODO Auto-generated constructor stub
	}
	private String email,pass,name;
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String validate()
	{	
		System.out.println("inside validate() of LogBean");
		String msg="";
		if(email==null||email.trim().equals(""))
		return msg+" Please Enter email to login";
		if(pass==null||pass.trim().equals(""))
			return msg+ "Password Emty please enter your password";
		else
			return Constants.SUCCESS;
	
	}
	
	@Override
	public String toString() {
		return "LogBean [email=" + email + ", pass=" + pass + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LogBean)) {
			return false;
		}
		LogBean other = (LogBean) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (pass == null) {
			if (other.pass != null) {
				return false;
			}
		} else if (!pass.equals(other.pass)) {
			return false;
		}
		return true;
	}
	

}
