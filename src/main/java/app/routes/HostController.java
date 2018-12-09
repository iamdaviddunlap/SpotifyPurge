package app.routes;

import app.util.PathUtil;
import app.util.ViewUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;

public class HostController {

    public static Route serveTestPage = (Request request, Response response) -> {
        return ViewUtil.parseFTL(PathUtil.Template.TEST);
    };
}
