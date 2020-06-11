package app.xsis.dao.transaction;

import app.xsis.dao.IOperations;
import app.xsis.models.transaction.BiodataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BiodataDao extends IOperations<BiodataEntity> {
   Page<BiodataEntity> findAll(Pageable pageable);
   BiodataEntity findByReligion(Long id);

   BiodataEntity findByMaritalStatus(Long id);

   BiodataEntity findByIdentityType(Long id);
}
