package com.CodeSAM.SAM.entity;

import java.time.LocalDate;

import com.CodeSAM.SAM.dto.IncomeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id;
import lombok.Data;

//** Entity represents a table in database */
@Entity
@Data
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer amount;
    private LocalDate date;
    private String category;
    private String description;

    /*Convert an income entity object into a incomeDTO object 
    
    Provides a way to map the database entity (table) to a DTO to use in 
    api responses or service layer*/ 
    public IncomeDTO getIncomeDTO(){
        IncomeDTO incomeDTO = new IncomeDTO();
        incomeDTO.setId(id);
        incomeDTO.setTitle(title);
        incomeDTO.setAmount(amount);
        incomeDTO.setCategory(category);
        incomeDTO.setDescription(description);
        incomeDTO.setDate(date);
        return incomeDTO;

    }
}
