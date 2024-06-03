package api.test;


import api.payloads.User;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    Faker faker;
    User userPayload;
    int userID;


    @BeforeClass
    public void Setup(){


        faker = new Faker();
        userPayload = new User();
        String userID;

        userPayload.setId(Integer.parseInt(faker.number().digits(1)));
        userPayload.setFirst_name(faker.name().firstName());
        userPayload.setLast_name(faker.name().lastName());
        userPayload.setEmail("hammadasif@gmail.com");




    }



}
