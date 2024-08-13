package in.codetech.angulareducloud.portal.module;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserRole 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonManagedReference
	private User user;
	
	@ManyToOne
	private Role role;

	public UserRole() 
	{	

	}

	public UserRole(Long userRoleId, User user, Role role) 
	{
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
	}

	
	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", user=" + user + ", role=" + role + "]";
	}
	
	
	

	
	
	

}
