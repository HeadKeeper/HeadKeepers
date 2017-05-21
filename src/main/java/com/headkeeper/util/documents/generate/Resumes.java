package com.headkeeper.util.documents.generate;

import com.headkeeper.bean.view.document_gen.ShortUserResumeView;
import com.headkeeper.bean.view.document_gen.UserResumesList;
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

public class Resumes extends Document {

    private UserResumesList userResumesList;

    @Override
    public void setObjectList(Object object) {
        userResumesList = (UserResumesList) object;
    }

    @Override
    public void buildPdf(com.itextpdf.text.Document doc) throws DocumentException {
        try {
            BaseFont baseFont = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont);
            com.itextpdf.text.Font bold = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 14, com.itextpdf.text.Font.BOLD);

            ArrayList<ShortUserResumeView> resumes = this.userResumesList.getResumes();
            doc.add(new Paragraph("Resumes statistic", bold));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Total resumes: " + resumes.size(), bold));
            doc.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(3);
            table.addCell(new PdfPCell(new Paragraph("Resume id")));
            table.addCell(new PdfPCell(new Paragraph("Last name")));
            table.addCell(new PdfPCell(new Paragraph("First name")));
            for (ShortUserResumeView resume : resumes) {
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(resume.getId()))));
                table.addCell(new PdfPCell(new Paragraph(resume.getFirstName(), font)));
                table.addCell(new PdfPCell(new Paragraph(resume.getLastName(), font)));
            }
            doc.add(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildXls(Workbook workbook) throws Exception {
        ArrayList<ShortUserResumeView> resumes = this.userResumesList.getResumes();
        Sheet sheet = workbook.createSheet("Resumes");
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
        headerTitle.createCell(0).setCellValue("Users statistic");;
        headerTitle.getCell(0).setCellStyle(headerStyle);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        Row header = sheet.createRow(1);
        header.createCell(0).setCellValue("Resume id");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("First name");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Last name");
        header.getCell(2).setCellStyle(style);

        int rowCount = 2;

        CellStyle otherCellStyle = workbook.createCellStyle();
        otherCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        otherCellStyle.setWrapText(true);

        for (ShortUserResumeView resume: resumes) {

            Row commentRow = sheet.createRow(rowCount++);
            commentRow.createCell(0).setCellValue(String.valueOf(resume.getId()));
            commentRow.getCell(0).setCellStyle(otherCellStyle);
            commentRow.createCell(1).setCellValue(resume.getFirstName());
            commentRow.getCell(1).setCellStyle(otherCellStyle);
            commentRow.createCell(2).setCellValue(resume.getLastName());
            commentRow.getCell(2).setCellStyle(otherCellStyle);
        }
    }

    @Override
    public void buildCsv(ICsvBeanWriter writer) throws IOException {
        String[] header = {"id","firstName","lastName"};

        writer.writeHeader(header);

        ArrayList<ShortUserResumeView> resumes = this.userResumesList.getResumes();
        for (ShortUserResumeView resume : resumes) {
            writer.write(new Resumes.ResumeBean(String.valueOf(resume.getId()), resume.getFirstName(), resume.getLastName()), header);
        }
    }

    public class ResumeBean {
        private String id;
        private String firstName;
        private String lastName;

        public ResumeBean(String id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
