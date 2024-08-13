package in.codetech.angulareducloud.portal.service;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import in.codetech.angulareducloud.portal.module.cloud.Category;
import in.codetech.angulareducloud.portal.util.ResponseStructure;

public interface CategoryService 
{
	public ResponseEntity<ResponseStructure<Category>> addCategory(Category category);
	
	public Category updateCategory(Category category , long cid);
	
	public Set<Category> getCategories();
	
	public Category getCategory(Long categoryId);
	
	public void deleteCategory(Long categoryId);
}
