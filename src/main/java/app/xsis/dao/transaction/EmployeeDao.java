package app.xsis.dao.transaction;

import app.xsis.dao.IOperations;
import app.xsis.models.transaction.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeDao extends IOperations<EmployeeEntity> {
   Page<EmployeeEntity> findAll(Pageable pageable);

   EmployeeEntity getSinggle(Long id);

   List<EmployeeEntity> getEroEmployee();
}
