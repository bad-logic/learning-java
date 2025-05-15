package pdfgenerator.core.registry;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;
import pdfgenerator.templates.PdfTemplateComponent;

public class PdfTemplateScopeMetadataResolver implements ScopeMetadataResolver {
    @Override
    public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
        try{
            Class<?> c = Class.forName(definition.getBeanClassName());
            PdfTemplateComponent pdfc = c.getAnnotation(PdfTemplateComponent.class);
            ScopeMetadata scope = new ScopeMetadata();
            if(pdfc.singleton()){
                scope.setScopeName(BeanDefinition.SCOPE_SINGLETON);
            }else{
                scope.setScopeName(BeanDefinition.SCOPE_PROTOTYPE);
            }
            return scope;
        }catch (ClassNotFoundException ex){
            throw new BeanCreationException("cannot find bean class");
        }
    }
}
