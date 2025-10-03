package com.CodeSAM.SAM.services.expense;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CodeSAM.SAM.dto.ExpenseDTO;
import com.CodeSAM.SAM.entity.Expense;

/* Defines business logic component and acts as itermeidary between the presentation (controller) and data layer (repository)*/
@Service
public interface ExpenseService {
    Expense postExpense(ExpenseDTO expenseDTO);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Long id, ExpenseDTO expenseDTO);
}
