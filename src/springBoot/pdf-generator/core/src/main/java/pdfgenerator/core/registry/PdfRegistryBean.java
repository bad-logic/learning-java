package pdfgenerator.core.registry;

import pdfgenerator.templates.PdfTemplate;
import pdfgenerator.templates.PdfTemplateComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Pdf registry bean.
 */
@Component
public class PdfRegistryBean {
    private static final Logger logger = LoggerFactory.getLogger(PdfRegistryBean.class);
    private final ApplicationContext context;


    /**
     * Instantiates a new Pdf registry bean.
     *
     * @param parentContext the parent context
     */
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

    /**
     * Find template pdf template.
     *
     * @param templateName the template name
     * @return the pdf template
     */
    public PdfTemplate findTemplate(String templateName){
        logger.debug("looking for PDF template '{}' in [{}]",templateName,context.getId());
        return context.getBean(templateName, PdfTemplate.class);
    }

    /**
     * List templates list.
     *
     * @return the list
     */
    public List<String> listTemplates(){
        logger.debug("listing all available pdf templates in [{}]", context.getId());
        return List.of(context.getBeanNamesForAnnotation((PdfTemplateComponent.class)));
    }

}
