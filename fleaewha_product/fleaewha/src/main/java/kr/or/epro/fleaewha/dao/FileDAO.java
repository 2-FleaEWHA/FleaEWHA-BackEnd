package kr.or.epro.fleaewha.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.epro.fleaewha.dto.FileDTO;

@Mapper
public interface FileDAO {
	public FileDTO getFile(int productID) throws Exception;
	public int addFile(FileDTO f) throws Exception;
	public int deleteFile(int fileID) throws Exception;
}
