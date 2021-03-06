package com.example.VRSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.VRSystem.Model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface User_repository  extends JpaRepository<User,Long> {

    @Transactional
    @Query(value = "SELECT userID, name, age, contact_no, email, city, zipcode, username, password FROM user", nativeQuery = true)
    List<UserColumnLimited> findAllUsers();

    @Transactional
    @Modifying
    @Query(value = "insert into user (name, username, password, age, city, zipcode, contact_no, email, active) VALUES (:name, :username, :password, :age, :city, :zipcode, :contact_no, :email, :active)", nativeQuery = true)
    void insertUser(@Param("name") String name, @Param("username") String username, @Param("password") String password,
                    @Param("age") Integer age, @Param("city") String city,@Param("zipcode") String zipcode, @Param("contact_no") String contact_no,
                    @Param("email") String email, @Param("active") Boolean active);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET password = :password WHERE userID = :userID", nativeQuery = true)
    void updateUserPassword(@Param("password") String password, @Param("userID") Long userID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET active = :active WHERE userID = :userID", nativeQuery = true)
    void updateUserActiveStatus(@Param("active") Boolean active, @Param("userID") Long userID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET id = :id WHERE userID = :userID", nativeQuery = true)
    void updateImageIDByUserID(@Param("id") Long id, @Param("userID") Long userID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET name = :name, age = :age, city = :city, zipcode = :zipcode,contact_no = :contact_no, email = :email WHERE userID = :userID", nativeQuery = true)
    void updateUserDetails(@Param("name") String name, @Param("age") Integer age, @Param("city") String city, @Param("zipcode") String zipcode, @Param("contact_no") String contact_no, @Param("email") String email, @Param("userID") Long userID);

    @Transactional
    @Query(value = "SELECT userID, name, age, contact_no, email, city, zipcode active FROM user WHERE userID = :userID", nativeQuery = true)
    Optional<UserColumnLimited> findByUserID(@Param("userID") Long userID);

    @Transactional
    @Query(value = "SELECT userID FROM user WHERE username = :username", nativeQuery = true)
    Long findByUsername(@Param("username") String username);

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM user WHERE userID = :userID", nativeQuery = true)
    Integer isUserExistByUserID(@Param("userID") Long userID);

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM user WHERE email = :email", nativeQuery = true)
    Integer isUserExistByEmail(@Param("email") String email);

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM user WHERE username = :username", nativeQuery = true)
    Integer isUserExistByUsername(@Param("username") String username);

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM user WHERE userID = :userID AND password = :password", nativeQuery = true)
    Integer isUserExistByUserIDAndPassword(@Param("userID") Long userID, @Param("password") String password);

    @Transactional
    @Query(value = "SELECT COUNT(1) FROM user WHERE username = :username AND password = :password", nativeQuery = true)
    Integer isUserExistByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user WHERE userID = :userID", nativeQuery = true)
    void deleteByUserID(@Param("userID") Long userID);
}