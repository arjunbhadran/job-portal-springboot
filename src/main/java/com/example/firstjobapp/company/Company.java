package com.example.firstjobapp.company;

import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String companyName;
    private String companyDescription;


    //connecting the company entity to the jobs entity
    //@JsonIgnore //to remove recursive callbacks. If you want the job details displayed then put JsonIgnore in Job model instead of here
    @OneToMany(mappedBy = "company") //since one company can have multiple jobs listed
    private List<Job> jobs;
    /*The mapped by tells spring boot that this relationship
    which from company to job is mapped by a field which
    exists in job called 'company'.*/

    //@JsonIgnore
    @OneToMany(mappedBy = "companyToReview")
    private List<Review> reviews;

    public Company() {// this is for the jpa
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
