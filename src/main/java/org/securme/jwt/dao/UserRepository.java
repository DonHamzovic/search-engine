package org.securme.jwt.dao;

import org.securme.jwt.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByUsername(String name);
}
