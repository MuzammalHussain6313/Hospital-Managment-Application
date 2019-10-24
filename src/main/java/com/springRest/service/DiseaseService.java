package com.springRest.service;

import com.springRest.DAO.DiseaseRepository;
import com.springRest.DAO.PatientRepository;
import com.springRest.enitity.Disease;
import com.springRest.enitity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiseaseService
{
    private DiseaseRepository diseaseRepository;

    @Autowired
    public DiseaseService(DiseaseRepository diseaseRepository)
    {
        this.diseaseRepository = diseaseRepository;
    }



    public List<Disease> getAllDiseases()
    {
        List<Disease> diseaseList = diseaseRepository.findAll();
        return diseaseList;
    }

    public void save(Disease disease)
    {
        diseaseRepository.save(disease);
    }

    public Disease findById(int id)
    {
        Disease newDisease =null;
        Optional<Disease> disease = diseaseRepository.findById(id);
        if(disease.isPresent())
        {
            newDisease = disease.get();
        }
        return newDisease;
    }


    public void deleteById(int id)
    {
        diseaseRepository.deleteById(id);
    }

}
