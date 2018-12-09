package app.util;

import lombok.*;

public class PathUtil {

    // The @Getter methods are needed in order to access
    // the variables from Velocity Templates
    public static class Web {
        @Getter public static final String INDEX = "/";
        @Getter public static final String TEST = "/test/";
    }

    public static class Template {
        public final static String INDEX = "templates/index.ftl";
        public final static String TEST = "templates/form.ftl";
    }

}