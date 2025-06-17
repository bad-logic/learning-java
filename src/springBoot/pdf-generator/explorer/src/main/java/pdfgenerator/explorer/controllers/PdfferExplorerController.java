package pdfgenerator.explorer.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import pdfgenerator.core.PdfProducerBean;
import pdfgenerator.core.registry.PdfRegistryBean;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

/**
 * The type Pdffer explorer controller.
 */
@Controller
@RequestMapping("explorer")
public class PdfferExplorerController {

    @Value("classpath:pdfgenerator/explorer/download.html")
    private Resource downloadHtmlTemplate;

    private final ObjectMapper mapper;
    private final PdfProducerBean pdffer;
    private final PdfRegistryBean registry;

    private static final Logger logger = LoggerFactory.getLogger(PdfferExplorerController.class);

    /**
     * Instantiates a new Pdffer explorer controller.
     *
     * @param mapper   the mapper
     * @param pdffer   the pdffer
     * @param registry the registry
     */
    public PdfferExplorerController(ObjectMapper mapper, PdfProducerBean pdffer, PdfRegistryBean registry){
        this.mapper = mapper;
        this.pdffer = pdffer;
        this.registry = registry;
    }

    private String htmlTemplateAsString(Resource resource){
        try(Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)){
            String htmlTemplate = FileCopyUtils.copyToString(reader);
            StringBuilder pdfTemplateHtml = new StringBuilder();
            List<String> templatePaths = registry.listTemplates();
            for(String path: templatePaths){
                pdfTemplateHtml.append("<option>");
                pdfTemplateHtml.append(path);
                pdfTemplateHtml.append("</option>");
            }
            return htmlTemplate.replace("{{templates}}", pdfTemplateHtml);
        }catch (IOException ex){
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     * Download form string.
     *
     * @return the string
     */
    @GetMapping(value = "download", produces = TEXT_HTML_VALUE)
    @ResponseBody
    public String downloadForm(){
        return htmlTemplateAsString(downloadHtmlTemplate);
    }

    /**
     * Process download form byte [ ].
     *
     * @param template the template
     * @param payload  the payload
     * @return the byte [ ]
     * @throws IOException the io exception
     */
    @PostMapping(value="download",produces = APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] processDownloadForm(@RequestParam("pdfTemplate") String template, @RequestParam("pdfPayload") String payload) throws IOException {
        Map<String,Object> pdfData = mapper.readValue(payload,((Class<Map<String,Object>>)(Class<?>) Map.class));
        return pdffer.generatePdfDocument(template,pdfData);
    }

}
