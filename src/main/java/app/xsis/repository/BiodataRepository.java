package app.xsis.repository;

import app.xsis.models.transaction.BiodataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BiodataRepository extends JpaRepository<BiodataEntity, Long> {
   @Override
   @Query(value = "select b from BiodataEntity b where b.isDelete = false")
   Page<BiodataEntity> findAll(Pageable pageable);

   @Query(value = "select b from BiodataEntity b where b.religion.id = ?1")
   BiodataEntity findByReligion(Long id);

   @Query(value = "select b from BiodataEntity b where b.maritalStatus.id = ?1")
   BiodataEntity findByMaritalStatus(Long id);

   @Query(value = "select b from BiodataEntity b where b.identityType.id = ?1")
   BiodataEntity findByIdentityType(Long id);
}
