package kr.or.epro.fleaewha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.epro.fleaewha.dao.FileMapper;
import kr.or.epro.fleaewha.dto.File2;

@Service
public class FileService {
	
	@Autowired
	private FileMapper fileMapper;
	
	public void addFile(File2 file) throws Exception {
		fileMapper.addFile(file);
	}
	
	public File2 getFile(int productID) throws Exception {
		return fileMapper.getFile(productID);
	}
	
	public void deleteFile(int productID) throws Exception {
		fileMapper.deleteFile(productID);
	}
	
	public List<File2> getFiles(int productID) throws Exception {
		return fileMapper.getFiles(productID);
	}
	
	public void updateFile(File2 f) throws Exception{
		fileMapper.updateFile(f);
	}
	
}
