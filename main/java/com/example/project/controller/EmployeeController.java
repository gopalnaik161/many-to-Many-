package com.example.project.controller;
import com.example.project.Service.EmployeeService;
import com.example.project.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;


    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
        empService.addEmployee(emp);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/getemployee/{empId}")
    public List<Employee> getEmployee(@RequestBody Employee employee) {
        return this.empService.getEmployee(employee);

    }


    @PutMapping("/{empId}/project/{projectId}")
    public Employee assignProjectToEmployee(@PathVariable Long empId, @PathVariable Long projectId) {

        return this.empService.assignProjectToEmployee(empId, projectId);
    }

    @DeleteMapping("delete/{empId}")
    public ResponseEntity deleteEmployeeById(@PathVariable Long empId){
        empService.deleteEmployeeById(empId);
        return new ResponseEntity(HttpStatus.OK);

    }



}
