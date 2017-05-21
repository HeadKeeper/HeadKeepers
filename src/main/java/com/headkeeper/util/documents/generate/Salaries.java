package com.headkeeper.util.documents.generate;


import com.headkeeper.bean.view.document_gen.SalaryListView;
import com.headkeeper.bean.view.document_gen.ShortSalaryView;
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

public class Salaries extends Document {

    private SalaryListView salaryListView;

    @Override
    public void setObjectList(Object object) {
        this.salaryListView = (SalaryListView) object;
    }

    @Override
    public void buildPdf(com.itextpdf.text.Document doc) throws DocumentException {
        try {
            BaseFont baseFont = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont);
            com.itextpdf.text.Font bold = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 14, com.itextpdf.text.Font.BOLD);

            ArrayList<ShortSalaryView> salaries = this.salaryListView.getSalaries();
            doc.add(new Paragraph("Salaries statistic", bold));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Total salaries: " + salaries.size(), bold));
            doc.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(3);
            table.addCell(new PdfPCell(new Paragraph("Vacancy id")));
            table.addCell(new PdfPCell(new Paragraph("Min salary")));
            table.addCell(new PdfPCell(new Paragraph("Max Salary")));
            for (ShortSalaryView salary  : salaries) {
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(salary.getVacancyId()), font)));
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(salary.getMinSalary()), font)));
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(salary.getMaxSalary()), font)));
            }
            doc.add(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildXls(Workbook workbook) throws Exception {
        ArrayList<ShortSalaryView> salaries = this.salaryListView.getSalaries();
        Sheet sheet = workbook.createSheet("Salaries");
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
        headerTitle.createCell(0).setCellValue("Salary statistic");;
        headerTitle.getCell(0).setCellStyle(headerStyle);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        Row header = sheet.createRow(1);
        header.createCell(0).setCellValue("Vacancy id");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Min Salary");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Max Salary");
        header.getCell(2).setCellStyle(style);

        int rowCount = 2;

        CellStyle otherCellStyle = workbook.createCellStyle();
        otherCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        otherCellStyle.setWrapText(true);

        for (ShortSalaryView salary: salaries) {

            Row commentRow = sheet.createRow(rowCount++);
            commentRow.createCell(0).setCellValue(String.valueOf(salary.getVacancyId()));
            commentRow.getCell(0).setCellStyle(otherCellStyle);
            commentRow.createCell(1).setCellValue(String.valueOf(salary.getMinSalary()));
            commentRow.getCell(1).setCellStyle(otherCellStyle);
            commentRow.createCell(2).setCellValue(String.valueOf(salary.getMaxSalary()));
            commentRow.getCell(2).setCellStyle(otherCellStyle);
        }
    }

    @Override
    public void buildCsv(ICsvBeanWriter writer) throws IOException {
        String[] header = {"vacancyId","minSalary","maxSalary"};

        writer.writeHeader(header);

        ArrayList<ShortSalaryView> salaries = this.salaryListView.getSalaries();
        for (ShortSalaryView salary : salaries) {
            writer.write(new Salaries.SalaryBean(String.valueOf(salary.getVacancyId()), String.valueOf(salary.getMinSalary()), String.valueOf(salary.getMaxSalary())), header);
        }
    }

    public class SalaryBean {

        public SalaryBean(String vacancyId, String minSalary, String maxSalary) {
            this.vacancyId = vacancyId;
            this.minSalary = minSalary;
            this.maxSalary = maxSalary;
        }

        private String vacancyId;
        private String minSalary;
        private String maxSalary;

        public String getVacancyId() {
            return vacancyId;
        }

        public void setVacancyId(String vacancyId) {
            this.vacancyId = vacancyId;
        }

        public String getMinSalary() {
            return minSalary;
        }

        public void setMinSalary(String minSalary) {
            this.minSalary = minSalary;
        }

        public String getMaxSalary() {
            return maxSalary;
        }

        public void setMaxSalary(String maxSalary) {
            this.maxSalary = maxSalary;
        }
    }
}
