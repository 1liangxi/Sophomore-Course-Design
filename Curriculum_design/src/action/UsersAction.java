package action;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.Session;

import service.UsersDAO;
import service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

public class UsersAction extends SuperAction implements ModelDriven<Users>{
	
	private Users user = new Users();

	public String login()
	{
		UsersDAO udao = new UsersDAOImpl();
		if(udao.usersLogin(user))
		{
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}
		else
		{
			return "login_failure";
		}
		
	}
	
	
	
	@Override
	public void validate() {
		
		UsersDAO udao = new UsersDAOImpl();
		if(!udao.usersLogin(user))
		{
			this.addFieldError("passError", "用户名或密码错误");
		}
	}



	@SkipValidation
	public String logout() throws ServletException, IOException
	{
		if(session.getAttribute("loginUserName")!=null)
		{
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	
	

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	

}
