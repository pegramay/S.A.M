package com.CodeSAM.SAM.repository;

import com.CodeSAM.SAM.entity.Expense;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


/*Core component in data access abstracting and simplifying database interactions 
    Manages data peristence and retrieval for specific entities within an application
 */
@Repository 
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
} 
