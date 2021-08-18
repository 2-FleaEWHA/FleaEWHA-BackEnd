package kr.or.epro.fleaewha.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.epro.fleaewha.dto.File;

@Mapper
public interface FileMapper {
	public File getFile(int productID) throws Exception;
	public int addFile(File f) throws Exception;
	public int deleteFile(int fileID) throws Exception;
}
