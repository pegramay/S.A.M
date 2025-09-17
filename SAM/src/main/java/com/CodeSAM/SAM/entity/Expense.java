package com.CodeSAM.SAM.entity;

import java.time.LocalDate;

/* An entity is a POJO (Plain Old Java Object) that is mapped to a  table in a relational database.
 *  - can represent different database tables
 *  - facilitates ORM behavior
 *  - encapsulates data and behavior
*/
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// Creates boiler plate code IE: getters, setters, toString equals
import lombok.Data;

// These are spring annotations. Spring annotations provide metadata to spring framework
@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Automatically increments new items one by one after new expense
    private Long id;
    private String title;
    private String description;
    private String category;
    private LocalDate date;
    private Float amount;
}
