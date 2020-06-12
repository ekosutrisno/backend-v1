package app.xsis.services;

import app.xsis.models.transaction.UndanganEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UndanganService {
   List<UndanganEntity> getAllDataUndangan();

   Page<UndanganEntity> getAllDataUndanganPaging(Pageable pageable);

   Optional<UndanganEntity> getDataUndanganById(Long id);

   UndanganEntity savaDataUndangan(UndanganEntity undanganEntity);

   UndanganEntity updateDataUndangan(UndanganEntity undanganEntity);

   void deleteDataUndangan(Long id);
}
