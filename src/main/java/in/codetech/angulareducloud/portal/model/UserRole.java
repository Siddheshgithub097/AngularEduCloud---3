package in.codetech.angulareducloud.portal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserRole 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userRoleId;

	
	public UserRole()
	{
		
	}
	
	public UserRole(Long userRoleId) 
	{
		
		this.userRoleId = userRoleId;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + "]";
	}

	

}
