package com.example.firstjobapp.job;

import com.example.firstjobapp.company.Company;
import com.example.firstjobapp.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;

    @Autowired
    private CompanyService companyService;

    @Override
    public List<Job> getAlljobs(){
        return jobRepository.findAll();
    }
    @Override
    public Job getJobById(Long id) {
        Optional<Job> job=jobRepository.findById(id);
        if(job.isPresent()){
            return job.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public void createJob(Job job) {
        Company company = companyService.getCompanyById(job.getCompany().getCompanyId());
        if(company!=null){
            job.setCompany(company);
            jobRepository.save(job);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public String deleteJob(Long id){
        Optional<Job> job= jobRepository.findById(id);
        if(job.isPresent()){
            jobRepository.delete(job.get());
            return "Job with title "+job.get().getTitle()+" has been deleted";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Job with id "+id+" not found");
    }
    @Override
    public Job updateJob(Job job, Long id){
        Job job1;
        Optional<Job> temp= jobRepository.findById(id);
        if(temp.isPresent()){
            job1 = temp.get();
            job1.setTitle(job.getTitle());
            job1.setDescription(job.getDescription());
            job1.setMinSalary(job.getMinSalary());
            job1.setMaxSalary(job.getMaxSalary());
            job1.setLocation(job.getLocation());
            jobRepository.save(job1);
            return job1;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Job with id "+id+" not found");
        }
    }
}
