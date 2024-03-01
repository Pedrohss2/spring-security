package com.pedro.demo.repositories;

import com.pedro.demo.entities.User;
import com.pedro.demo.projection.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT tb_user.email AS username, tb_user.password, tb_role.id AS roleid, tb_role.authority FROM tb_user " +
            "    INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id " +
            "    INNER JOIN tb_role ON tb_role.id = tb_user.id " +
            "    WHERE tb_user.email = :email ")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

}
