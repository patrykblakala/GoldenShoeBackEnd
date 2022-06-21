package com.golden.shoe.shop.service.impl;

import com.golden.shoe.shop.domain.dao.Employee;
import com.golden.shoe.shop.repository.EmployeeRepository;
import com.golden.shoe.shop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public Employee getById(Long id) {
        return employeeRepository.getById(id);
    }
}
