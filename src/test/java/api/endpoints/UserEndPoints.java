package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payloads.User;
import io.restassured.response.Response;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class UserEndPoints {

    static ResourceBundle getURL(){
        ResourceBundle routes = ResourceBundle.getBundle("config");
        return routes;
    }
    static String baseUrl = getURL().getString("reqresAPIBaseUrl");;
    public static Response CreateUser(User payload){
        String postUser = getURL().getString("postUser");
        baseURI = baseUrl;
        Response response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(postUser);
        return response;
    }
    public static Response ReadAllUsers(){
        String getAllUsers = getURL().getString("getAllUsers");
        baseURI = baseUrl;
        Response response = when().
                get(getAllUsers);

        return response;
    }
    public static Response ReadUser(String userId){
        String getSingleUser = getURL().getString("getSingleUser");
        baseURI = baseUrl;
        Response response = given().
                    pathParam("userid",userId).
                when().
                    get(getSingleUser);

        return response;
    }

    public static Response UpdateUser(String userId, User payload){
        String patchUser = getURL().getString("patchUser");
        baseURI = baseUrl;
        Response response = given()
                    .header("Content-Type", "application/json")
                    .body(payload)
                    .pathParam("userid",userId)
                .when()
                    .patch(patchUser);
        return response;
    }

    public static Response DeleteUser(String userId){
        String deleteUser = getURL().getString("deleteUser");
        baseURI = baseUrl;
        Response response = given().
                pathParam("userid",userId).
                when().
                delete(deleteUser);

        return response;
    }
}
