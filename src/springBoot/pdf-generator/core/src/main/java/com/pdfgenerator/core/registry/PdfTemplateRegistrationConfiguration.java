package com.pdfgenerator.core.registry;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = "com.example.templates",
        useDefaultFilters = false,
        excludeFilters = @Comp
)
public class PdfTemplateRegistrationConfiguration {
}
