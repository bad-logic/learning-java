package pdfgenerator.core;

import pdfgenerator.core.registry.PdfRegistryBean;
import pdfgenerator.templates.PdfTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PdfProducerBean {

    private final PdfRegistryBean registry;

    public PdfProducerBean(PdfRegistryBean bean){
        this.registry = bean;
    }

    public byte[] generatePdfDocument(String templateName, Map<String,Object> data){
        PdfTemplate template = findTemplate(templateName);
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
