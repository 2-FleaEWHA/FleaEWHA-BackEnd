package kr.or.epro.fleaewha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.epro.fleaewha.mapper.PostMapper;
import kr.or.epro.fleaewha.dto.Product;
import java.util.List;

@Service
public class PostService {
	
	@Autowired
	private PostMapper postMapper;
	
	public List<Product> getPosts() throws Exception{
		return postMapper.getPosts();
	}
	
	public Product getPost(int productID) throws Exception {
		return postMapper.getPost(productID);
	}
	
	public void addPost(Product p) throws Exception {
		postMapper.addPost(p);
	}
	
	public void deletePost(int productID) throws Exception {
		postMapper.deletePost(productID);
	}
	
	public void updatePost(Product p) throws Exception {
		postMapper.updatePost(p);
	}
	
	
}
