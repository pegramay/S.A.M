package com.CodeSAM.SAM.services.expense;

import org.springframework.stereotype.Service;

import com.CodeSAM.SAM.dto.ExpenseDTO;
import com.CodeSAM.SAM.entity.Expense;
import com.CodeSAM.SAM.repository.ExpenseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceimpl implements ExpenseService{
    private final ExpenseRepository expenseRepository; //Injecting expense repository

    public Expense postExpense(ExpenseDTO expenseDTO){
        return saveOrUpdateExpense(new Expense(), expenseDTO);
    }
    private Expense saveOrUpdateExpense(Expense expense, ExpenseDTO expenseDTO) {
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());
        return expenseRepository.save(expense); 
    }
}
