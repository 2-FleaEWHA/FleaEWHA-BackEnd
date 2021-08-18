package kr.or.epro.fleaewha.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.epro.fleaewha.dto.File2;

@Mapper
public interface FileMapper {
	public File2 getFile(int productID) throws Exception;
	public int addFile(File2 f) throws Exception;
	public int deleteFile(int fileID) throws Exception;
}
