package app.xsis.dao.transaction;

import app.xsis.dao.IOperations;
import app.xsis.models.transaction.UndanganEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UndanganDao extends IOperations<UndanganEntity> {
   Page<UndanganEntity> findAll(Pageable pageable);

}
