package app.xsis.dao.master;

import app.xsis.dao.IOperations;
import app.xsis.models.master.AgamaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AgamaDao extends IOperations<AgamaEntity> {
   Page<AgamaEntity> findAll(Pageable pageable);
}
