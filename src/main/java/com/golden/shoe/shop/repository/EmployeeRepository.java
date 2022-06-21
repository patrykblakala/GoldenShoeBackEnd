package com.golden.shoe.shop.repository;

import com.golden.shoe.shop.domain.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getById(Long id);
}
