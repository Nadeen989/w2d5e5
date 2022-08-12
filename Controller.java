package com.example.employees;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
public class Controller {

    private ArrayList<Employee> employeesList=new ArrayList<>();

    @GetMapping("/employees")
    public ResponseEntity getUsers(){

        return ResponseEntity.status(200).body(employeesList);
    }

    @PostMapping("/employees")
    public ResponseEntity addEmployee(@RequestBody @Valid Employee Employee,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        employeesList.add(Employee);
        return ResponseEntity.status(201).body(new ApiResponse("new user added!",201));

    }

    @PutMapping("/employees/{index}")
    public ResponseEntity updateUsers (@RequestBody @Valid Employee Employee,@PathVariable Integer index, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        if (index>=employeesList.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        employeesList.set(index,Employee);
        return ResponseEntity.status(201).body(new ApiResponse("User updated!",201));
    }

    @DeleteMapping("/employee/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index){
        if (index>=employeesList.size()){
            return ResponseEntity.status(200).body(new ApiResponse("Invalid index",400));

        }
        employeesList.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted! ",200));

    }

}
