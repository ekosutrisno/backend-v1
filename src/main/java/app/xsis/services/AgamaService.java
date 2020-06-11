package app.xsis.services;

import app.xsis.models.master.AgamaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AgamaService {
   List<AgamaEntity> getAllAgama();

   Optional<AgamaEntity> getAgamaById(long id);

   AgamaEntity saveData(AgamaEntity agama);

   Page<AgamaEntity> findAll(Pageable pageable);
}
