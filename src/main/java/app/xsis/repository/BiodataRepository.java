package app.xsis.repository;

import app.xsis.models.transaction.BiodataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiodataRepository extends JpaRepository<BiodataEntity, Long> {
   @Override
   Page<BiodataEntity> findAll(Pageable pageable);

   BiodataEntity findByReligion(Long id);

   BiodataEntity findByMaritalStatus(Long id);

   BiodataEntity findByIdentityType(Long id);
}
