package com.springRest.enitity;

//Committed in git.

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "medicine")
public class Medicine
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="medicine_name")
    private String medicineName;
    @Column(name="company_name")
    private String companyName;
    @Column(name="manufacture_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufactureDate;
    @Column(name="expiry_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;
    @Column(name = "type")
    private String type;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH,CascadeType.MERGE,
                           CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "patient_medicine",
               joinColumns = @JoinColumn(name = "medicine_id"),
               inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private List<Patient> patientList;

    public List<Patient> getPatientList()
    {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList)
    {
        this.patientList = patientList;
    }

    // convenience method
    public void addPatient(Patient patient)
    {
        if(patientList==null)
        {
            patientList=new ArrayList<>();
        }
        patientList.add(patient);
    }
    public Medicine()
    {
        // no-arg constructor.
    }

    public Medicine(String name, String companyName, Date manufactureDate, Date expiryDate,String type)
    {
        this.medicineName = name;
        this.companyName = companyName;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return medicineName;
    }

    public void setName(String name)
    {
        this.medicineName = name;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public Date getManufactureDate()
    {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate)
    {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString()
    {
        return "Medicine{" +
                "id=" + id +
                ", name='" + medicineName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
