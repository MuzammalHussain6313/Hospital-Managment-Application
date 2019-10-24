package com.springRest.DAO;

import com.springRest.enitity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{

}