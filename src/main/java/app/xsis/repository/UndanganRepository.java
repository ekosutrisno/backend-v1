package app.xsis.repository;

import app.xsis.models.transaction.UndanganEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UndanganRepository extends JpaRepository<UndanganEntity, Long> {

   @Query(value = "select u from UndanganEntity u where u.isDelete = false")
   Page<UndanganEntity> findAll(Pageable pageable);
}
