package org.example.repository;

import org.example.DTO.request.RegisterRequestDTO;
import org.example.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,Long> {

}
