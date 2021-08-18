package kr.or.epro.fleaewha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.or.epro.fleaewha.dto.FileDTO;
import kr.or.epro.fleaewha.s3.AWSS3Service;
import kr.or.epro.fleaewha.service.FileService;
 
@RestController
@RequestMapping(value="/s3")
public class AWSS3Controller {
 
    @Autowired
    private AWSS3Service service;
    
    @Autowired
    private FileService fileService;
 
    @PostMapping(value= "/upload")
    public ResponseEntity<String> uploadFile(@RequestPart(value= "file") final MultipartFile multipartFile) throws Exception {
        String name = service.uploadFile(multipartFile);
        final String response = "[" + multipartFile.getOriginalFilename() + "] uploaded successfully.";
        final String url = "https://fleaewhabucket.s3.ap-northeast-2.amazonaws.com/"+ name;
        fileService.addFile(new FileDTO(4, 1, url, 0));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping("/getTest/{productID}")
    public String testFile(
    		@PathVariable int productID
    		) throws Exception {
    	return fileService.getFile(productID).getFileURL();
    }
    
}