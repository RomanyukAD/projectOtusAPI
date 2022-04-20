package constants;

import java.io.File;

public class JsonTemplatesConstants {
    private JsonTemplatesConstants() {
        throw new IllegalStateException("Constants class");
    }

    private static final String JSONS_SCHEMA = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsonschemas" + File.separator;

    public static final String USERS_ALL_SCHEMA = JSONS_SCHEMA + "allUsersSchema.json";

    public static final String USER_CARD_SCHEMA = JSONS_SCHEMA + "userCardSchema.json";


}
