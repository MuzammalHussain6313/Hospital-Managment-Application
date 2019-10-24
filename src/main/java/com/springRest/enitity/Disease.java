package com.springRest.enitity;


//Committed in git.

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "disease")
public class Disease
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;
    @Column(name="disease_name")
    private String diseaseName;
    @Column(name="discription")
    private String discription;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "disease",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    public List<Doctor> doctors;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "patient_disease",
            joinColumns = @JoinColumn(name = "disease_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private List<Patient> patientList;

    public Disease()
    {
        // empty constructor.
    }
    public Disease(String name, String discription)
    {
        this.diseaseName = name;
        this.discription = discription;
    }


    public List<Doctor> getDoctors()
    {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors)
    {
        this.doctors = doctors;
    }

    public void addDoctor(Doctor doctor)
    {
        if(doctors == null)
        {
            doctors = new ArrayList<>();
        }
        doctors.add(doctor);
    }

    // conveniece method for medicines


    public void addPatient(Patient patient)
    {
        if(patientList == null)
        {
            patientList = new ArrayList<>();
        }
        patientList.add(patient);
    }
    public Disease(int id, String name, String discription)
    {
        this.Id = id;
        this.diseaseName = name;
        this.discription = discription;
    }

    // testiing to commit in git


    public String getDiseaseName()
    {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName)
    {
        this.diseaseName = diseaseName;
    }

    public String getDiscription()
    {
        return discription;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getId() {
        return Id;
    }

    public List<Patient> getPatientList()
    {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList)
    {
        this.patientList = patientList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.Id);
        hash = 79 * hash + Objects.hashCode(this.diseaseName);
        hash = 79 * hash + Objects.hashCode(this.discription);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disease other = (Disease) obj;
        if (this.discription != other.discription) {
            return false;
        }
        if (!Objects.equals(this.diseaseName, other.diseaseName)) {
            return false;
        }
        return Objects.equals(this.Id, other.Id);
    }

    @Override
    public String toString()
    {
        return "Id = " + Id +
                ", diseaseName = '" + diseaseName + '\'' +
                ", discription = '" + discription;
    }

    //    @Override
//    public String toString() {
//
//        var builder = new StringBuilder();
//        builder.append("City{id=").append(id).append(", name=")
//                .append(name).append(", population=")
//                .append(population).append("}");
//
//        return builder.toString();
//    }
}
