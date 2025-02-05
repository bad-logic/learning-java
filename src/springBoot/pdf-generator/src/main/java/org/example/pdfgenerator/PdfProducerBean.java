package org.example.pdfgenerator;

import org.example.templates.DefaultPdfTemplate;
import org.springframework.stereotype.Component;
import org.example.pdfgenerator.template.PdfTemplate;

import java.util.Map;

@Component
public class PdfProducerBean {

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
        return new DefaultPdfTemplate();
    }

}
