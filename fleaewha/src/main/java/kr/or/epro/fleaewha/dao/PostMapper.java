package kr.or.epro.fleaewha.dao;

import kr.or.epro.fleaewha.dto.*;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
	public List<Product> getPosts() throws Exception;
	public Product getPost(int productID) throws Exception;
	public int addPost(Product p) throws Exception;
	public int deletePost(int productID) throws Exception;
	public int updatePost(Product p) throws Exception;
}
