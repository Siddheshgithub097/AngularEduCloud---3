package in.codetech.angulareducloud.portal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.codetech.angulareducloud.portal.module.cloud.Category;
import in.codetech.angulareducloud.portal.service.CategoryService;
import in.codetech.angulareducloud.portal.util.ResponseStructure;

@RestController
@RequestMapping("/category")
public class CategoryController
{
	
	@Autowired(required = true)
	private CategoryService categoryService;
	
	/*@PostMapping("/add")
	public Category addcategory(@RequestBody Category category)
	{
		Category addCategory = categoryService.addCategory(category);
		return addCategory;
		
	}
	*/
	
	@PostMapping("/add")
	public ResponseEntity<ResponseStructure<Category>> addcategory(@RequestBody Category category)
	{
		ResponseEntity<ResponseStructure<Category>> addcategory = this.categoryService.addCategory(category);
		return addcategory;
	}
	
	@PutMapping("/update/{cid}")
	public Category updateCategory(@RequestBody Category category , @PathVariable long cid)
	{
		return this.categoryService.updateCategory(category, cid);
	}
	
	
	
	@GetMapping("/getAll")
	public Set<Category> getCategories()
	{
	
		Set<Category> categories = this.categoryService.getCategories();
		return categories;
	}
	
	
	@GetMapping("get")
	public Category getCategory(@RequestParam  Long categoryId)
	{
		Category getCategory = categoryService.getCategory(categoryId);
		return getCategory;
	}
	
	
	@DeleteMapping("/delete")
	public void deleteCategory(@RequestParam Long categoryId)
	{
		this.categoryService.deleteCategory(categoryId);
		
	}
	
	
}
