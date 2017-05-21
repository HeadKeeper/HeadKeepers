package com.headkeeper.util.documents.generate;

import com.headkeeper.bean.view.document_gen.ShortVacancyView;
import com.headkeeper.bean.view.document_gen.VacancyListView;
import com.headkeeper.util.documents.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.supercsv.io.ICsvBeanWriter;

import java.io.IOException;
import java.util.ArrayList;

public class Vacancies extends Document {

    private VacancyListView vacancyListView;

    @Override
    public void setObjectList(Object object) {
        this.vacancyListView = (VacancyListView) object;
    }

    @Override
    public void buildPdf(com.itextpdf.text.Document doc) throws DocumentException {
        try {
            BaseFont baseFont = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont);
            com.itextpdf.text.Font bold = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 14, com.itextpdf.text.Font.BOLD);

            ArrayList<ShortVacancyView> vacancies = this.vacancyListView.getVacancies();
            doc.add(new Paragraph("Vacancies statistic", bold));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Total vacancies: " + vacancies.size(), bold));
            doc.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(3);
            table.addCell(new PdfPCell(new Paragraph("Vacancy id")));
            table.addCell(new PdfPCell(new Paragraph("Title")));
            table.addCell(new PdfPCell(new Paragraph("User id")));
            for (ShortVacancyView vacancy : vacancies) {
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(vacancy.getId()))));
                table.addCell(new PdfPCell(new Paragraph(vacancy.getTitle(), font)));
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(vacancy.getUserId()), font)));
            }
            doc.add(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildXls(Workbook workbook) throws Exception {
        ArrayList<ShortVacancyView> vacancies = this.vacancyListView.getVacancies();
        Sheet sheet = workbook.createSheet("Vacancies");
        sheet.setDefaultColumnWidth(20);

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
        style.setWrapText(true);

        CellStyle headerStyle = workbook.createCellStyle();
        Font fontS = workbook.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        headerStyle.setBorderBottom(BorderStyle.MEDIUM);
        headerStyle.setFont(fontS);
        headerStyle.setWrapText(true);
        Row headerTitle = sheet.createRow(0);
        headerTitle.createCell(0).setCellValue("Vacancies statistic");;
        headerTitle.getCell(0).setCellStyle(headerStyle);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        Row header = sheet.createRow(1);
        header.createCell(0).setCellValue("Vacancy id");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Title");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("User id");
        header.getCell(2).setCellStyle(style);

        int rowCount = 2;

        CellStyle otherCellStyle = workbook.createCellStyle();
        otherCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        otherCellStyle.setWrapText(true);

        for (ShortVacancyView vacancy: vacancies) {

            Row commentRow = sheet.createRow(rowCount++);
            commentRow.createCell(0).setCellValue(String.valueOf(vacancy.getId()));
            commentRow.getCell(0).setCellStyle(otherCellStyle);
            commentRow.createCell(1).setCellValue(vacancy.getTitle());
            commentRow.getCell(1).setCellStyle(otherCellStyle);
            commentRow.createCell(2).setCellValue(String.valueOf(vacancy.getUserId()));
            commentRow.getCell(2).setCellStyle(otherCellStyle);
        }
    }

    @Override
    public void buildCsv(ICsvBeanWriter writer) throws IOException {
        String[] header = {"id","title"};

        writer.writeHeader(header);

        ArrayList<ShortVacancyView> vacancies = this.vacancyListView.getVacancies();
        for (ShortVacancyView vacancy : vacancies) {
            writer.write(new Vacancies.VacancyBean(String.valueOf(vacancy.getId()), vacancy.getTitle(), String.valueOf(vacancy.getUserId())), header);
        }
    }

    public class VacancyBean {

        private String id;
        private String title;
        private String userId;

        public VacancyBean(String id, String title, String userId) {
            this.id = id;
            this.title = title;
            this.userId = userId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
