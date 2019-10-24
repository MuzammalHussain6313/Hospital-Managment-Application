package com.springRest.service;

import com.springRest.DAO.PatientRepository;
import com.springRest.enitity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService
{
    private PatientRepository patientRepository;

    public PatientService()
    {
    }

    @Autowired
    public PatientService(PatientRepository patientRepository)
    {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients()
    {
        List<Patient> patientList = patientRepository.findAll();
        return patientList;
    }

    public void save(Patient patient)
    {
        patientRepository.save(patient);
    }

    public Patient findById(int id)
    {
        Patient newPatient =null;
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent())
        {
            newPatient = patient.get();
        }
        return newPatient;
    }


    public void deleteById(int id)
    {
        patientRepository.deleteById(id);
    }

//    public void updatePatient(Patient patient)
//    {
//        patientRepository.
//    }
}
