package in.codetech.angulareducloud.portal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.exception.IdNotFoundException;
import in.codetech.angulareducloud.portal.module.cloud.Question;
import in.codetech.angulareducloud.portal.module.cloud.Quiz;
import in.codetech.angulareducloud.portal.module.repo.QuestionRepository;
import in.codetech.angulareducloud.portal.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Override
	public Question addQuestion(Question question) 
	{
		
		return questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question, long quesId) 
	{
		Optional<Question> optional = questionRepository.findById(quesId);
		if(optional.isPresent())
		{
			question.setQuesId(quesId);
			return questionRepository.save(question);
		}
		else
		{
			throw new IdNotFoundException(" Question with id : "+quesId+" not found ");
		}
		
	}

	@Override
	public Set<Question> getQuestions() 
	{
		return new LinkedHashSet<Question>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) 
	{
		return questionRepository.findById(questionId)
				.orElseThrow(() -> new IdNotFoundException("Question with id: " + questionId + " not found"));
	}
	
	
	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) 
	{
		 return questionRepository.findByQuiz(quiz);
		
	}

	@Override
	public void deleteQuestion(Long quesId) 
	{
		questionRepository.findById(quesId)
			.orElseThrow(() -> new IdNotFoundException("Question with id: " + quesId + " not found"));
		
		questionRepository.deleteById(quesId);
	}

}
