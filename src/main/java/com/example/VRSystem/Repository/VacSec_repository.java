package com.example.VRSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.VRSystem.Model.Vaccine_section;

@Repository
public interface VacSec_repository extends JpaRepository<Vaccine_section,Long> {

}
