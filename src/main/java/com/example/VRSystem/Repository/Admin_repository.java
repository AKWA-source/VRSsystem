package com.example.VRSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.VRSystem.Model.Admin;

import java.util.Optional;

@Repository
public interface Admin_repository extends JpaRepository<Admin,Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into admin (name, username, password, city, zipcode, contact_no, email, active) VALUES (:name, :username, :password, :city, :zipcode, :contact_no, :email, :active)", nativeQuery = true)
    void insertAdmin(@Param("name") String name, @Param("username") String username, @Param("password") String password,
                     @Param("city") String city, @Param("zipcode") String zipcode, @Param("contact_no") Long contact_no,
                     @Param("email") String email, @Param("active") Boolean active);

    @Transactional
    @Modifying
    @Query(value = "UPDATE admin SET active = :active WHERE adminID = :adminID", nativeQuery = true)
    void updateAdminActiveStatus(@Param("active") Boolean active, @Param("adminID") Long adminID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE admin SET password = :password WHERE adminID = :adminID", nativeQuery = true)
    void updateAdminPassword(@Param("password") String password, @Param("adminID") Long adminID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE admin SET id = :id WHERE adminID = :adminID", nativeQuery = true)
    void updateImageIDByAdminID(@Param("id") Long id, @Param("adminID") Long adminID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE admin SET name = :name, city = :city, zipcode = :zipcode, contact_no = :contact_no, email = :email WHERE adminID = :adminID", nativeQuery = true)
    void updateAdminDetails(@Param("name") String name, @Param("city") String city, @Param("zipcode") String zipcode, @Param("contact_no") Long contact_no, @Param("email") String email, @Param("adminID") Long adminID);

    @Transactional
    @Query(value = "SELECT adminID, name, contact_no, email, zipcode, city, active FROM admin WHERE adminID = :adminID", nativeQuery = true)
    Optional<AdminColumnLimited> findByAdminID(@Param("adminID") Long adminID);

    @Transactional
    @Query(value = "SELECT adminID FROM admin WHERE username = :username", nativeQuery = true)
    Long findByUsername(@Param("username") String username);

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM admin WHERE adminID = :adminID", nativeQuery = true)
    Integer isAdminExistByAdminID(@Param("adminID") Long adminID);

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM admin WHERE adminID = :adminID AND password = :password", nativeQuery = true)
    Integer isAdminExistByAdminIDAndPassword(@Param("adminID") Long adminID, @Param("password") String password);

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM admin WHERE email = :email", nativeQuery = true)
    Integer isAdminExistByEmail(@Param("email") String email);

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM admin WHERE username = :username", nativeQuery = true)
    Integer isAdminExistByUsername(@Param("username") String username);

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM admin WHERE username = :username AND password = :password", nativeQuery = true)
    Integer isAdminExistByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
