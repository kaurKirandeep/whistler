package com.example.jobapplication.data;

import android.renderscript.ScriptIntrinsicYuvToRGB;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetails {

    public String name;
    public String userName;
    public String password;
    public Integer phoneNumber;
    public String userType;
    public String emailAddress;
    public String userAddress;
    public String hrEmail;
    public boolean lockAccount = false;

    static ArrayList<UserDetails> userDetails = new ArrayList<UserDetails>();

    public UserDetails(String name, String userName, String password, Integer phoneNumber, String userType, String emailAddress, String userAddress, String hrEmail, boolean lockAccount) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.emailAddress = emailAddress;
        this.userAddress = userAddress;
        this.hrEmail = hrEmail;
        this.lockAccount = lockAccount;
    }

    public UserDetails(){

        addDetails();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getHrEmail() {
        return hrEmail;
    }

    public void setHrEmail(String hrEmail) {
        this.hrEmail = hrEmail;
    }

    public boolean isLockAccount() {
        return lockAccount;
    }

    public void setLockAccount(boolean lockAccount) {
        this.lockAccount = lockAccount;
    }

    private void addDetails(){

        if(userDetails.isEmpty()) {
            userDetails.add(new UserDetails("Charan", "SaiCharan", "abc123...", 987654323, "user", "saicharan@gmail.com", "223 rue sherbrooke", "hr@bonea.com", false));
            userDetails.add(new UserDetails("ISI College", "ISICollege", "abc123", 1234567890, "admin", "admin@isi.com", "Montreal, Canada", "", false));
            userDetails.add(new UserDetails("Sherlock", "SherlockHolmes", "abc", 897125476, "user", "sherlock@gmail.com", "London, UK", "hr@uk.com", false));
            userDetails.add(new UserDetails("Martin", "MartinGarrix", "abc789", 1245784258, "user", "martin@gmail.com", "Manali, India", "hr@india.com", true));
        }
    }

    public String[] checkCredentials(String inputUsername, String inputPassword){

        for(int i = 0; i < userDetails.size(); i++){
            String vUser = userDetails.get(i).getUserName();
            String vPass = userDetails.get(i).getPassword();

            if (vUser.equals(inputUsername) && vPass.equals(inputPassword)) {

                String[] values = new String[3];
                values[0] = userDetails.get(i).getName();
                values[1] = userDetails.get(i).getUserType();
                values[2] = Boolean.toString(userDetails.get(i).isLockAccount());

                return values;
            }
        }

        return null;
    }

    public void removeAccount(String name){

        for(int i = 0; i < userDetails.size(); i++){

            if(userDetails.get(i).getName().equals(name)){

                userDetails.remove(i);
            }
        }
    }

    public void updateDetails(String name, String password, Integer phoneNumber,String emailAddress, String userAddress, String hrEmail){

        for(int i = 0; i < userDetails.size(); i++){

            if(userDetails.get(i).getName().equals(name)){

                userDetails.get(i).setName(name);
                userDetails.get(i).setPassword(password);
                userDetails.get(i).setPhoneNumber(phoneNumber);
                userDetails.get(i).setEmailAddress(emailAddress);
                userDetails.get(i).setUserAddress(userAddress);
                userDetails.get(i).setHrEmail(hrEmail);

            }
        }
    }

    public boolean lockUnlock(String name, boolean setLock){


        for(int i = 0; i < userDetails.size(); i++){

            if(userDetails.get(i).getName().equals(name)){
                userDetails.get(i).setLockAccount(setLock);
            }
        }
        return setLock;
    }

    public ArrayList<UserDetails> getAllUsers(){

        if(userDetails.isEmpty()){
            addDetails();
        }
        return userDetails;
    }

    public String[] getUser(String name){

        String[] values = new String[7];

        for(int i = 0; i < userDetails.size(); i++){

            if(userDetails.get(i).getName().equals(name)){

                values[0] =  userDetails.get(i).getName();
                values[1] =  userDetails.get(i).getPassword();
                values[2] =  String.valueOf(userDetails.get(i).getPhoneNumber());
                values[3] =  userDetails.get(i).getEmailAddress();
                values[4] =  userDetails.get(i).getUserAddress();
                values[5] =  userDetails.get(i).getHrEmail();
                values[6] = String.valueOf((userDetails.get(i).isLockAccount()));

                return values;

            }
        }
        return null;
    }

}
