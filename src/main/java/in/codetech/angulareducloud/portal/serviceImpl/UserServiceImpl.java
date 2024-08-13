package in.codetech.angulareducloud.portal.serviceImpl;


import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.exception.IdNotFoundException;
import in.codetech.angulareducloud.portal.exception.UsernotFoundException;
import in.codetech.angulareducloud.portal.module.User;
import in.codetech.angulareducloud.portal.module.UserRole;
import in.codetech.angulareducloud.portal.module.repo.RoleRepository;
import in.codetech.angulareducloud.portal.module.repo.UserRepository;
import in.codetech.angulareducloud.portal.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	
	@Override
	public User AddUser(User user, Set<UserRole> roles) throws Exception 
	{
		    User local = this.userRepository.findByUsername(user.getUsername());
		    if (local != null) {
		        System.out.println("User is already there !!");
		       
		    } else { 
		    	
		            for (UserRole ur : roles) 
		            {
		                roleRepository.save(ur.getRole());
		            }
		            
		            user.getUserRoles().addAll(roles);
		        
		            local = this.userRepository.save(user);
		    }
		    return local;
		}
	

	 @Override
	public User Deleteuser(long id)
	 {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent())
		{
			User user = optional.get();
			userRepository.deleteById(id);
			return user;
		}
		else
		{
			throw new IdNotFoundException(" User with id : "+ id+ " Not found ");
		}
		
	}

	@Override
	public User getUser(String username) throws UsernotFoundException
	{
		User user = userRepository.findByUsername(username);
		if(user==null)
		{
			throw new UsernotFoundException(" User with username : "+username+" not Found" );
			
		}
		return user;
	}


	



	
	

}