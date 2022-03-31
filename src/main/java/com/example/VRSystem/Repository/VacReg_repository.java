package com.example.VRSystem.Repository;

import java.sql.Date;
import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.VRSystem.Model.Vaccine_registration;

@Repository
public interface VacReg_repository extends JpaRepository<Vaccine_registration,Long> {
	
    @Transactional
    @Modifying
    @Query(value = "insert into vac_reg (registration_date, registration_time, clinic_address, dose_number, vac_centerid, userID, vac_regid) VALUES (:registration_date, :registration_time, :clinic_address, :dose_number, :vac_centerid, :userID, :vac_regid)", nativeQuery = true)
    void insertBooking(@Param("registration_date") Date registration_date, @Param("registration_time") Time registration_time, @Param("clinic_address") String clinic_address, @Param("dose_number") Long dose_number, @Param("vac_centerid") Long vac_centerid, @Param("userID") Long userID, @Param("vac_regid") Long vac_regid);

    
    @Transactional
    @Query(value = "SELECT COUNT(1) FROM vac_reg WHERE userID = :userID AND vac_regid = :vac_regid", nativeQuery = true)
    Integer isBookingExistByUserIDAndVacRegID(@Param("userID") Long userID, @Param("vac_regid") Long vac_regid);

    
//    2.	Each user cannot have multiple bookings on the same day.
//    Context User
//    inv:
//    self.R1.R2->forAll(vr1, vr2: Vaccine_registration | (vr1<>vr2 AND vr1.bookingID=vr2.bookingID) implies
//     vr1.registration_date <> vr2.registration_date AND
//     vr1.registration_time <> vr2.registration_time)

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM vac_reg WHERE userID = :userID AND vac_regid = :vac_regid AND  registration_date = :registration_date AND registration_time = :registration_time  ", nativeQuery = true)
    Integer isBookingExistByUserOnSameDay(@Param("userID") Long userID, @Param("vac_regid") Long vac_regid, @Param("registration_date") Date registration_date, @Param("registration_time") Time registration_time);


 @Modifying
 @Transactional
 @Query(value = "DELETE FROM vac_reg WHERE userID = :userID", nativeQuery = true)
 void deleteAllBookingsByUserID(@Param("userID") Long userID);


 @Modifying
 @Transactional
 @Query(value = "DELETE FROM vac_reg WHERE vac_regid = :vac_regid", nativeQuery = true)
 void deleteBookingByBookingID(@Param("vac_regid") Long vac_regid);
 
 @Transactional
 @Query(value = "SELECT COUNT(1) FROM vac_reg WHERE vac_regid = :vac_regid", nativeQuery = true)
 Integer isBookingExistByVacRegID(@Param("vac_regid") Long vac_regid);
 
 @Transactional
 @Modifying
 @Query(value = "UPDATE vac_reg SET registration_date = :registration_date, registration_time = :registration_time, clinic_address = :clinic_address, dose_number = :dose_number   WHERE vac_regid = :vac_regid", nativeQuery = true)
 void updateBookingDetails(@Param("registration_date") Date registration_date, @Param("registration_time") Time registration_time, @Param("clinic_address") String clinic_address, @Param("dose_number") Long dose_number , @Param("vac_regid") Long vac_regid );

}
