package pdfgenerator.explorer.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * The type Pdffer error controller.
 */
@Controller
public class PdfferErrorController implements ErrorController {

    @Value("classpath:pdfgenerator/explorer/error.html")
    private Resource errorHtmlTemplate;


    private static String htmlTemplateAsString(Resource resource, HttpServletRequest request){
        try(Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code") ;
            Exception exc = (Exception) request.getAttribute("javax.servlet.error.exception");
            return FileCopyUtils.copyToString(reader)
                    .replace("{{status}}", statusCode!= null ? statusCode.toString() : "500")
                    .replace("{{exception}}", exc!=null ? exc.getMessage() : "-");
        }catch (IOException e){
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Handle error string.
     *
     * @param req the req
     * @return the string
     */
    @RequestMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest req){
        return htmlTemplateAsString(errorHtmlTemplate,req);
    }

}
