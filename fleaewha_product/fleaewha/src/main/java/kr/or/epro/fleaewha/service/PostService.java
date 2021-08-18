package kr.or.epro.fleaewha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.epro.fleaewha.dao.PostDAO;
import kr.or.epro.fleaewha.dto.ProductDTO;
import java.util.List;

@Service
public class PostService {
	
	@Autowired
	private PostDAO postDAO;
	
	public List<ProductDTO> getPosts() throws Exception{
		return postDAO.getPosts();
	}
	
	public ProductDTO getPost(int productID) throws Exception {
		return postDAO.getPost(productID);
	}
	
	public void addPost(ProductDTO p) throws Exception {
		postDAO.addPost(p);
	}
	
	public void deletePost(int productID) throws Exception {
		postDAO.deletePost(productID);
	}
	
	public void updatePost(ProductDTO p) throws Exception {
		postDAO.updatePost(p);
	}
	
	
}
