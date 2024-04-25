package org.Login.model.repositories;

import org.Login.model.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserLogin, Integer> {

}
