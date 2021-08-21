package kr.or.epro.fleaewha.dao;

import kr.or.epro.fleaewha.dto.*;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

public interface PostMapper {
	public List<Product2> getPosts() throws Exception;
	public Product2 getPost(int productID) throws Exception;
	public int addPost(Product2 p) throws Exception;
	public int deletePost(int productID) throws Exception;
	public int updatePost(Product2 p) throws Exception;
	public List<File2> getFiles(int productID) throws Exception;
}
