package pdfgenerator.core.registry;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import pdfgenerator.templates.PdfTemplate;

import java.io.IOException;

public class PdfTemplateExcludeFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        try {
            Class<?> c = Class.forName(metadataReader.getClassMetadata().getClassName());
            return !PdfTemplate.class.isAssignableFrom(c);
        }catch (ClassNotFoundException ex){
            return false;
        }
    }
}
