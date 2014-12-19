package com.rohit.java;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rohit.java.Constants;

public class ContactBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name,dob,phno,gender,emails,tags,sl_no;

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhno() {
		return phno;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}
	

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getSl_no() {
		return sl_no;
	}

	public void setSl_no(String sl_no) {
		this.sl_no = sl_no;
	}

	public String validate()
	{
		StringBuilder sb=new StringBuilder();
		
		if(name==null || name.trim().equals(""))
			sb.append(" Name is blank. It should not be! <br/>");
		if(emails == null || emails.trim().equals(""))
			sb.append(" Emails should not be blank! <br/>");
		if(dob == null || dob.trim().equals(""))
			sb.append(" Dob is mandatory! </br>");
		if(dob!=null)
		{
		Pattern dateFrmtPtrn =Pattern.compile("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");;
        Matcher matcher1 = dateFrmtPtrn.matcher(phno);
        if (matcher1.find()) {
            
        } else {
            sb.append("Enter a valid Date as instructed");
        }
		}
		if(phno == null || phno.trim().equals(""))
			sb.append(" Phone number is mandatory! </br>");
		if(phno!=null)
		{
			Pattern mobNO = Pattern.compile("\\d{6,10}");
        Matcher matcher = mobNO.matcher(phno);
        if (matcher.find()) {
            
        } else {
            sb.append("Enter a valid mob number");
        }}
		if(gender == null || gender.trim().equals(""))
			sb.append(" Please Specify gender </br>");
		if(tags == null || tags.trim().equals(""))
			sb.append(" Please Enter tags </br>");
			
		if(!(sb.toString()).equals(""))
			return sb.toString();
		else
			return Constants.SUCCESS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phno == null) ? 0 : phno.hashCode());
		result = prime * result + ((sl_no == null) ? 0 : sl_no.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		if (!(obj instanceof ContactBean)) {
			return false;
		}
		ContactBean other = (ContactBean) obj;
		if (dob == null) {
			if (other.dob != null) {
				return false;
			}
		} else if (!dob.equals(other.dob)) {
			return false;
		}
		if (emails == null) {
			if (other.emails != null) {
				return false;
			}
		} else if (!emails.equals(other.emails)) {
			return false;
		}
		if (gender == null) {
			if (other.gender != null) {
				return false;
			}
		} else if (!gender.equals(other.gender)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (phno == null) {
			if (other.phno != null) {
				return false;
			}
		} else if (!phno.equals(other.phno)) {
			return false;
		}
		if (sl_no == null) {
			if (other.sl_no != null) {
				return false;
			}
		} else if (!sl_no.equals(other.sl_no)) {
			return false;
		}
		if (tags == null) {
			if (other.tags != null) {
				return false;
			}
		} else if (!tags.equals(other.tags)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ContactBean [name=" + name + ", dob=" + dob + ", phno=" + phno
				+ ", gender=" + gender + ", emails=" + emails + ", tags="
				+ tags + ", sl_no=" + sl_no + "]";
	}

	
}
