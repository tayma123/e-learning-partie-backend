package com.example.demo.tayma.Entities;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

public class UserPDFExporter {
    private List<User1> listUsers;

    public UserPDFExporter(List<User1> listUsers) {
        this.listUsers = listUsers;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);

        com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);

        cell.setPhrase(new Phrase("User ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Full Name", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) {
        for (User1 user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getUserName());
            table.addCell(user.getLastName());
           ;
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        ((com.itextpdf.text.Font)
                font).setSize(18);


        Paragraph p = new Paragraph("Certificate", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        Paragraph p1= new Paragraph("This is to certify that", font);
        document.add(p1);
        Paragraph p2= new Paragraph("has successfully completed the", font);
        document.add(p2);



        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}

