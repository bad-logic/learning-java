package pdfgenerator.core.registry;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import pdfgenerator.templates.PdfTemplateComponent;

/**
 * The type Pdf template bean name generator.
 */
public class PdfTemplateBeanNameGenerator implements BeanNameGenerator {

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        try {
            Class<?> c = Class.forName(definition.getBeanClassName());
            PdfTemplateComponent pdc = c.getAnnotation(PdfTemplateComponent.class);
            return pdc.name();
        }catch (ClassNotFoundException ex){
            throw new BeanCreationException("cannot find bean class");
        }
    }
}
