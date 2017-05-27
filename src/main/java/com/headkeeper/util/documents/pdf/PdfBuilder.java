package com.headkeeper.util.documents.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class PdfBuilder extends AbstractPdfView {

    private void addFormBlank(PdfWriter writer) throws IOException, DocumentException {
        PdfContentByte canvas = writer.getDirectContentUnder();
        Image image = Image.getInstance("http://images.vfl.ru/ii/1495036553/b744b477/17259299.jpg");
        image.scaleAbsolute(PageSize.A4.getWidth(), PageSize.A4.getHeight());
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> modelDoc = (HashMap<String, Object>) model.get("model");
        com.headkeeper.util.documents.Document documentPdf = (com.headkeeper.util.documents.Document) modelDoc.get("object");

        addFormBlank(writer);
        documentPdf.setObjectList(modelDoc.get("model"));
        documentPdf.buildPdf(doc);
    }
}
