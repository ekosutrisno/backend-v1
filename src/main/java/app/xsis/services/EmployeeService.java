package app.xsis.services;

import app.xsis.models.transaction.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
   List<EmployeeEntity> getAllEmployee();

   Page<EmployeeEntity> getAllEmployePaging(Pageable pageable);

   Optional<EmployeeEntity> getEmployeeById(Long id);

   EmployeeEntity savaEmployee(EmployeeEntity employeeEntity);

   EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

   EmployeeEntity getSingleEmployee(Long id);

   List<EmployeeEntity> getEroEmployee();

   void deleteEmployee(Long id);
}
