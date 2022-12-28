package com.driver;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        /*
        if(oldPassword.equals(this.password)){
            if(newPassword.length() >= 8 &&
                    newPassword.matches(".*[A-Z].*") &&
                    newPassword.matches(".*[a-z].*") &&
                    newPassword.matches(".*[0-9].*") &&
                    newPassword.matches(".*[^A-Za-z0-9].*")){
                            this.password = newPassword;
            }
         }
        */

        if(Objects.equals(getPassword(), oldPassword)){
            if(newPassword.length()>=8){
                boolean up = false;
                boolean low = false;
                boolean digit = false;
                for(int i=0; i<newPassword.length(); i++){
                    int k = (int)newPassword.charAt(i);
                    if(k>64 && k<91){
                        up = true;
                    }
                    if(k>96 && k<123){
                        low = true;
                    }
                    if(k>47 && k<58) {
                        digit = true;
                    }
                }
                Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(newPassword);
                boolean sp = m.find();
                if(up && low && digit && sp){
                    setPassword(newPassword);
                }
            }
        }
    }
}
