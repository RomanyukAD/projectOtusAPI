package api.userAPI;

import constants.EndpointsPath;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.rest.RestHelper;

import java.util.Map;

public class UserAPI extends RestHelper {
    public UserAPI(String url, Map<String, String> headers) {
        this.url = url;
        this.headers = headers;
    }


    @Step("GET /users/get/all ")
    public Response getAllUsers () {
        return get (String.format(EndpointsPath.GET_ALL_USERS));
    }

    @Step("GET /users/get/{id}")
    public Response getUserById (int id ) {
        return get (String.format(EndpointsPath.GET_USER_BY_id, id));
    }

    @Step("GET /users/{id}")
    public Response getUserByIdWithoutGet (int id ) {
        return get (String.format(EndpointsPath.GET_USER_BY_id_WITHOUT_GET, id));
    }

}