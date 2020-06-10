package app.xsis.dao.master.impl;

import app.xsis.dao.master.StatusPernikahanDao;
import app.xsis.models.master.StatusPernikahanEntity;
import app.xsis.repository.StatusPernikahanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StatusPernikahanDaoImpl implements StatusPernikahanDao {

   @Autowired
   private StatusPernikahanRepository statusPernikahanRepository;

   public StatusPernikahanDaoImpl(StatusPernikahanRepository statusPernikahanRepository) {
      this.statusPernikahanRepository = statusPernikahanRepository;
   }

   @Override
   public Optional<StatusPernikahanEntity> findById(Long id) {
      return statusPernikahanRepository.findById(id);
   }

   @Override
   public List<StatusPernikahanEntity> findAll() {
      return statusPernikahanRepository.findAll();
   }

   @Override
   public StatusPernikahanEntity create(StatusPernikahanEntity entity) {
      return statusPernikahanRepository.save(entity);
   }

   @Override
   public StatusPernikahanEntity update(StatusPernikahanEntity entity) {
      return statusPernikahanRepository.save(entity);
   }

   @Override
   public void delete(StatusPernikahanEntity entity) {
      statusPernikahanRepository.delete(entity);
   }

   @Override
   public void deleteById(long entityId) {
      statusPernikahanRepository.deleteById(entityId);
   }
}
