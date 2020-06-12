package app.xsis.services.impl;

import app.xsis.dao.transaction.EmployeeDao;
import app.xsis.models.transaction.EmployeeEntity;
import app.xsis.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   @Autowired
   private EmployeeDao employeeDao;

   public EmployeeServiceImpl(EmployeeDao employeeDao) {
      this.employeeDao = employeeDao;
   }

   @Override
   public List<EmployeeEntity> getAllEmployee() {
      List<EmployeeEntity> dataEmployee = new ArrayList<>();
      for (EmployeeEntity employee : employeeDao.findAll()) {
         if (!employee.getIsDelete())
            dataEmployee.add(employee);
      }
      return dataEmployee;
   }

   @Override
   public Page<EmployeeEntity> getAllEmployePaging(Pageable pageable) {
      return employeeDao.findAll(pageable);
   }

   @Override
   public Optional<EmployeeEntity> getEmployeeById(Long id) {
      return employeeDao.findById(id);
   }

   @Override
   public EmployeeEntity savaEmployee(EmployeeEntity employeeEntity) {
      return employeeDao.create(employeeEntity);
   }

   @Override
   public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
      return employeeDao.update(employeeEntity);
   }

   @Override
   public EmployeeEntity getSingleEmployee(Long id) {
      return employeeDao.getSinggle(id);
   }

   @Override
   public List<EmployeeEntity> getEroEmployee() {
      return employeeDao.getEroEmployee();
   }

   @Override
   public void deleteEmployee(Long id) {
      employeeDao.deleteById(id);
   }
}
