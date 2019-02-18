package com.usermanagement.app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where first_name = ?1 and last_name =" +
            " ?2 and dof = ?3",
            nativeQuery = true)
    User findByName(String firstName,
                    String lastName, Date dob);

    @Query(value = "select count(*) from users where first_name = ?1 and " +
            "last_name =" +
            " ?2 and dof = ?3",
            nativeQuery = true)
    Integer isUserExist(String firstName,
                        String lastName, String dob);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update users set email=?1 where id=?2", nativeQuery =
            true)
    void updateUserEmail(String email, long userId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update users set phone=?1 where id=?2", nativeQuery =
            true)
    void updateUserPhone(String phone, long userId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update users set email=?1 , phone=?2 where id=?3",
            nativeQuery =
                    true)
    void updateUserInfo(String email, String phone, long userId);
}


