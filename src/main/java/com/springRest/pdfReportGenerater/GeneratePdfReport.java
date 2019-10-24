//package com.springRest.pdfReportGenerater;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.springRest.enitity.Doctor;
//import com.springRest.enitity.Medicine;
//import com.springRest.enitity.Patient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.util.List;
//
//public class GeneratePdfReport
//{
//
//    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);
//
//    public static ByteArrayInputStream medicineReport(List<Medicine> medicines)
//    {
//        Document document = new Document();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try
//        {
//
//            PdfPTable table = new PdfPTable(6);
//            table.setWidthPercentage(90);
//            table.setWidths(new int[]{1, 3, 3, 2, 2, 2});
//
//            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//
//            PdfPCell hcell;
//            hcell = new PdfPCell(new Phrase("Id", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Name", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Company", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Manufacture Date", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Expiry Date", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Type", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            for (Medicine medicine : medicines)
//            {
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Phrase(medicine.getId()));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(medicine.getName()));
//                cell.setPaddingLeft(5);
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(medicine.getCompanyName())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(medicine.getManufactureDate())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(medicine.getExpiryDate())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(medicine.getType())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//            }
//
//            PdfWriter.getInstance(document, out);
//            document.open();
//            document.add(table);
//
//            document.close();
//
//        } catch (DocumentException ex)
//        {
//
//            logger.error("Error occurred: {0}", ex);
//        }
//
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//
//
//    public static ByteArrayInputStream doctorReport(List<Doctor> doctors)
//    {
//        Document document = new Document();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try
//        {
//
//            PdfPTable table = new PdfPTable(6);
//            table.setWidthPercentage(90);
//            table.setWidths(new int[]{1, 3, 2, 3, 3, 3});
//
//            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//
//            PdfPCell hcell;
//            hcell = new PdfPCell(new Phrase("ID", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Name", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("gender", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("CNIC", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Email", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Spacialization", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            for (Doctor doctor : doctors)
//            {
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Phrase(doctor.getId()));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(doctor.getName()));
//                cell.setPaddingLeft(5);
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(doctor.getGender())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(doctor.getCnic())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(doctor.getEmail())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(doctor.getDisease().getDiseaseName())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//            }
//
//            PdfWriter.getInstance(document, out);
//            document.open();
//            document.add(table);
//
//            document.close();
//
//        } catch (DocumentException ex)
//        {
//
//            logger.error("Error occurred: {0}", ex);
//        }
//
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//
//    public static ByteArrayInputStream patientReport(List<Patient> patients)
//    {
//        Document document = new Document();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try
//        {
//
//            PdfPTable table = new PdfPTable(6);
//            table.setWidthPercentage(90);
//            table.setWidths(new int[]{1, 3, 3, 3, 2, 2});
//
//            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//
//            PdfPCell hcell;
//            hcell = new PdfPCell(new Phrase("ID", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Name", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("father Name", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Gender", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Date Of Birth", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("doctor Name", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            for (Patient patient : patients)
//            {
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Phrase(patient.getId()));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(patient.getName()));
//                cell.setPaddingLeft(5);
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(patient.getFatherName())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(patient.getGender())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(patient.getDateOfBirth())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(patient.getDoctor().getName())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//            }
//
//            PdfWriter.getInstance(document, out);
//            document.open();
//            document.add(table);
//
//            document.close();
//
//        } catch (DocumentException ex)
//        {
//
//            logger.error("Error occurred: {0}", ex);
//        }
//
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//}