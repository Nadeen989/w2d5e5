package com.example.employees;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Employee {

    @NotNull(message = "Id can't be null")
    @Range(min = 2,message = "Id can't be null")
    private int ID;

    @NotEmpty(message = "name can't be null")
    @Size(min = 4,max = 15,message = "name must be  more than 4")
    private String name;

    @NotNull(message = "age can't be null")
    @Range(max = 25,message = "age must be  more than 25")
    private int age;

    @AssertFalse(message = "must be false")
    private String onLeave;

    @NotNull(message = "Year can't be null")
    @Range(min = 2000, max = 2023,message = "Please enter employment Year as digits only")
    private int employmentYear;

    @NotEmpty(message = "annual Leave Year can't be empty")
    private int annualLeave;








}
