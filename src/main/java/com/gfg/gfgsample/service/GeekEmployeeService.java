package com.gfg.gfgsample.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gfg.gfgsample.domain.GeekEmployee;
import com.gfg.gfgsample.util.GeekEmployeeIdGenerator;

@Service
public class GeekEmployeeService {
	
    Map<Long, GeekEmployee> geekEmployees = new HashMap<>();

    // Return all geekEmployees
    public Collection<GeekEmployee> findAll(){
        return geekEmployees.values();
    }
 
    // Find the geekEmployee with this id
    public Optional<GeekEmployee> findById(Long employeeId) {
    	GeekEmployee geekEmployee = null;
 
        if (geekEmployees.containsKey(employeeId)) geekEmployee = geekEmployees.get(employeeId);
        	return Optional.ofNullable(geekEmployee);
    }
         
    // Save a new GeekEmployee   
    public GeekEmployee save(GeekEmployee geekEmployee) {
        geekEmployee.setEmployeeId(GeekEmployeeIdGenerator.value());
        geekEmployees.put(geekEmployee.getEmployeeId(), geekEmployee);
        return geekEmployee;
    }
     
    // Update the GeekEmployee with this id
    public Optional<GeekEmployee> update(GeekEmployee geekEmployee) {
    	GeekEmployee geekEmployee1 = geekEmployees.get(geekEmployee.getEmployeeId());
 
        if (geekEmployee1 != null) {
            geekEmployees.put(geekEmployee.getEmployeeId(), geekEmployee);
            geekEmployee1 = geekEmployees.get(geekEmployee.getEmployeeId());
        }
        return Optional.ofNullable(geekEmployee1);
    }
     
    // Delete GeekEmployee with this id
    public Optional<GeekEmployee> delete(Long employeeId) {
    	GeekEmployee geekEmployee1 = geekEmployees.get(employeeId);
 
        if (geekEmployee1 != null) {
            geekEmployees.remove(employeeId);
        }
        return Optional.ofNullable(geekEmployee1);
    }

}
