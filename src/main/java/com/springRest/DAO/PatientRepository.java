package com.springRest.DAO;

import com.springRest.enitity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Integer>
{

}