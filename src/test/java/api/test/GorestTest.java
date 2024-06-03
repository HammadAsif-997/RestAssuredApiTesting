package api.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class GorestTest {

    public String baseURL = "https://gorest.co.in/public/v2";
    @BeforeMethod
    public void Setup() throws IOException {
        baseURI = baseURL;
        Response response = when().get("/users");

        FileWriter file = new FileWriter("./src/test/resources/GorestAllUserResponse.json");
        file.write(response.prettyPrint());
        file.flush();
        file.close();
    }
    @Test(priority = 1)
    public void TestActiveAndInactive() throws IOException {
        baseURI = baseURL;
        Response response = when().get("/users");

        List<String> responseValues = response.jsonPath().getList("status");
        List<String> expectedValues = Arrays.asList("active", "inactive");

        Assert.assertTrue(responseValues.stream().allMatch(expectedValues::contains));

    }

    @Test(priority = 2)
    public void ReadAllUsers() throws IOException {
        baseURI = baseURL;
        Response response = when().get("/users");

//        Call that file for comparison
        File jsonFile = new File("./src/test/resources/GorestAllUserResponse.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode actualJson = objectMapper.readTree(response.prettyPrint());
        JsonNode expectedJson = objectMapper.readTree(jsonFile);

//        file comparison
        Assert.assertEquals(actualJson, expectedJson);
//        Compare data types for each key
        Assert.assertEquals(actualJson.getNodeType(), expectedJson.getNodeType());
//        Schema validation
        response.then().assertThat().body(matchesJsonSchemaInClasspath("GorestAllUserSchema.json"));

    }


}
