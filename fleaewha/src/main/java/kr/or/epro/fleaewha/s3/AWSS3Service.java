package kr.or.epro.fleaewha.s3;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {

	void uploadFile(MultipartFile multipartFile);
}
