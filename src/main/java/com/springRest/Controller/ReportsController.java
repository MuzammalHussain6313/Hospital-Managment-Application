//package com.springRest.Controller;
//
//import com.springRest.enitity.Doctor;
//import com.springRest.enitity.Medicine;
//import com.springRest.enitity.Patient;
//import com.springRest.pdfReportGenerater.GeneratePdfReport;
//import com.springRest.service.DoctorService;
//import com.springRest.service.MedicineService;
//import com.springRest.service.PatientService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.io.ByteArrayInputStream;
//import java.util.List;
//
//@Controller
//@RequestMapping("reports")
//public class ReportsController
//{
//    @Autowired
//    private PatientService patientService;
//
//    @Autowired
//    private DoctorService doctorService;
//
//    @Autowired
//    private MedicineService medicineService;
//
//    @RequestMapping(value = "/patient-report", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> patientReport()
//    {
//
//        List<Patient> patients = patientService.getAllPatients();
//
//        ByteArrayInputStream bis = GeneratePdfReport.patientReport(patients);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename = Patient-Report.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
//
//    @RequestMapping(value = "/doctor-report", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> doctorReport()
//    {
//
//        List<Doctor> doctors = doctorService.getAllDoctors();
//
//        ByteArrayInputStream bis = GeneratePdfReport.doctorReport(doctors);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename = Doctor-Report.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
//
//    @RequestMapping(value = "/medicine-report", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> medicineReport()
//    {
//
//        List<Medicine> medicines = medicineService.getAllmedicines();
//
//        ByteArrayInputStream bis = GeneratePdfReport.medicineReport(medicines);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename = Medicine-Report.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
//
////    @GetMapping("/doctor-report")
////    public String getDoctorReports()
////    {
////
////        return "report/doctor-report";
////    }
////
////    @GetMapping("/patient-report")
////    public String getPatientReports()
////    {
////        return "report/patient-report";
////    }
////
////    @GetMapping("/medicine-report")
////    public String getMedicineReports()
////    {
////        return "report/medicine-report";
////    }
//
//}
