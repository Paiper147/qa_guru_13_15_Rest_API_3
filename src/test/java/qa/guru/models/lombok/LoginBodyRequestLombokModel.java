package qa.guru.models.lombok;

import lombok.Data;

@Data
public class LoginBodyRequestLombokModel {
//    String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

    private String email;
    private String password;


//    in rest-assured .body(requestBody) correctly accepts without .body(requestBody.toString) and Override
//    toString method
//    @Override
//    public String toString(){
//        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
//    }
}
