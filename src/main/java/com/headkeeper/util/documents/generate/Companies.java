package com.headkeeper.util.documents.generate;

import com.headkeeper.bean.view.document_gen.CompanyListView;
import com.headkeeper.bean.view.document_gen.ShortCompanyInfoView;
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

public class Companies extends Document {

    private CompanyListView companiesListView;

    @Override
    public void setObjectList(Object object) {
        this.companiesListView = (CompanyListView) object;
    }

    @Override
    public void buildPdf(com.itextpdf.text.Document doc) throws DocumentException {
        try {
            BaseFont baseFont = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont);
            com.itextpdf.text.Font bold = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 14, com.itextpdf.text.Font.BOLD);

            ArrayList<ShortCompanyInfoView> companies = this.companiesListView.getCompanies();
            doc.add(new Paragraph("Companies statistic", bold));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Total companies: " + companies.size(), bold));
            doc.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(3);
            table.addCell(new PdfPCell(new Paragraph("Company id")));
            table.addCell(new PdfPCell(new Paragraph("Name")));
            table.addCell(new PdfPCell(new Paragraph("Address")));
            for (ShortCompanyInfoView company : companies) {
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(company.getId()))));
                table.addCell(new PdfPCell(new Paragraph(company.getName(), font)));
                table.addCell(new PdfPCell(new Paragraph(company.getAddress(), font)));
            }
            doc.add(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildXls(Workbook workbook) throws Exception {
        ArrayList<ShortCompanyInfoView> companies = this.companiesListView.getCompanies();
        Sheet sheet = workbook.createSheet("Companies");
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
        headerTitle.createCell(0).setCellValue("Company statistic");;
        headerTitle.getCell(0).setCellStyle(headerStyle);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));

        Row header = sheet.createRow(1);
        header.createCell(0).setCellValue("Company id");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Comapny name");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Company address");
        header.getCell(2).setCellStyle(style);

        int rowCount = 2;

        CellStyle otherCellStyle = workbook.createCellStyle();
        otherCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        otherCellStyle.setWrapText(true);

        for (ShortCompanyInfoView company: companies) {

            Row commentRow = sheet.createRow(rowCount++);
            commentRow.createCell(0).setCellValue(String.valueOf(company.getId()));
            commentRow.getCell(0).setCellStyle(otherCellStyle);
            commentRow.createCell(1).setCellValue(company.getName());
            commentRow.getCell(1).setCellStyle(otherCellStyle);
            commentRow.createCell(2).setCellValue(company.getAddress());
            commentRow.getCell(2).setCellStyle(otherCellStyle);
        }
    }

    @Override
    public void buildCsv(ICsvBeanWriter writer) throws IOException {
        String[] header = {"id","name","address"};

        writer.writeHeader(header);

        ArrayList<ShortCompanyInfoView> companies = this.companiesListView.getCompanies();
        for (ShortCompanyInfoView company : companies) {
            writer.write(new Companies.CompanyBean(String.valueOf(company.getId()), company.getName(), company.getAddress()), header);
        }
    }

    public class CompanyBean {
        private String id;
        private String name;
        private String address;

        public CompanyBean(String id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
