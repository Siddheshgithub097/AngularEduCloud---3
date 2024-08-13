package in.codetech.angulareducloud.portal.module;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	private String username;
	private  String password;
	private String firstname;
	private String lastname;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String phone;
	private boolean enabled = true;
	private String profile ;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
	@JsonBackReference	 		
	private Set<UserRole> userRoles = new HashSet<>();

				// @JsonBackReference ---? to manage the serialization of bidirectional relationships.
					//Only one of them is needed to prevent infinite recursion.
				/*  bidirectional relationship, it can cause an infinite loop when 
					serializing to JSON because each side of the relationship refers to the other.
				 To resolve this, you can use the @JsonIgnore annotation from the Json 
				 library to prevent one side of the relationship from being serialized. Alternatively, 
				 you can use the @JsonManagedReference and @JsonBackReference annotations to manage the serialization.
				 */
	
	public User() 
	{
	
	}

	

	public User(long id, String username, String password, String firstname, String lastname, String email,
			String phone, boolean enabled, String profile, Set<UserRole> userRoles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
		this.profile = profile;
		this.userRoles = userRoles;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public Set<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", phone=" + phone + ", enabled=" + enabled
				+ ", profile=" + profile + ", userRoles=" + userRoles + "]";
	}
	
	
	
	
	
	
}
