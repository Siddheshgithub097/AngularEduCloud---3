package in.codetech.angulareducloud.portal.module.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codetech.angulareducloud.portal.module.cloud.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> 
{

}
