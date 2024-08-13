package in.codetech.angulareducloud.portal.service;

import java.util.Set;

import in.codetech.angulareducloud.portal.module.cloud.Quiz;

public interface QuizService 
{
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz , long qId);
	public Set<Quiz> getQuizzes();
	public Quiz getQuiz(Long quizId);
	public void deleteQuiz(Long quizId);

}
