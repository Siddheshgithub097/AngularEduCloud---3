package in.codetech.angulareducloud.portal.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.exception.IdNotFoundException;
import in.codetech.angulareducloud.portal.module.cloud.Quiz;
import in.codetech.angulareducloud.portal.module.repo.QuizRepository;
import in.codetech.angulareducloud.portal.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService 
{
	@Autowired
	private QuizRepository quizRepository ; 
	
	@Override
	public Quiz addQuiz(Quiz quiz) 
	{
		
		return quizRepository.save(quiz) ;
	}

	
	@Override
	public Quiz updateQuiz(Quiz quiz , long qId) 
	{
		return quizRepository.findById(qId)
				.map(existingquiz -> {
					quiz.setqId(qId);
				return quizRepository.save(quiz);
						})
				.orElseThrow(() -> new IdNotFoundException(" Question with id : "+ qId+" not found "));
	}

	@Override
	public Set<Quiz> getQuizzes() {
		
		return new HashSet<Quiz>(quizRepository.findAll());		// i want unique quiz  
	}

	@Override
	public Quiz getQuiz(Long quizId) 
	{
		return quizRepository.findById(quizId)
				.orElseThrow(() -> new IdNotFoundException(" Question with id : "+ quizId+" not found "));
		
		
	}

	@Override
	public void deleteQuiz(Long quizId) 
	{
		// return type is void -
		quizRepository.findById(quizId)
				.orElseThrow(() -> new IdNotFoundException(" Question with id : "+ quizId+" not found "));
		
		 quizRepository.deleteById(quizId);
		
	}

}
