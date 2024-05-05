package api.test;


import api.endpoints.UserEndPoints;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static org.hamcrest.Matchers.*;

public class DDTests extends BaseTest{

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String UserId,String firstName, String lastName, String userEmail){

        userPayload.setId(Integer.parseInt(UserId));
        userPayload.setFirst_name(firstName);
        userPayload.setLast_name(lastName);
        userPayload.setEmail(userEmail);

        Response response = UserEndPoints.CreateUser(userPayload);
        response.then().log().all()
                .statusCode(201)
                .body("first_name",comparesEqualTo(userPayload.getFirst_name()))
                .body("last_name",comparesEqualTo(userPayload.getLast_name()))
                .body("email",comparesEqualTo(userPayload.getEmail()))
                .body("id",comparesEqualTo(userPayload.getId()))
                .body("id",isA(Integer.class))
                .body("first_name",isA(String.class))
                .body("last_name",isA(String.class));


        userID = response.jsonPath().getInt("id");

    }

    @Test(priority = 2, dataProvider = "UserID", dataProviderClass = DataProviders.class)
    public void testGetSingleUser(String userID){

        Response response = UserEndPoints.ReadUser(userID);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 3, dataProvider = "UserID", dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userID){

        Response response = UserEndPoints.DeleteUser(userID);
        response.then().log().all().statusCode(204); // To Pass
//        response.then().log().all().statusCode(200); // To Fail
    }

    @Test(priority = 4, dataProvider = "UserID", dataProviderClass = DataProviders.class)
    public void testDeleteSelectedUser(String userID){
        if(Objects.equals(userID, "3")){
            Response response = UserEndPoints.DeleteUser(userID);
            response.then().log().all().statusCode(204);
        }
        else {
            System.out.println(userID);
            System.out.println("Do Nothing");
        }

    }
}
