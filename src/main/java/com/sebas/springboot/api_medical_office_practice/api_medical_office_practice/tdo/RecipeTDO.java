package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.tdo;

import java.util.List;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Medicine;

public class RecipeTDO {

    private String diagnosis;
    private Long doctor_id;
    private Long patient_id;
    private List<Medicine> medicines;
    
    public RecipeTDO() {
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "RecipeTDO [diagnosis=" + diagnosis + ", doctor_id=" + doctor_id + ", patient_id=" + patient_id
                + ", medicines=" + medicines + "]";
    }

    
}
