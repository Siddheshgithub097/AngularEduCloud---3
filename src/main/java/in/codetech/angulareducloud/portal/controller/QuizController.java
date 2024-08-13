package in.codetech.angulareducloud.portal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.codetech.angulareducloud.portal.module.cloud.Quiz;
import in.codetech.angulareducloud.portal.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController 
{
	@Autowired(required = true)
	private QuizService quizService;
	
	@PostMapping("/add")
	public Quiz addQuiz(@RequestBody Quiz quiz)
	{
		Quiz addQuiz = this.quizService.addQuiz(quiz);
		
		return addQuiz;
	}
	
	
	@PutMapping("/update/{qId}")
	public Quiz updateQuiz(@RequestBody Quiz quiz , @PathVariable long qId)
	{
		return this.quizService.updateQuiz(quiz, qId);
	}
	
	
	@GetMapping("/getAll")
	public Set<Quiz> getQuizzes()
	{
		Set<Quiz> getQuizs = this.quizService.getQuizzes();
		return getQuizs;
	}
	
	@GetMapping("/get")
	public Quiz getQuiz(@RequestParam Long quizId)
	{
		Quiz getQuiz = this.quizService.getQuiz(quizId);
		return getQuiz;
	}
	
	@DeleteMapping("/delete")
	public void deleteQuiz(@RequestParam Long quizId)
	{
		this.quizService.deleteQuiz(quizId);
	}
	
}
