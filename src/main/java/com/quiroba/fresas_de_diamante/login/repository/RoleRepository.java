package com.quiroba.fresas_de_diamante.login.repository;

import com.quiroba.fresas_de_diamante.login.models.ERole;
import com.quiroba.fresas_de_diamante.login.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
