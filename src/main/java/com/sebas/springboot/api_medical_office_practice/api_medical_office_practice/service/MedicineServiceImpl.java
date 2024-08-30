package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Medicine;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService{

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    @Override
    public Optional<Medicine> findById(Long id) {
        return medicineRepository.findById(id);
    }

    @Transactional
    @Override
    public Medicine save(Medicine medicine) {

        medicine.setCode(createCode(medicine.getName(), "sa"));

        return medicineRepository.save(medicine);
    }

    @Transactional
    @Override
    public Optional<Medicine> update(Medicine medicine, Long id) {
        
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);

        if(optionalMedicine.isPresent()){
            Medicine medicineDb = optionalMedicine.orElseThrow();
            medicineDb.setName(medicine.getName());
            medicineDb.setCode(createCode(medicine.getName(), "up"));

            medicineRepository.save(medicineDb);
        }

        return optionalMedicine;
    }

    private String createCode (String nameMedicine, String svup){

        int numberSeq = medicineRepository.findAll().size();
        if(svup != "up") numberSeq += 1;
        String code = nameMedicine.substring(0, 3) + numberSeq;

        return code;
    }

}
