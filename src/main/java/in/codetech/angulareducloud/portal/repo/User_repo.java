package in.codetech.angulareducloud.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codetech.angulareducloud.portal.model.User;

public interface User_repo extends JpaRepository<User, Integer> 
{

}
