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
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity                   
@Table(name="vac_center")
@Getter
@Setter
public class Vaccination_center {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long vac_centerid;
    
    @Size(max = 50)
    @Column(nullable = false)
    private Time opentime;
    
    @Size(max = 50)
    @Column(nullable = false)
    private Time closetime;
    
    @Size(max = 50)
    @Column(nullable = false)
    private String center_address;
    
    
//    7.	The vaccines count should always be more than 10.
//    Context Vaccination_center
//    inv: self.vaccCount-> size()>=10

    @Range(min=10, max=100)
    @Column(nullable = false)
    private Long vac_count;
    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventoryid", referencedColumnName = "inventoryid", nullable=false, updatable=false,insertable=false)       //declare the foreign key column
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Inventory inventory;
    
	
	

}
