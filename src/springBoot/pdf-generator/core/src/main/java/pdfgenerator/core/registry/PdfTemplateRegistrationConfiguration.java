package pdfgenerator.core.registry;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import pdfgenerator.templates.PdfTemplateComponent;

/**
 * The type Pdf template registration configuration.
 */
@Configuration
@ComponentScan(
        basePackages = "pdfgenerator.pdftemplates",
        useDefaultFilters = false,
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.CUSTOM,
                value = PdfTemplateExcludeFilter.class
        ),
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                value = PdfTemplateComponent.class
        ),
        nameGenerator = PdfTemplateBeanNameGenerator.class,
        scopeResolver = PdfTemplateScopeMetadataResolver.class
)
public class PdfTemplateRegistrationConfiguration {
}
