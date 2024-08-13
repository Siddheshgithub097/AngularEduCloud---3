package in.codetech.angulareducloud.portal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.codetech.angulareducloud.portal.module.Role;
import in.codetech.angulareducloud.portal.module.User;
import in.codetech.angulareducloud.portal.module.UserRole;
import in.codetech.angulareducloud.portal.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController 
{
	
	
	@Autowired(required = true)
	private UserService userService;
	
	@PostMapping("/adduser")
	public User AddUser(@RequestBody User user) throws Exception
	{
		
		user.setProfile("default.png");
		user.setPassword(user.getPassword());
		
		Set<UserRole> roles = new HashSet<UserRole>();
		
		Role role = new Role();
		role.setRoleId(13);
		role.setRoleName("NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		return this.userService.AddUser(user, roles);
	}
	
	
	
	@GetMapping("/findByUsername")
	public User getUser(@RequestParam String username)
	{
		
		return userService.getUser(username);
		
	}
	
	@DeleteMapping("/deleteuser")
	public User DeleteUser(@RequestParam long id)
	{
		return userService.Deleteuser(id);
	}
}
