package kr.or.epro.fleaewha.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.epro.fleaewha.dto.File;
import kr.or.epro.fleaewha.dto.Product;

public interface ProductDAO {
	List<Product> getProductAll();
	List<Product> getProductAllOption(HashMap<String, String> parameter);
	
	List<Product> getProductByCategoryOption(HashMap<String, String> parameter);
	List<Product> getProductByCategory(HashMap<String, String> parameter);

	List<Product> searchProduct(HashMap<String, String> parameter);
	List<Product> searchProductOption(HashMap<String, String> parameter);
	
	List<File> getFileMain(int productID);
	
}
