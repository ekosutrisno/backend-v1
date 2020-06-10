package app.xsis.services;

import app.xsis.models.master.DataIdentitasEntity;

import java.util.List;
import java.util.Optional;

public interface IdentitasService {
   List<DataIdentitasEntity> getAllIdentitas();

   Optional<DataIdentitasEntity> getById(long id);

   DataIdentitasEntity save(DataIdentitasEntity identitasEntity);
}
