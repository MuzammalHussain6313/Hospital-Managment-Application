package com.springRest.DAO;

import com.springRest.enitity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicineRepository extends JpaRepository<Medicine, Integer>
{

}