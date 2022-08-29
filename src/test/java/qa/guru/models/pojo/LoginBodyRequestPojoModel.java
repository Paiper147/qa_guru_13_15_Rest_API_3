package qa.guru.models.pojo;

public class LoginBodyRequestPojoModel {
//    String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    in rest-assured .body(requestBody) correctly accepts without .body(requestBody.toString) and Override
//    toString method
//    @Override
//    public String toString(){
//        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
//    }
}
