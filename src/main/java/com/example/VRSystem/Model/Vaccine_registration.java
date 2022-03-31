package com.example.VRSystem.Model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity                   
@Table(name="vac_reg")
@Getter
@Setter
public class Vaccine_registration {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long vac_regid;
    
    @NotNull
    @Column(nullable = false)
    private Time registration_time;
    
    @NotNull
    @Column(nullable = false)
    private Date registration_date;
    
    @Size(max = 50)
    @Column(nullable = false)
    private String clinic_address;
    
 
    @Range(min=0, max=90)
    @Column(nullable = false)
    private Long dose_number;
    

    @JoinColumn(name = "userID", referencedColumnName = "userID", nullable=false, updatable=false,insertable=false)       //declare the foreign key column
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Long userID;
    
    
   
    @JoinColumn(name = "vac_centerid", referencedColumnName = "vac_centerid", nullable=false, updatable=false,insertable=false)       //declare the foreign key column
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Long vac_centerid;

}
