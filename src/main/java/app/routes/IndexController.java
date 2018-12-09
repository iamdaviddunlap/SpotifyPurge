package app.routes;

import app.auth.AuthorizationCodeUriExample;
import app.util.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import spark.*;

import java.io.StringWriter;

public class IndexController {

    public static Route serveIndexPage = (Request request, Response response) -> {
        if(request.cookie("authToken") == null) {
            response.redirect(AuthorizationCodeUriExample.authorizationCodeUri_Sync());
        }
        return ViewUtil.parseFTL(PathUtil.Template.INDEX);
    };
}
