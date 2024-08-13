package in.codetech.angulareducloud.portal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.exception.IdNotFoundException;
import in.codetech.angulareducloud.portal.module.cloud.Category;
import in.codetech.angulareducloud.portal.module.repo.CategoryRepository;
import in.codetech.angulareducloud.portal.service.CategoryService;
import in.codetech.angulareducloud.portal.util.ResponseStructure;

@Service
public class CategoryServiceImpl implements CategoryService
{

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	@Override
	public ResponseEntity<ResponseStructure<Category>> addCategory(Category category) 
	{
		
		 Category savedCategory = this.categoryRepository.save(category);
		 
		 ResponseStructure<Category> structure = new ResponseStructure<Category>();
		 structure.setMessage("Category saved successfully");
		 structure.setStatus(HttpStatus.CREATED.value());
		 structure.setData(savedCategory);
		 
		 return new ResponseEntity<ResponseStructure<Category>>(structure,HttpStatus.CREATED);
				 
	}
	
	

	@Override
	public Category updateCategory(Category category, long cid) 
	{
		Optional<Category> optional = categoryRepository.findById(cid);
		if(optional.isPresent())
		{
			category.setCid(cid);
			return categoryRepository.save(category);
			
		}
		else 
		{
			
			throw new IdNotFoundException("Category with id " + cid + " not found");
		}
	}

	
	
	@Override
	public Set<Category> getCategories() 
	{
		
		return new LinkedHashSet<Category>(this.categoryRepository.findAll());
	}
	

	@Override
	public Category getCategory(Long categoryId)
	{
		
		// return this.categoryRepository.findById(categoryId).get();
		
		Optional<Category> optional = categoryRepository.findById(categoryId);
		if(optional.isPresent())
		{
			return optional.get();
			
		}
		else
		{
			throw new IdNotFoundException("Category with id " + categoryId + " not found"); 	
		}
	}
	

	@Override
	public void deleteCategory(Long categoryId)
	{
		if(categoryRepository.existsById(categoryId))
		{
			this.categoryRepository.deleteById(categoryId);
		}
		else
		{
			throw new IdNotFoundException("Category with id " + categoryId + " not found");
		}	
		
	}

	



}
