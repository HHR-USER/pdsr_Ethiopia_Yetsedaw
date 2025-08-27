package org.pdsr.controller;


import java.util.ArrayList;
import java.util.List;

import org.pdsr.master.model.case_identifiers;
import org.pdsr.master.repo.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/case")
public class CaseApiController {
    @Autowired
    private CaseRepository caseRepo;
    
    @GetMapping("/findall")
    public List<case_identifiers> findall()
    {
    	
		return caseRepo.findAll();
    	
    }
    
    @PostMapping("/save")
    public case_identifiers save(@RequestBody case_identifiers cse)
    {
    	
		return caseRepo.save(cse);
    	
    }
    
   
}
