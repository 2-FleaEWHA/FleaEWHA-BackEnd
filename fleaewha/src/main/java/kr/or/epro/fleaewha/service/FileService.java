package kr.or.epro.fleaewha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.epro.fleaewha.dto.File;
import kr.or.epro.fleaewha.mapper.FileMapper;

@Service
public class FileService {
	
	@Autowired
	private FileMapper fileMapper;
	
	public void addFile(File file) throws Exception {
		fileMapper.addFile(file);
	}
	
	public File getFile(int productID) throws Exception {
		return fileMapper.getFile(productID);
	}
	
	public void deleteFile(int fileID) throws Exception {
		fileMapper.deleteFile(fileID);
	}
	
}
