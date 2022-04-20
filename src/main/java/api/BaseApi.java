package api;

import api.userAPI.UserAPI;
import constants.EndpointsPath;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;
import utils.properties.PropertyLoaderStatic;
import utils.rest.RestHelper;


import java.util.HashMap;

@Resource.Classpath("config.properties")
public class BaseApi extends RestHelper {
    @Property("service_url")
    private static String baseUrl;



    static {
        PropertyLoaderStatic.populate(BaseApi.class);
    }

    public BaseApi() {
        setUrl(baseUrl);
        headers = new HashMap<>();
    }

    public UserAPI userAPI() {
        return new UserAPI(url, headers);
    }


}
