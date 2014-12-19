//Application by Rohit
package com.rohit.java;

public class RegBean {
	private String name,email,pass,rpass;
	public RegBean() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRpass() {
		return rpass;
	}

	public void setRpass(String rpass) {
		this.rpass = rpass;
	}
	public String validate()
	{	
		System.out.println("inside validate() of RegBean");
		String msg = "";
		if(name==null||name.trim().equals(""))
		{
			msg = msg+"Your name is Mandatory<br/>";
		}
		if(email==null||email.trim().equals(""))
		{	
			msg = msg+" Email is Mandatory<br/>";
		}else
		{
			String mail = email;
			String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            Boolean b = mail.matches(emailreg);

            if (b == false) {
                msg=msg+"Email is Invalid";
            }//else if(b == true)
            	//msg= Constants.SUCCESS;
            
            
		}
		if(pass==null||pass.trim().equals(""))
		{
			msg = msg+" Password cannot be empty<br/>" ;
		}else 
			if(!pass.equals(rpass))
		{
			msg = msg+" Passwords doesn't match please re-enter";
		}if(msg.equals(""))
			return Constants.SUCCESS;
		else
		return msg;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((rpass == null) ? 0 : rpass.hashCode());
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
		if (!(obj instanceof RegBean)) {
			return false;
		}
		RegBean other = (RegBean) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (pass == null) {
			if (other.pass != null) {
				return false;
			}
		} else if (!pass.equals(other.pass)) {
			return false;
		}
		if (rpass == null) {
			if (other.rpass != null) {
				return false;
			}
		} else if (!rpass.equals(other.rpass)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "RegBean [name=" + name + ", email=" + email + ", pass=" + pass
				+ ", rpass=" + rpass + "]";
	}
	

}
