package app.xsis.repository;

import app.xsis.models.master.AgamaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgamaRepository extends JpaRepository<AgamaEntity,Long> {

   @Override
   Page<AgamaEntity> findAll(Pageable pageable);
}
