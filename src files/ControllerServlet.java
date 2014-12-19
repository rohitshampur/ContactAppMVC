package com.rohit.java;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rohit.java.RegBean;
import com.rohit.java.Constants;
import com.rohit.java.ContactBean;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doGet() of CS");
		process(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost() of CS");
		process(request,response);

	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside process() of CS");
		String uri = request.getRequestURI();
		RequestDispatcher rd = null;
		System.out.println(uri);
		Model m = new Model() ;
		HttpSession session = request.getSession();
		if(uri.contains("/openRegView"))
		{
			rd = request.getRequestDispatcher("/Register.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/openLoginView"))
		{
			rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/register"))
		{	
			
			System.out.println("inside if block of /register");
			RegBean rb = (RegBean) request.getAttribute("reg");
			
			String result = m.register(rb);
			if(result.equals(Constants.SUCCESS))
			{
				request.setAttribute("message", "Registration has succeeded! You can now login!!");
				rd = request.getRequestDispatcher("/Register.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("/Register.jsp");
				rd.forward(request, response);
			}
		}
			if(uri.contains("/login"))
			{
				System.out.println("inside if block of /login");
				LogBean lb =(LogBean)request.getAttribute("log");
				System.out.println(lb);
				String result = m.login(lb);
				System.out.println(result);
				if(result.equals(Constants.SUCCESS))
				{	
					//HttpSession s = request.getSession(true);
					
					session.setAttribute("email",lb.getEmail());
					session.setAttribute("pass", lb.getPass());
					request.setAttribute("message", "Login Sucessfull");
					rd = request.getRequestDispatcher("Menu.jsp");
					rd.forward(request, response);
				}	 
				else
				{
					request.setAttribute("errorMsg", result);
					rd = request.getRequestDispatcher("/Login.jsp");
					rd.forward(request, response);
				}
				
			}
			if(uri.contains("/logout"))
			{	System.out.println("inside /logout of CS");
			System.out.println(session.getId());
			rd = request.getRequestDispatcher("Logout.jsp");
			rd.forward(request, response);
			}
			if(uri.contains("/menu"))
			{	System.out.println("inside /menu of CS ");
			HttpSession s = request.getSession(false);
			System.out.println(s);
			if(s==null||s.getAttribute("email")==null)
				{
					rd = request.getRequestDispatcher("Menu.jsp");
					rd.forward(request, response);
					
				}else
				{
					//rd = request.getRequestDispatcher("/Login.jsp");
					//rd.forward(request, response);
					request.setAttribute("errorMsg", "Your session does not exist. Please login again");
					rd = request.getRequestDispatcher("HomePage.html");
					rd.forward(request, response);
				}
			}
			if(uri.contains("/editAcc"))
			{
				HttpSession s = request.getSession(false);
				System.out.println(s);
				System.out.println("inside if block of /editacc");
				System.out.println(s.getAttribute("email"));
				if(s==null||s.getAttribute("email")==null)
				{
					request.setAttribute("errorMsg", "Your session does not exist. Please login again");
					rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				else
				{	System.out.println("inside else block of /editacc");
					String email = (String) s.getAttribute("email");
					RegBean bean = m.getUserDetails(email);
					System.out.println(bean);
					request.setAttribute("userDetails", bean);
					rd = request.getRequestDispatcher("EditAccount.jsp");
					rd.forward(request, response);
				}
			}
			if(uri.contains("/updateRegister"))
			{
				System.out.println("inside if block of updateReg" );
				RegBean rb=(RegBean) request.getAttribute("update");
				System.out.println(rb);
				String result=m.updateRegister(rb);
				if(result.equals(Constants.SUCCESS))
				{
					System.out.println("Update Successfull");
					request.setAttribute("message", "Modification Successfull");
					rd=request.getRequestDispatcher("UpdateSuccess.jsp");
					rd.forward(request, response);
				}else
				{
					System.out.println("Update failed");
					request.setAttribute("errorMsg", result);
					rd=request.getRequestDispatcher("UpdateSuccess.jsp");
					rd.forward(request, response);	
				}
			}
			if(uri.contains("/listUser"))
			{	
				HttpSession s = request.getSession(false);
				System.out.println(s);
				System.out.println("inside if block of /listuser");
				System.out.println(s.getAttribute("email"));
				if(s==null||s.getAttribute("email")==null)
				{
					request.setAttribute("errorMsg", "Your session does not exist. Please login again");
					rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				
				else
				{
					System.out.println("inside if block of /listUser");
					List<RegBean> users = m.listUsers();
					System.out.println(users);
					request.setAttribute("list", users);
					rd = request.getRequestDispatcher("ListUsers.jsp");
					rd.forward(request, response);
				}
			}
			if(uri.contains("/openAddContactView"))
			{
				HttpSession s = request.getSession(false);
				System.out.println("inside /addcontact of CS");
				System.out.println(s.getAttribute("email"));
				if(s==null||s.getAttribute("email")==null)
				{
					request.setAttribute("errorMsg", "Your session does not exist. Please login again");
					rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				
				else
				{
				System.out.println("inside /openAddContactView uri if case");
				rd = request.getRequestDispatcher("/AddContact.jsp");
				rd.forward(request, response);
				}
			}
			if(uri.contains("/addContact"))
			{
				HttpSession s = request.getSession(false);
				System.out.println("inside /addcontact of CS");
				System.out.println(s.getAttribute("email"));
				if(s==null||s.getAttribute("email")==null)
				{
					request.setAttribute("errorMsg", "Your session does not exist. Please login again");
					rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				
				else	
				{	
					String email = (String) session.getAttribute("email");
					System.out.println("inside /addContact uri if case");
					ContactBean cb = (ContactBean) request.getAttribute("contact");
					System.out.println(cb);
					
					
					String result = m.addContact(cb,email);
					if(result.equals(Constants.SUCCESS))
					{	
						System.out.println("inside ifblock of /addcontact");
						request.setAttribute("message", "Contact added successfully");
						rd = request.getRequestDispatcher("/AddContact.jsp");
						rd.forward(request, response);
					}
					else
					{
						request.setAttribute("errorMsg", result);
						rd = request.getRequestDispatcher("/AddContact.jsp");
						rd.forward(request, response);
					}
				}
				
			}/*if(uri.contains("/editContact"))
			{
				HttpSession s = request.getSession(false);
				System.out.println("inside /addcontact of CS");
				System.out.println(s.getAttribute("email"));
				if(s==null||s.getAttribute("email")==null)
				{
					request.setAttribute("errorMsg", "Your session does not exist. Please login again");
					rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				
				else
				{
					System.out.println("inside if block of /listUser");
					String email = (String)session.getAttribute("email");
					List<ContactBean> users = m.listContacts(email);
					System.out.println(users);
					request.setAttribute("list1", users);
					rd = request.getRequestDispatcher("ListContacts.jsp");
					rd.forward(request, response);
				}
			}*/
			if(uri.contains("/openListContact"))
				{	
					HttpSession s = request.getSession(false);
					System.out.println(s);
					System.out.println("inside if block of /listCont");
					System.out.println(s.getAttribute("email"));
					if(s==null||s.getAttribute("email")==null)
					{
						request.setAttribute("errorMsg", "Your session does not exist. Please login again");
						rd = request.getRequestDispatcher("Error.jsp");
						rd.forward(request, response);
					}
					
					else
					{
						System.out.println("inside else block of /listContact");
						String email = (String)session.getAttribute("email");
						List<ContactBean> users = m.listContacts(email);
						System.out.println(users);
						request.setAttribute("list1", users);
						rd = request.getRequestDispatcher("ListContacts.jsp");
						rd.forward(request, response);
					}
				}
				/*if(uri.contains("/editContactView"))
				{	
					HttpSession s = request.getSession(false);
					System.out.println(s);
					System.out.println("inside if block of /editContactView");
					System.out.println(s.getAttribute("email"));
					if(s==null||s.getAttribute("email")==null)
					{
						request.setAttribute("errorMsg", "Your session does not exist. Please login again");
						rd = request.getRequestDispatcher("Error.jsp");
						rd.forward(request, response);
					}
					
					else	
				{	
					System.out.println("inside /editcontact of CS");
					rd = request.getRequestDispatcher("EditContact.jsp");
					rd.forward(request, response);
				}
				
				
				}*/
				if(uri.contains("/editContactView"))
				{
					HttpSession s = request.getSession(false);
					System.out.println(s);
					System.out.println("inside if block of /editContact");
					System.out.println(s.getAttribute("email"));
					if(s==null||s.getAttribute("email")==null)
					{
						request.setAttribute("errorMsg", "Your session does not exist. Please login again");
						rd = request.getRequestDispatcher("Error.jsp");
						rd.forward(request, response);
					}
					else
					{	System.out.println("inside else block of /editContact");
						String sl_no = (String) request.getParameter("Csl_no");
						session.setAttribute("csl_no", sl_no);
						System.out.println(sl_no);
						ContactBean bean = m.getContactDetails(sl_no);
						System.out.println(bean);
						request.setAttribute("contactDetails", bean);
						rd = request.getRequestDispatcher("EditContact.jsp");
						rd.forward(request, response);
					}
				}
				
				if(uri.contains("/updateContacts"))
				{
					System.out.println("inside if block of updateContacts" );
					ContactBean cb=(ContactBean) request.getAttribute("updateC");
					System.out.println(cb);
					String sl_no = (String) session.getAttribute("csl_no");
					System.out.println(sl_no);
					String result=m.updateContact(cb,sl_no);
					if(result.equals(Constants.SUCCESS))
					{
						System.out.println("Update Successfull");
						request.setAttribute("message", "Modification Successfull");
						rd=request.getRequestDispatcher("UpdateSuccess.jsp");
						rd.forward(request, response);
					}else
					{
						System.out.println("Update failed");
						request.setAttribute("errorMsg", result);
						rd=request.getRequestDispatcher("UpdateSuccess.jsp");
						rd.forward(request, response);	
					}
				}
				if(uri.contains("/searchContact"))
				{
					HttpSession s = request.getSession(false);
					System.out.println(s);
					System.out.println("inside if block of /searchContact");
					System.out.println(s.getAttribute("email"));
					if(s==null||s.getAttribute("email")==null)
					{
						request.setAttribute("errorMsg", "Your session does not exist. Please login again");
						rd = request.getRequestDispatcher("Error.jsp");
						rd.forward(request, response);
					}
					
					else	
				{	
					System.out.println("inside /searchContact of CS");
					rd = request.getRequestDispatcher("SearchContact.jsp");
					rd.forward(request, response);
				}
					
				}
				if(uri.contains("/Search"))
				{
					HttpSession s = request.getSession(false);
					System.out.println(s);
					System.out.println("inside if block of /search");
					System.out.println(s.getAttribute("email"));
					if(s==null||s.getAttribute("email")==null)
					{
						request.setAttribute("errorMsg", "Your session does not exist. Please login again");
						rd = request.getRequestDispatcher("Error.jsp");
						rd.forward(request, response);
					}
					
					else	
				{	
					System.out.println("inside /Search of CS");
					String value=request.getParameter("search");
					String searchstr=request.getParameter("searchStr");
					String email =(String)session.getAttribute("email");
					System.out.println(value);
					System.out.println(searchstr);
					List<ContactBean> users = m.searchContacts(value,searchstr,email);
					System.out.println(users);
					request.setAttribute("Slist", users);
					System.out.println("forwarding");
					rd = request.getRequestDispatcher("SearchContact.jsp");
					rd.forward(request, response);
					System.out.println("forwarded");
					
					
				}
					
				}
				
				if(uri.contains("/deleteContact"))
				{
					HttpSession s = request.getSession(false);
					System.out.println("inside /deleteContact of CS");
					System.out.println(s.getAttribute("email"));
					if(s==null||s.getAttribute("email")==null)
					{
						request.setAttribute("errorMsg", "Your session does not exist. Please login again");
						rd = request.getRequestDispatcher("Error.jsp");
						rd.forward(request, response);
					}
					
					else	
					{	
						System.out.println("inside delContact uri if case");
						String sl_no = (String) request.getParameter("Csl_no");
						System.out.println(sl_no);
						
						ContactBean cb = (ContactBean) request.getAttribute("delcontact");
						String result = m.delContact(cb,sl_no);
						System.out.println(result);
						if(result.equals(Constants.SUCCESS))
						{	
							System.out.println("inside ifblock of /delcontact");
							request.setAttribute("message", "Contact Deleted successfully");
							rd = request.getRequestDispatcher("/UpdateSuccess.jsp");
							rd.forward(request, response);
						}
						else
						{
							request.setAttribute("errorMsg", result);
							rd = request.getRequestDispatcher("/AddContact.jsp");
							rd.forward(request, response);
						}
					}
				}if(uri.contains("/bdayRmndr"))
				{
					HttpSession s = request.getSession(false);
					System.out.println(s);
					System.out.println("inside if block of /bdayrmndr");
					System.out.println(s.getAttribute("email"));
					if(s==null||s.getAttribute("email")==null)
					{
						request.setAttribute("errorMsg", "Your session does not exist. Please login again");
						rd = request.getRequestDispatcher("Error.jsp");
						rd.forward(request, response);
					}
					
					else	
				{	
					System.out.println("inside else block /bdayrmndr of CS");
					String email = (String)session.getAttribute("email");
					List<ContactBean> birthdayList = m.bdayRmndr(email);
					System.out.println(birthdayList);
					request.setAttribute("blist", birthdayList);
					System.out.println("forwarding");
					rd = request.getRequestDispatcher("listOfBirthdays.jsp");
					rd.forward(request, response);
					System.out.println("forwarded");
					
					
				}
					
				}
				
	}
}


