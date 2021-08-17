package kr.or.epro.fleaewha.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.epro.fleaewha.dao.ProductDAO;
import kr.or.epro.fleaewha.dto.Product;

@RestController
public class BoardController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@GetMapping("/product/{category}")
	public List<Product> Category(@PathVariable(name="category") String category, 
			@RequestParam(value="option", required=false, defaultValue="전체") String option){
		
		List<Product> product;
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("category", category);
		parameter.put("option", option);
		if (category.equals("전체")) {
			if (option.equals("전체")) {
				product = productDAO.getProductAll();
			}
			else {
				product = productDAO.getProductAllOption(parameter);
			}
		}
		else {	
			if (option.equals("전체")) {
				product = productDAO.getProductByCategory(parameter);			
			}
			else {
				product = productDAO.getProductByCategoryOption(parameter);			
			}
		}
		
		for (Product p : product) {
			p.setFiles(productDAO.getFileMain(p.getProductID()));
		}
		
		return product;
	}
	
	@GetMapping("/product/search")
	public List<Product> Search(@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="option", required=false, defaultValue="전체") String option){
		
		List<Product> product;
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("keyword", '%'+keyword+'%');
		parameter.put("option", option);
		if (option.equals("전체")) {
			product = productDAO.searchProduct(parameter);
		}
		else {
			product = productDAO.searchProductOption(parameter);
		}
		
		for (Product p : product) {
			p.setFiles(productDAO.getFileMain(p.getProductID()));
		}
		
		return product;
	}

}
