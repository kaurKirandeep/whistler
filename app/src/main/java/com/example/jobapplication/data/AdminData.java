package com.example.jobapplication.data;

import com.example.jobapplication.R;

import java.util.ArrayList;

public class AdminData {

    static ArrayList<AdminData> adminData = new ArrayList<AdminData>();

    public int Id;
    public String ApplicantName;
    public String JobNameApplied;
    public String imagePath;

    public AdminData(){
        addingAdminData();
    }

    public AdminData(int id, String applicantName, String jobNameApplied, String imagePath) {
        Id = id;
        ApplicantName = applicantName;
        JobNameApplied = jobNameApplied;
        this.imagePath = imagePath;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getApplicantName() {
        return ApplicantName;
    }

    public void setApplicantName(String applicantName) {
        ApplicantName = applicantName;
    }

    public String getJobNameApplied() {
        return JobNameApplied;
    }

    public void setJobNameApplied(String jobNameApplied) {
        JobNameApplied = jobNameApplied;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void addingAdminData(){

        if(adminData.isEmpty()) {
            adminData.add(new AdminData(1, "Charan", "Full Stack Developer", "i1"));
            adminData.add(new AdminData(2, "Sherlock", "Mechanical Engineer", "i4"));
            adminData.add(new AdminData(3, "Charan", "Frontend Developer", "i2"));
        }
    }

    public void addNewAdminData(String applicantName,String jobApplied, String image){

        addingAdminData();
        int newId = adminData.size() + 2;
        adminData.add(new AdminData(newId, applicantName, jobApplied, image));
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

    public void removeApplication(String jName, String name){

        for(int i = 0; i < adminData.size(); i++){

            if(adminData.get(i).getJobNameApplied().equals(jName) && adminData.get(i).getApplicantName().equals(name)){

                adminData.remove(i);
            }
        }
    }

    public ArrayList<AdminData> getAll(){

        if(adminData.isEmpty()){
            addingAdminData();
        }
        return adminData;
    }

}
