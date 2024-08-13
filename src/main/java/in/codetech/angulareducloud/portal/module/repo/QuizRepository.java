package in.codetech.angulareducloud.portal.module.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codetech.angulareducloud.portal.module.cloud.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>
{
	
}
