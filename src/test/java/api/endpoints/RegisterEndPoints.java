package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import api.payloads.Register;

public class RegisterEndPoints {

    public Response RegisterUser(Register payload){
//        String RegisterUrl = "/register";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(Routes.registerUser);
        return response;
    }

}
