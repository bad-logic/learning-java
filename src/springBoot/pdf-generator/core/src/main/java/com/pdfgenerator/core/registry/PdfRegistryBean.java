package com.pdfgenerator.core.registry;

import com.pdfgenerator.templates.PdfTemplate;
import com.pdfgenerator.templates.PdfTemplateComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PdfRegistryBean {
    private static final Logger logger = LoggerFactory.getLogger(PdfRegistryBean.class);
    private final ApplicationContext context;


    public PdfRegistryBean(ApplicationContext parentContext){
        logger.debug("creating separate template context under [{}]", parentContext.getId());
        AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
        childContext.setId("pdf-templates");
        childContext.register(PdfTemplateRegistrationConfiguration.class);
        childContext.refresh();
        childContext.start();
        context = childContext;
        logger.debug("created separate template context [{}] under [{}]",context.getId(),parentContext.getId() );
    }

    public PdfTemplate findTemplate(String templateName){
        logger.debug("looking for PDF template '{}' in [{}]",templateName,context.getId());
        return context.getBean(templateName, PdfTemplate.class);
    }

    public List<String> listTemplates(){
        logger.debug("listing all available pdf templates in [{}]", context.getId());
        return List.of(context.getBeanNamesForAnnotation((PdfTemplateComponent.class)));
    }

}
