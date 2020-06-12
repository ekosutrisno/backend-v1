package app.xsis.dao.transaction.impl;

import app.xsis.dao.transaction.EmployeeDao;
import app.xsis.models.transaction.EmployeeEntity;
import app.xsis.repository.EmployeeRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
   @Autowired
   private EmployeeRepositroy employeeRepositroy;

   public EmployeeDaoImpl(EmployeeRepositroy employeeRepositroy) {
      this.employeeRepositroy = employeeRepositroy;
   }

   @Override
   public Optional<EmployeeEntity> findById(Long id) {
      return employeeRepositroy.findById(id);
   }

   @Override
   public List<EmployeeEntity> findAll() {
      return employeeRepositroy.findAll();
   }

   @Override
   public EmployeeEntity create(EmployeeEntity entity) {
      return employeeRepositroy.save(entity);
   }

   @Override
   public EmployeeEntity update(EmployeeEntity entity) {
      return employeeRepositroy.save(entity);
   }

   @Override
   public void delete(EmployeeEntity entity) {
      employeeRepositroy.delete(entity);
   }

   @Override
   public void deleteById(long entityId) {
      employeeRepositroy.deleteById(entityId);
   }

   @Override
   public Page<EmployeeEntity> findAll(Pageable pageable) {
      return employeeRepositroy.findAll(pageable);
   }

   @Override
   public EmployeeEntity getSinggle(Long id) {
      return employeeRepositroy.getSinggle(id);
   }

   @Override
   public List<EmployeeEntity> getEroEmployee() {
      return employeeRepositroy.getEroEmployee();
   }
}
