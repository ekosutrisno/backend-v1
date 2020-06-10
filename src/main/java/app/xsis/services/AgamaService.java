package app.xsis.services;

import app.xsis.models.master.AgamaEntity;

import java.util.List;
import java.util.Optional;

public interface AgamaService {
   List<AgamaEntity> getAllAgama();

   Optional<AgamaEntity> getAgamaById(long id);

   AgamaEntity saveData(AgamaEntity agama);
}
