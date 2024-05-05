package api.test;

import api.endpoints.UserEndPoints;
import api.payloads.User;

import com.github.javafaker.Faker;

import org.testng.annotations.BeforeClass;

import java.io.InputStream;
import java.util.Properties;

public class BaseTest{
    Faker faker;
    User userPayload;
    int userID;


    @BeforeClass
    public void Setup(){

//        System.setProperty("basicurl", "https://reqres.in/api");

        faker = new Faker();
        userPayload = new User();
        String userID;

        userPayload.setId(Integer.parseInt(faker.number().digits(1)));
        userPayload.setFirst_name(faker.name().firstName());
        userPayload.setLast_name(faker.name().lastName());
        userPayload.setEmail("hammadasif@gmail.com");

//        try {
//            InputStream inStream = getClass().getClassLoader().getResourceAsStream("config.properties");
//            Properties prop = new Properties();
//            prop.load(inStream);
//            UserEndPoints.baseUrl = prop.getProperty("reqresAPIBaseUrl");
////            Routes.baseUrl = prop.getProperty("reqresAPIBaseUrl");
////            UserEndPoints.baseUrl = System.getProperty("basicurl");
//
//            return prop;
//        }
//        catch (Exception e){
//            System.out.println("File Not Found");
//            return null;
//        }



    }



}
