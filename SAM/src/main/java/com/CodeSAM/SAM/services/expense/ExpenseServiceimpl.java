package com.CodeSAM.SAM.services.expense;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.CodeSAM.SAM.dto.ExpenseDTO;
import com.CodeSAM.SAM.entity.Expense;
import com.CodeSAM.SAM.repository.ExpenseRepository;

import jakarta.persistence.EntityNotFoundException;
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

    /** Will Update values within an expense if it is currently present in the table */
    public Expense updateExpense(Long id, ExpenseDTO expenseDTO){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return saveOrUpdateExpense(optionalExpense.get(), expenseDTO);
        }
        else {
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }
    /**
     * Get all expenses sorted by date in descending order
     * @return List of expenses sorted by date in descending order
     */
    public List<Expense> getAllExpenses(){
        System.out.println("Fetching all expenses");
        return expenseRepository.findAll().stream()
        .sorted(Comparator.comparing(Expense::getDate).reversed())
        .collect(Collectors.toList());
    }

    /** Returns an expense */
    public Expense getExpenseById(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return optionalExpense.get();
        }
        else{
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }
}
