package kr.or.epro.fleaewha.dao;

import java.util.List;
import kr.or.epro.fleaewha.dto.File2;

public interface FileMapper {
	public File2 getFile(int productID) throws Exception;
	public void addFile(File2 f) throws Exception;
	public void deleteFile(int productID) throws Exception;
	public List<File2> getFiles(int productID) throws Exception;
	public void updateFile(File2 f) throws Exception;
}
