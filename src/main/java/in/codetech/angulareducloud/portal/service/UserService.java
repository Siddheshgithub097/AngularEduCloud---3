package in.codetech.angulareducloud.portal.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.module.User;
import in.codetech.angulareducloud.portal.module.UserRole;


public interface UserService 
{
	
//	public User getUser(String username);

	public User AddUser(User user, Set<UserRole> roles) throws Exception;

	public User getUser(String username);

	public User Deleteuser(long id);

	

}
