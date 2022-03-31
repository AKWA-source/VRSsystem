package com.example.VRSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.VRSystem.Model.Vaccination_center;

@Repository
public interface VacCentre_repository extends JpaRepository<Vaccination_center,Long> {

}
