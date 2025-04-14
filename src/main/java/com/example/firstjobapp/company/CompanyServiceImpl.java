package com.example.firstjobapp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        if(company.isPresent()){
            return company.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    public String deleteCompanyById(Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        if(company.isPresent()){
            companyRepository.delete(company.get());
            return "Company with company name: "+company.get().getCompanyName()+" deleted successfully";
        }
        return "Company with companyId: "+companyId+" was not found.";
    }

    public Company updateCompany(Company company, Long companyId) {
        Optional<Company> companyExisting = companyRepository.findById(companyId);
        if(companyExisting.isPresent()){
            Company companyUpdated = companyExisting.get();
            companyUpdated.setCompanyName(company.getCompanyName());
            companyUpdated.setCompanyDescription(company.getCompanyDescription());
            companyRepository.save(companyUpdated);
            return companyUpdated;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
