package in.codetech.angulareducloud.portal.module.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codetech.angulareducloud.portal.module.cloud.Question;
import in.codetech.angulareducloud.portal.module.cloud.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
