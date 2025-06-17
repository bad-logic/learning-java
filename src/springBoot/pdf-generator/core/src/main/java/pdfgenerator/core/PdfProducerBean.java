package pdfgenerator.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pdfgenerator.core.registry.PdfRegistryBean;
import pdfgenerator.templates.PdfTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * The type Pdf producer bean.
 */
@Component
public class PdfProducerBean {

    private final PdfRegistryBean registry;

    private static final Logger logger = LoggerFactory.getLogger(PdfProducerBean.class);

    /**
     * Instantiates a new Pdf producer bean.
     *
     * @param bean the bean
     */
    public PdfProducerBean(PdfRegistryBean bean){
        this.registry = bean;
    }

    /**
     * Generate pdf document byte [ ].
     *
     * @param templateName the template name
     * @param data         the data
     * @return the byte [ ]
     */
    public byte[] generatePdfDocument(String templateName, Map<String,Object> data){
        PdfTemplate template = findTemplate(templateName);
        logger.debug("found template " + templateName + ": "+ template);
        template.setPdfData(data);
        if(!template.validate()){
            throw new IllegalArgumentException("PDF Template payload is not valid");
        }
        template.generate();
        return template.getPdfContent();
    }

    private PdfTemplate findTemplate(String templateName) {
        return registry.findTemplate(templateName);
    }

}
