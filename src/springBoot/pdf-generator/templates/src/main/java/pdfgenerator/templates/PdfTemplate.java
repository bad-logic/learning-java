package pdfgenerator.templates;

import java.util.Map;

/**
 * The interface Pdf template.
 */
public interface PdfTemplate {
    /**
     * Gets pdf data.
     *
     * @return the pdf data
     */
    Map<String,Object> getPdfData();

    /**
     * Sets pdf data.
     *
     * @param data the data
     */
    void setPdfData(Map<String,Object> data);

    /**
     * Validate boolean.
     *
     * @return the boolean
     */
    boolean validate();

    /**
     * Generate.
     */
    void generate();

    /**
     * Get pdf content byte [ ].
     *
     * @return the byte [ ]
     */
    byte[] getPdfContent();
}
