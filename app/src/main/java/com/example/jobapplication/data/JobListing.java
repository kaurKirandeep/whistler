package com.example.jobapplication.data;

import com.example.jobapplication.R;

import java.util.ArrayList;

public class JobListing {

    static ArrayList<JobListing> jobListings = new ArrayList<JobListing>();

    public int jobId;
    public String jobName;
    public String jobDescription;
    public double salary;
    public String imagePath;


    public JobListing(){
        addingJobs();
    }

    public JobListing(int jobId, String jobName, String jobDescription, double salary, String imagePath) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.salary = salary;
        this.imagePath = imagePath;
    }

    public String getImagePath(){
        return imagePath;
    }

    public void  setImagePath(String imagePath){
        this.imagePath = imagePath;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void addingJobs(){

        if(jobListings.isEmpty()) {
            jobListings.add(new JobListing(1, "Full Stack Developer", "Minimum experience of 2 years on Dot Net", 80000.00, "i1"));
            jobListings.add(new JobListing(2, "Frontend Developer", "Experience of 3 years on HTML, CSS, JS", 70000.00, "i2"));
            jobListings.add(new JobListing(3, "Backend Intern", "Student intern for Backend", 42000.00, "i3"));
            jobListings.add(new JobListing(4, "Mechanical Engineer", "1-3 years experience", 56000.00, "i4"));
            jobListings.add(new JobListing(5, "Electrical Engineer", "0-1 years experience", 32000.00, "i5"));
            jobListings.add(new JobListing(6, "Mechanical Techanician", "0-2 years experience", 40000.00, "i4"));
        }
    }

    public static int getImageID(String imageName){
        try {
            return R.drawable.class.getField(imageName).getInt(null);
        }
        catch (NoSuchFieldException | IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        return -1;
    }

    public ArrayList<JobListing> getAll(){
        if(jobListings.isEmpty()){
            addingJobs();
        }
        return jobListings;
    }

}
