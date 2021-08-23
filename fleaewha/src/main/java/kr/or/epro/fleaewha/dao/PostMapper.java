package kr.or.epro.fleaewha.dao;

import kr.or.epro.fleaewha.dto.*;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

public interface PostMapper {
	public Product2 getPost(int productID) throws Exception;
	public void addPost(Product2 p) throws Exception;
	public void deletePost(int productID) throws Exception;
	public void updatePost(Product2 p) throws Exception;
}
