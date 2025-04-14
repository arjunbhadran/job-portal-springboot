package com.example.firstjobapp.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("api/public/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("api/public/companies/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId){
        return ResponseEntity.ok(companyService.getCompanyById(companyId));
    }

    @PostMapping("api/admin/companies")
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return ResponseEntity.ok("Company created");
    }

    @DeleteMapping("api/admin/companies/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId){
        try{
            String status = companyService.deleteCompanyById(companyId);
            return ResponseEntity.ok(status);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

    }

    @PutMapping("api/admin/companies/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long companyId, @RequestBody Company company){
        return ResponseEntity.ok(companyService.updateCompany(company,companyId));
    }
}
