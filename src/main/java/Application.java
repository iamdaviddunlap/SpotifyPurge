
import app.routes.IndexController;
import app.routes.HostController;
import app.util.Filters;
import app.util.PathUtil;

import static spark.Spark.*;

import spark.Spark;

public class Application {
    public static void main(String[] args) {
        // Configure Spark
        port(8000);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);

        // Set up before-filters (called before each get/post)
        before("*",Filters.addTrailingSlashes);

        // Set up routes
        Spark.get(PathUtil.Web.INDEX, IndexController.serveIndexPage);
        Spark.get(PathUtil.Web.TEST, HostController.serveTestPage);
    }


}
