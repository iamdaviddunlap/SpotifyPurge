package app.util;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import spark.*;

import java.io.StringWriter;

public class ViewUtil {

    // Renders a template given a model and a request
    // The request is needed to check the user session for language settings
    // and to see if the user is logged in
    public static String render(Request request, Response response, String templatePath) {
        response.redirect(templatePath);
        return "";
    }

    public static String parseFTL(String filePath) {
        final Configuration configuration = new Configuration(new Version(2, 3, 0));

        configuration.setClassForTemplateLoading(ViewUtil.class, "/");
        StringWriter writer = new StringWriter();

        try {
            Template formTemplate = configuration.getTemplate(filePath);

            formTemplate.process(null, writer);
        } catch (Exception e) {
            Spark.halt(500);
        }

        return writer.toString();
    }

}