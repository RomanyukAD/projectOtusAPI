package users;

import api.BaseApi;
import constants.JsonTemplatesConstants;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.FileNotFoundException;

import static org.hamcrest.Matchers.*;


public class allUsersTest {
private BaseApi api;


private String nameFirstUser;
private int idFirstUser;

    @BeforeTest(groups = "api")
    public void connect() {
        api = new BaseApi();
    }


    @Test(groups = {"api", "positive"})
    @Description("Get datas of all users")
    public void GetAllUsers() throws FileNotFoundException {
        Response getAllUsers = api.userAPI().getAllUsers();
        getAllUsers.then().statusCode(HttpStatus.SC_OK).body("id", everyItem(is(notNullValue())),
                "name", everyItem(is(notNullValue())), "grade", everyItem(is(notNullValue())));
    }

    @Test(groups = {"api", "positive"})
    @Description("Json schema test")
    public void GetAllUsersSchemaTest() throws FileNotFoundException {
        Response getAllUsers = api.userAPI().getAllUsers();
        getAllUsers.then().statusCode(HttpStatus.SC_OK).body(is(matchesJsonSchemaInClasspath(JsonTemplatesConstants.USERS_ALL_SCHEMA)));
    }



}
