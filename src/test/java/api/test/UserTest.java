package api.test;

import api.endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class UserTest extends BaseTest{


    @Test(priority = 1)
    public void TestPostUser(){

        Response response = UserEndPoints.CreateUser(userPayload);
        response.then().log().all()
            .assertThat().body(containsString("id"));

        userID = response.jsonPath().getInt("id");
        Assert.assertEquals(response.getStatusCode(),201);
    }

    @Test(priority = 2)
    public void TestReadSingleUser(){

        Response response = UserEndPoints.ReadUser("2");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void TestReadAllUsersPageAndRecord(){
        Response response = UserEndPoints.ReadAllUsers();

        response.then().log().all()

                .statusCode(200) // To Pass
//                .statusCode(201) // To Fail
                .assertThat().body("total",comparesEqualTo(12))
                .assertThat().body("total_pages",comparesEqualTo(2));
    }


    @Test(priority = 4)
    public void TestUpdateUserAllData(){

        userPayload.setFirst_name(faker.name().firstName());
        userPayload.setLast_name(faker.name().lastName());
        userPayload.setEmail("hammad.asif@venturedive.com");

        Response response = UserEndPoints.UpdateUser(userID,userPayload);
        response.then().log().all()
                .statusCode(200)
                .assertThat().body("first_name",comparesEqualTo(userPayload.getFirst_name()))
                .assertThat().body("last_name",comparesEqualTo(userPayload.getLast_name()))
                .assertThat().body("email",comparesEqualTo(userPayload.getEmail()));

    }


    @Test(priority = 5)
    public void TestUpdateUserLastName(){

        userPayload.setLast_name(faker.name().lastName());

        Response response = UserEndPoints.UpdateUser(userID,userPayload);
        response.then().log().all()
                .statusCode(200)
                .assertThat().body("first_name",comparesEqualTo(userPayload.getFirst_name()))
                .assertThat().body("last_name",comparesEqualTo(userPayload.getLast_name()))
                .assertThat().body("email",comparesEqualTo(userPayload.getEmail()));;

    }


    @Test(priority = 6)
    public void TestDeleteUser(){

        Response response = UserEndPoints.DeleteUser("2");
        response.then().log().all().statusCode(204);

    }



}
