package com.example.server.repository;

import com.example.server.entity.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Long> {
}
