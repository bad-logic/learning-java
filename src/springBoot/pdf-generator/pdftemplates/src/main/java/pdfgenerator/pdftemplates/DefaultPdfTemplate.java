package pdfgenerator.pdftemplates;


import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import pdfgenerator.templates.PdfTemplateComponent;
import pdfgenerator.templates.PdfTemplate;

import java.io.ByteArrayOutputStream;
import java.util.Map;

/**
 * A very basic template for PDFfer that takes a java Map of String to Object
 * and prints it out in table form with the key name and corresponding value
 * in each row.
 */
@PdfTemplateComponent(name = "default")
public class DefaultPdfTemplate implements PdfTemplate {
    private Map<String, Object> data;
    private byte[] output;

    @Override
    public Map<String, Object> getPdfData() {
        return data;
    }

    @Override
    public void setPdfData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public void generate() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(os));
        pdfDoc.setDefaultPageSize(PageSize.A4);
        Document layoutDoc = new Document(pdfDoc);
        layoutDoc.setMargins(25f,25f,25f,25f);

        Table table = new Table(UnitValue.createPercentArray(new float[]{47.5f, 5f, 47.5f})).useAllAvailableWidth().setMargins(0f,0f,0f,0f);

        table.addHeaderCell( new Cell().add(new Paragraph("KEY").setBold()).setBorder(Border.NO_BORDER));
        table.addHeaderCell(new Cell().setBorder(Border.NO_BORDER));
        table.addHeaderCell(new Cell().add(new Paragraph("VALUE").setBold()).setBorder(Border.NO_BORDER));

        for(Map.Entry<String,Object> pair: data.entrySet()){
            table.addCell(new Cell().add(new Paragraph(pair.getKey())).setBorder(Border.NO_BORDER));
            table.addCell(new Cell().setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add(new Paragraph(pair.getValue().toString())).setBorder(Border.NO_BORDER));
        }

        layoutDoc.add(table);
        layoutDoc.close();
        output = os.toByteArray();

    }

    @Override
    public byte[] getPdfContent() {
        return output;
    }
}
