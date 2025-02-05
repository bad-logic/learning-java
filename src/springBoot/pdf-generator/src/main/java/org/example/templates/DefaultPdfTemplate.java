package org.example.templates;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import org.example.pdfgenerator.template.PdfTemplate;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class DefaultPdfTemplate implements PdfTemplate {
    private Map<String,Object> data;
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
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(os));
        pdfDocument.setDefaultPageSize(PageSize.A4);

        Document layoutDocument = new Document(pdfDocument);
        layoutDocument.setMargins(355f,25f,25f,25f);
        Table table = new Table(UnitValue.createPercentArray(new float[]{47.5f,5f,47.5f,5f})).useAllAvailableWidth().setMargins(0f,0f,0f,0f);

        table.addHeaderCell(new Cell().add(new Paragraph("KEY").setBold()).setBorder(Border.NO_BORDER));

        table.addHeaderCell(new Cell().setBorder(Border.NO_BORDER));

        table.addHeaderCell( new Cell().add(new Paragraph("VALUE").setBold()).setBorder(Border.NO_BORDER));

        for(Map.Entry<String,Object> pair: data.entrySet()){
            table.addCell(new Cell().add(new Paragraph(pair.getKey())).setBorder(Border.NO_BORDER));
            table.addCell(new Cell().setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add(new Paragraph(pair.getValue().toString())).setBorder(Border.NO_BORDER));
        }

        layoutDocument.add(table);
        layoutDocument.close();
        output = os.toByteArray();
    }

    @Override
    public byte[] getPdfContent() {
        return output;
    }
}
