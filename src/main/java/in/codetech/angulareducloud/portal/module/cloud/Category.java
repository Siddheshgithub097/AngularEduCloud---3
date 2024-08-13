package in.codetech.angulareducloud.portal.module.cloud;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	
	private String title;
	
	private String description;
	
	
	 @OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL)
	 @JsonIgnore
	 private Set<Quiz> quizs = new LinkedHashSet<>(); 
	 
	public Category()
	{
		super();
		
	}


	public Category(long cid, String title, String description, Set<Quiz> quizs) {
		super();
		this.cid = cid;
		this.title = title;
		this.description = description;
		this.quizs = quizs;
	}


	public long getCid() {
		return cid;
	}


	public void setCid(long cid) {
		this.cid = cid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Quiz> getQuizs() {
		return quizs;
	}


	public void setQuizs(Set<Quiz> quizs) {
		this.quizs = quizs;
	}


	@Override
	public String toString() {
		return "Category [cid=" + cid + ", title=" + title + ", description=" + description + ", quizs=" + quizs + "]";
	}
	 
	
	 
	 
	
}
