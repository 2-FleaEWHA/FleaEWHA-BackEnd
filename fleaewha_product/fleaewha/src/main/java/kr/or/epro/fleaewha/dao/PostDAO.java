package kr.or.epro.fleaewha.dao;

import kr.or.epro.fleaewha.dto.*;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostDAO {
	public List<ProductDTO> getPosts() throws Exception;
	public ProductDTO getPost(int productID) throws Exception;
	public int addPost(ProductDTO p) throws Exception;
	public int deletePost(int productID) throws Exception;
	public int updatePost(ProductDTO p) throws Exception;
}
