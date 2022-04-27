package users;

import api.BaseApi;
import constants.JsonTemplatesConstants;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;


public class userCardTest {
private BaseApi api;


    private int idFirstUser;
    private String nameFirstUser;
    private String gradeFirstUser;

    private int idLastUser;
    private String nameLastUser;
    private String gradeLastUser;


    @BeforeTest(groups = "api")
        public void GetAllUsers() {
        api = new BaseApi();
        Response getAllUsers = api.userAPI().getAllUsers();
        getAllUsers.then().statusCode(HttpStatus.SC_OK).body("id", everyItem(is(notNullValue())),
                "name", everyItem(is(notNullValue())), "grade", everyItem(is(notNullValue())));

        idFirstUser = getAllUsers.path("id[0]");
        nameFirstUser = getAllUsers.path("name[0]");
        gradeFirstUser = getAllUsers.path("grade[0]");

        idLastUser = getAllUsers.path("id[-1]");
        nameLastUser = getAllUsers.path("name[-1]");
        gradeLastUser = getAllUsers.path("grade[-1]");

    }

    @Test(groups = {"api", "positive"})
    @Description("Get first users card")
    public void GetFirstUsersCard() throws FileNotFoundException {
        int userId = idFirstUser;
        Response getFirstUser = api.userAPI().getUserById(userId);
        getFirstUser.then().statusCode(HttpStatus.SC_OK).body("id",is(idFirstUser), "name", is(nameFirstUser), "school_name",is(notNullValue()), "city",is(notNullValue()));
    }

    @Test(groups = {"api", "positive"})
    @Description("Get last users card")
    public void GetLastUsersCard() throws FileNotFoundException {
        int userId = idLastUser;
        Response getLastUser = api.userAPI().getUserById(userId);
        getLastUser.then().statusCode(HttpStatus.SC_OK).body("id",is(idLastUser), "name", is(nameLastUser), "school_name",is(notNullValue()), "city",is(notNullValue()));
    }


    @Test(groups = {"api", "positive"})
    @Description("Get first users card")
    public void JsonSchemaTest() throws FileNotFoundException {
        int userId = idFirstUser;
        Response getFirstUser = api.userAPI().getUserById(userId);
        getFirstUser.then().statusCode(HttpStatus.SC_OK).body(matchesJsonSchemaInClasspath("schema/userCardSchema.json"));
    }


}
