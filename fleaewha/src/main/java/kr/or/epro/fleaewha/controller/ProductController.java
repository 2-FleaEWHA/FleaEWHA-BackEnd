package kr.or.epro.fleaewha.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.epro.fleaewha.dto.Product;
import kr.or.epro.fleaewha.service.PostService;

@RestController
@RequestMapping(value="/fleaewha")
public class ProductController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/products")
	public List<Product> getPosts() throws Exception {
		return postService.getPosts();
	}
	
	@GetMapping("/products/{productID}")
	public Product getPost(
			@PathVariable int productID
	 ) throws Exception {	    
		return postService.getPost(productID);
	 }
	
	@PostMapping("/new-product")
	public String addPost(
			@RequestBody Product p
			) throws Exception {
		postService.addPost(p);
		return "post added";
	}

    @PutMapping("/products/{productID}")
    public String updatePost(
            @RequestBody Product p
    ) throws Exception {
    	postService.updatePost(p);
        return "post updated";
    }

    @DeleteMapping("/products/{productID}")
    public String deletePost(
            @PathVariable int productID
    ) throws Exception {
    	postService.deletePost(productID);
    	return "post deleted";
    }
	
}
