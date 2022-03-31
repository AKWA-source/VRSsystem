package com.example.VRSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity                   
@Table(name="admin")
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long adminID;

    @Size(max = 50)
    @Column(nullable = false)
    private String name;

    @Size(max = 20)
    @Column(nullable = false)
    private String username;

    @Size(max = 15)
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column(nullable = false)
    private Long contact_no;

    @Size(max = 50)
    @Column(nullable = false)
    private String email;

    @Size(max = 50)
    @Column(nullable = false)
    private String zipcode;
    
    @Size(max = 100)
    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean active;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id", referencedColumnName = "id")       //declare the foreign key column
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AdminImages adminImages;



//    public AdminImages getAdminImages() {
//        return adminImages;
//    }

    public void setAdminImages(AdminImages adminImages) {
        this.adminImages = adminImages;
    }
}
