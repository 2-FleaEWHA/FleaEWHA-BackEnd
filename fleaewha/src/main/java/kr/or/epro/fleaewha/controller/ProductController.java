package kr.or.epro.fleaewha.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import kr.or.epro.fleaewha.dto.File2;
import kr.or.epro.fleaewha.dto.Product2;
import kr.or.epro.fleaewha.s3.AWSS3Service;
import kr.or.epro.fleaewha.service.FileService;
import kr.or.epro.fleaewha.service.PostService;

@RestController
public class ProductController {
	
	@Autowired
	private AWSS3Service service;
	    
	@Autowired
	private FileService fileService;
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/products/{productID}")
	public Product2 getPost(
			@PathVariable int productID
	 ) throws Exception {	
		Product2 p = postService.getPost(productID);
		List<String> files = fileService.getFiles(productID);
		p.setFiles(files);
		return p;
	 }
	
	@PostMapping("/new-product")
	public String addPost(
			@RequestPart(value= "file") final List<MultipartFile> multipartFiles,
			@RequestPart(value= "product") Product2 p,
			HttpSession session
	) throws Exception {
		if(session.getAttribute("id") == null)
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
		else {
			postService.addPost(p);
			
			String url;
			for(MultipartFile file : multipartFiles) {
				File2 file2 = new File2();
				if(file == multipartFiles.get(0))
					file2.setType(1);
				url = "https://fleaewhabucket.s3.ap-northeast-2.amazonaws.com/" + service.uploadFile(file);
				file2.setProductID(p.getProductID());
				file2.setFileURL(url);
				fileService.addFile(file2);
			}
		
			return "post added";
		}
				
	}


    @PutMapping("/products/{productID}")
    public String updatePost(
    		@RequestPart(value= "file") final List<MultipartFile> multipartFiles,
            @RequestPart(value= "product") Product2 p,
            @PathVariable int productID,
            HttpSession session
    ) throws Exception {
    	
    	if(session.getAttribute("id")==null)
    		throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
    	else {
    	  	p.setProductID(productID);
        	
        	postService.updatePost(p);
        
    		String url;
    		for(MultipartFile file : multipartFiles) {
    			File2 file2 = new File2();
    			if(file == multipartFiles.get(0))
    				file2.setType(1);
    			else
    				file2.setType(0);
    			url = "https://fleaewhabucket.s3.ap-northeast-2.amazonaws.com/" + service.uploadFile(file);
    			file2.setProductID(p.getProductID());
    			file2.setFileURL(url);
    			fileService.updateFile(file2);
    		}
        	
            return "post updated";
    	}
    	
    }

    @DeleteMapping("/products/{productID}")
    public String deletePost(
            @PathVariable int productID,
            HttpSession session
    ) throws Exception {
    	if(session.getAttribute("id") == null)
    		throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
    	else {
    		fileService.deleteFile(productID);
        	postService.deletePost(productID);
        	return "post deleted";
    	}
 
    }
	
}
