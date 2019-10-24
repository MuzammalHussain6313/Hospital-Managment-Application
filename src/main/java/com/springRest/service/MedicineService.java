package com.springRest.service;

import com.springRest.DAO.MedicineRepository;
import com.springRest.enitity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService
{
    private MedicineRepository medicineRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository)
    {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getAllmedicines()
    {
        List<Medicine> medicineList = medicineRepository.findAll();
        return medicineList;
    }


    public void save(Medicine medicine)
    {
        medicineRepository.save(medicine);
    }

    public Medicine findById(int id)
    {
        Medicine newmedicine =null;
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if(medicine.isPresent())
        {
            newmedicine = medicine.get();
        }
        return newmedicine;
    }


    public void deleteById(int id)
    {
        medicineRepository.deleteById(id);
    }

}
