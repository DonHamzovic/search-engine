package org.securme.jwt.dao;

import org.securme.jwt.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AppRole,Long> {


       AppRole findByRolename(String name);

}
