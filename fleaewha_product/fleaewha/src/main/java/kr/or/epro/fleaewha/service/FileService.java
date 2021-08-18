package kr.or.epro.fleaewha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.epro.fleaewha.dto.FileDTO;
import kr.or.epro.fleaewha.dao.FileDAO;

@Service
public class FileService {
	
	@Autowired
	private FileDAO fileDAO;
	
	public void addFile(FileDTO file) throws Exception {
		fileDAO.addFile(file);
	}
	
	public FileDTO getFile(int productID) throws Exception {
		return fileDAO.getFile(productID);
	}
	
	public void deleteFile(int fileID) throws Exception {
		fileDAO.deleteFile(fileID);
	}
	
}
