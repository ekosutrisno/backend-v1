package app.xsis.services;

import app.xsis.models.master.DataIdentitasEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IdentitasService {
   List<DataIdentitasEntity> getAllIdentitas();

   Optional<DataIdentitasEntity> getById(long id);

   DataIdentitasEntity save(DataIdentitasEntity identitasEntity);
}
