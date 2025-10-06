package com.CodeSAM.SAM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CodeSAM.SAM.entity.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {


}

