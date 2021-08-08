package com.example.demo.tayma.Services;


import com.example.demo.tayma.Repository.CertificatRepo;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class ExportService {
    @Autowired
    CertificatRepo certificatRepo;
    public static ByteArrayInputStream PDFReport(String firstName,String lastName) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);

            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            ((com.itextpdf.text.Font)
                    font).setSize(18);
            Paragraph p = new Paragraph("Certificate", font);
            p.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(p);
            Paragraph p1= new Paragraph("This is to certify that", font);
            document.add(p1);
            Phrase para2= new Phrase(firstName+" "+lastName);
            document.add(para2);

            Paragraph p2= new Paragraph("has successfully completed the", font);
            document.add(p2);
            PdfPTable table = new PdfPTable(2);


            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
return new ByteArrayInputStream(out.toByteArray());

    }


}