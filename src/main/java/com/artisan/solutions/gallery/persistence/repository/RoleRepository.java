package com.artisan.solutions.gallery.persistence.repository;

import com.artisan.solutions.gallery.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
