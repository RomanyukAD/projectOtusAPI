package constants;

public class EndpointsPath {
    private EndpointsPath() {
        throw new IllegalStateException("Constants class");
    }

    public static final String GET_USER_BY_id = "/users/get/%s";
    public static final String GET_USER_BY_id_WITHOUT_GET = "/users/%s";
    public static final String GET_ALL_USERS = "/users/get/all";

}
