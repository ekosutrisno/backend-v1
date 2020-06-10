package app.xsis.services.impl;

import app.xsis.dao.master.AgamaDao;
import app.xsis.models.master.AgamaEntity;
import app.xsis.services.AgamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AgamaServiceImpl implements AgamaService {
   @Autowired
   private AgamaDao agamaDao;

   public AgamaServiceImpl(AgamaDao agamaDao) {
      this.agamaDao = agamaDao;
   }

   @Override
   public List<AgamaEntity> getAllAgama() {
      return agamaDao.findAll();
   }

   @Override
   public Optional<AgamaEntity> getAgamaById(long id) {
      return agamaDao.findById(id);
   }

   @Override
   public AgamaEntity saveData(AgamaEntity agama) {
      return agamaDao.create(agama);
   }
}
