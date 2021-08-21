package kr.or.epro.fleaewha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.epro.fleaewha.dao.PostMapper;
import kr.or.epro.fleaewha.dto.File2;
import kr.or.epro.fleaewha.dto.Product2;
import java.util.List;

@Service
public class PostService {
	
	@Autowired
	private PostMapper postMapper;
	
	public List<Product2> getPosts() throws Exception{
		return postMapper.getPosts();
	}
	
	public Product2 getPost(int productID) throws Exception {
		return postMapper.getPost(productID);
	}
	
	public void addPost(Product2 p) throws Exception {
		postMapper.addPost(p);
	}
	
	public void deletePost(int productID) throws Exception {
		postMapper.deletePost(productID);
	}
	
	public void updatePost(Product2 p) throws Exception {
		postMapper.updatePost(p);
	}
	
	public List<File2> getFiles(int productID) throws Exception {
		return postMapper.getFiles(productID);
	}
	
}
