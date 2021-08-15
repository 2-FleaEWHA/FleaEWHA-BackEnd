package kr.or.epro.fleaewha.controller;

import kr.or.epro.fleaewha.dao.TestDAO;
import kr.or.epro.fleaewha.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/db")
public class DBConnectController {

    @Autowired
    private TestDAO testDAO;

    @GetMapping("/getdata")
    public List<TestDTO> HelloWorld() {
        return testDAO.getTestData();
    }
}