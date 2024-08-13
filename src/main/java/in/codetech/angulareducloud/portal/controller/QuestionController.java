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

import in.codetech.angulareducloud.portal.module.cloud.Question;
import in.codetech.angulareducloud.portal.module.cloud.Quiz;
import in.codetech.angulareducloud.portal.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController 
{

	@Autowired(required = true)
	private QuestionService questionService;
	
	@PostMapping("/add")
	public Question addQuestion(@RequestBody Question question)
	{
		Question addQuestion = questionService.addQuestion(question);
		return addQuestion;
	}

	@PutMapping("/update/{quesId}")
	public Question updateQuestion(@RequestBody Question question,@PathVariable long quesId)
	{
		return this.questionService.updateQuestion(question, quesId);
	}
	

	@GetMapping("/getAll")
	public Set<Question> getQuestions()
	{
		Set<Question> setQuestion = this.questionService.getQuestions();
		return setQuestion;
	}

	@GetMapping("/get")
	public Question getQuestion(@RequestParam Long questionId)
	{
		Question getquestion = this.questionService.getQuestion(questionId);
		return getquestion;
				
	}
	
	@GetMapping("/quiz")
	public Set<Question> getQuestionsOfQuiz(@RequestBody Quiz quiz)
	{
		Set<Question> getquestions = this.questionService.getQuestions();
		return getquestions;
	}

	@DeleteMapping("/delete")
	public void deleteQuestion(@RequestParam Long quesId)
	{
		this.questionService.deleteQuestion(quesId);
	}
	
}
