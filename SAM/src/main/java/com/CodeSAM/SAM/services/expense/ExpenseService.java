package com.CodeSAM.SAM.services.expense;

import org.springframework.stereotype.Service;

import com.CodeSAM.SAM.dto.ExpenseDTO;
import com.CodeSAM.SAM.entity.Expense;

/* Defines business logic component and acts as itermeidary between the presentation (controller) and data layer (repository)*/
@Service
public interface ExpenseService {
    Expense postExpense(ExpenseDTO expenseDTO);
    
}
