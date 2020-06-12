package app.xsis.repository;

import app.xsis.models.transaction.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositroy extends JpaRepository<EmployeeEntity, Long> {
   @Query(value = "select e from EmployeeEntity e where e.isDelete = false")
   Page<EmployeeEntity> findAll(Pageable pageable);

   @Query(value = "select e from EmployeeEntity e where e.biodataId.id = ?1")
   EmployeeEntity getSinggle(Long id);

   @Query(value = "select e from EmployeeEntity e where e.isDelete = false and e.isEro = true")
   List<EmployeeEntity> getEroEmployee();
}
