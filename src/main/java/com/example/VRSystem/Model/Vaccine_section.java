package com.example.VRSystem.Model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity                   
@Table(name="vac_sec")
@Getter
@Setter
public class Vaccine_section {
	
	   @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long vac_secid;
	    
	    @Size(max = 50)
	    @Column(nullable = false)
	    private String vac_name;
	    
	    @Size(max = 50)
	    @Column(nullable = false)
	    private boolean availability;
	    
	    @Size(max = 50)
	    @Column(nullable = false)
	    private String description;
	    
	    @Size(max = 50)
	    @Column(nullable = false)
	    private String vac_type;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "vac_regid", referencedColumnName = "vac_regid", nullable=false, updatable=false,insertable=false)       //declare the foreign key column
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Vaccine_registration vacc_reg;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "userID", referencedColumnName = "userID", nullable=false, updatable=false,insertable=false)       //declare the foreign key column
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private User user;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "inventoryid", referencedColumnName = "inventoryid", nullable=false, updatable=false,insertable=false)       //declare the foreign key column
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Inventory inventory;

}
