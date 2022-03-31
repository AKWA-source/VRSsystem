package com.example.VRSystem.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity                   
@Table(name="inventory")
@Getter
@Setter
public class Inventory {
	
	   @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long inventoryid;

	    @Size(max = 50)
	    @Column(nullable = false)
	    private Date purchase_date;
	    
	    @Size(max = 50)
	    @Column(nullable = false)
	    private int no_of_vac;
	    
	    @Size(max = 50)
	    @Column(nullable = false)
	    private String type_of_vac;
	    
	    
	    
	    

}
