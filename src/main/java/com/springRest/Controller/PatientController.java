package com.springRest.Controller;

import java.util.List;
import java.util.stream.Collectors;

import com.springRest.enitity.Disease;
import com.springRest.enitity.Doctor;
import com.springRest.enitity.Patient;
import com.springRest.service.DiseaseService;
import com.springRest.service.DoctorService;
import com.springRest.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;


@Controller
@RequestMapping("/patients")
public class PatientController
{

    // load employee data
    private PatientService patientService;
    private DoctorService doctorService;
    private DiseaseService diseaseService;
    private List<Patient> thePatients;
    @Autowired
    private EntityManager em;

    public PatientController(PatientService patientService, DoctorService doctorService, DiseaseService diseaseService)
    {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.diseaseService = diseaseService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        thePatients = patientService.getAllPatients();
        theModel.addAttribute("patients", thePatients);
        return "patients/list-patients";
    }

    @GetMapping("/addPatient")
    public String getPatientForm(Model model)
    {
        Patient patient = new Patient();
        model.addAttribute("doctorList",doctorService.getAllDoctors());
        model.addAttribute("patient",patient);
        return "patients/addPatient";
    }

    @PostMapping("/save")
    public String savePatient(@ModelAttribute("patient") Patient thePatient)
    {

        patientService.save(thePatient);
        return "redirect:/patients/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("patientId") int theID,Model model)
    {
        Patient patient = patientService.findById(theID);
        model.addAttribute("doctorList",doctorService.getAllDoctors());
        model.addAttribute("patient",patient);
        return "patients/addPatient";
    }

    @GetMapping("/delete")
    public String deletePatient(@RequestParam("patientId") int theID)
    {
        patientService.deleteById(theID);
        return "redirect:/patients/list";
    }

}









