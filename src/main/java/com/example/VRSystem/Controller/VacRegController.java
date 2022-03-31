package com.example.VRSystem.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.VRSystem.Model.Vaccine_registration;
import com.example.VRSystem.Repository.User_repository;
import com.example.VRSystem.Repository.VacReg_repository;

@CrossOrigin(origins = {"http://localhost:8081"})   
@RestController
@RequestMapping(path="/Project/REST-API")
public class VacRegController {
	
	@Autowired
	private VacReg_repository vacreg_repository;
	
	   @Autowired
	   private User_repository user_repository;
	

//	   4.	Calling addBooking() method of the class Vaccine_registration adds a booking to a User. The booking is only added if it does not already exist.
//	   Context Vaccine_registration::addBooking(u: User): void
//	   pre: self.R1->excludes(u)
//	   post: self.R1->includes(u)

    @Transactional
    @PostMapping("/addbooking/{userID}/{vac_regid}")
    @ResponseBody
    public String addBooking(@PathVariable("userID") long userid,
            @PathVariable("vac_regid") long vac_regid, @Valid  @RequestBody Vaccine_registration vaccine_reg) {
    	       if(vacreg_repository.isBookingExistByUserOnSameDay(userid, vac_regid, vaccine_reg.getRegistration_date(),vaccine_reg.getRegistration_time())!=1){
    	              return user_repository.findByUserID(userid).map(user -> { vacreg_repository.insertBooking(vaccine_reg.getRegistration_date(), vaccine_reg.getRegistration_time(),vaccine_reg.getClinic_address(), vaccine_reg.getDose_number(), vaccine_reg.getVac_centerid(),userid, vac_regid);
                return "Booked Successful";
                         }).orElseThrow(() -> new ResourceNotFoundException("UserID " + userid + " not found"));
    }
		      return "Booking already exits for a given date and time";
    }
    
//    5.	Calling deleteBooking() method of the class Vaccine_registration cancels a booking to a User. The booking is only cancelled if it already exists.
//    Context Vaccine_registration::deleteBooking(u: User): void
//    pre: self.R1->includes(u)
//    post: self.R1->excludes(u)

    @Transactional
    @DeleteMapping(value="/user/{userID}/deletebooking/{vac_regid}")
    public String deleteUserBooking(@PathVariable("userID") long userID, @PathVariable("vac_regid") long vac_regid) {
        if(vacreg_repository.isBookingExistByUserIDAndVacRegID(userID, vac_regid) == 1) {
        	vacreg_repository.deleteBookingByBookingID(vac_regid);
            return "Booking Cancelled Successfully";
        }
        return "This booking does not belongs to this user";
    }
    
//    6.	Calling updateBooking() method of the class Vaccine_registration updates a booking to a User. The booking is only updated if it already exists.
//    Context Vaccine_registration::updateBooking(u: User): void
//    pre: self.R1->includes(u)
//    post: self.R1->bookingID=bookingID@pre AND registration_date<>registration_date@pre AND registration_time<>registration_time@pre

 @Transactional
 @PutMapping("updatebooking/{vac_regid}")
 public String updateBooking(@PathVariable long vac_regid, @Valid @RequestBody Vaccine_registration vacc_regis) {
     if(vacreg_repository.isBookingExistByVacRegID(vac_regid) == 1) {
    	 vacreg_repository.updateBookingDetails(vacc_regis.getRegistration_date(), vacc_regis.getRegistration_time(), vacc_regis.getClinic_address(), vacc_regis.getDose_number(), vac_regid);
         return "Update successful";
     }
    return "Vacc Reg " + vac_regid + " not found";
 }
//    
    
    
    
    }


