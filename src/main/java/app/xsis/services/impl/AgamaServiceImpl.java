package app.xsis.services.impl;

import app.xsis.dao.master.AgamaDao;
import app.xsis.models.master.AgamaEntity;
import app.xsis.services.AgamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgamaServiceImpl implements AgamaService {
   @Autowired
   private AgamaDao agamaDao;

   public AgamaServiceImpl(AgamaDao agamaDao) {
      this.agamaDao = agamaDao;
   }

   @Override
   public List<AgamaEntity> getAllAgama() {
      List<AgamaEntity> agama= agamaDao.findAll().stream().collect(Collectors.toList());
      return agama;
   }

   @Override
   public Optional<AgamaEntity> getAgamaById(long id) {
      return agamaDao.findById(id);
   }

   @Override
   public AgamaEntity saveData(AgamaEntity agama) {
      return agamaDao.create(agama);
   }

   @Override
   public Page<AgamaEntity> findAll(Pageable pageable) {
      return agamaDao.findAll(pageable);
   }
}
