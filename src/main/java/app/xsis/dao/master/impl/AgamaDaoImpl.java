package app.xsis.dao.master.impl;

import app.xsis.dao.master.AgamaDao;
import app.xsis.models.master.AgamaEntity;
import app.xsis.repository.AgamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AgamaDaoImpl implements AgamaDao {

   @Autowired
   private AgamaRepository agamaRepository;

   @Override
   public Optional<AgamaEntity> findById(Long id) {
      return agamaRepository.findById(id);
   }

   @Override
   public List<AgamaEntity> findAll() {
      return agamaRepository.findAll();
   }

   @Override
   public AgamaEntity create(AgamaEntity agama) {
      return agamaRepository.save(agama);
   }

   @Override
   public AgamaEntity update(AgamaEntity agama) {
      return agamaRepository.save(agama);
   }

   @Override
   public void delete(AgamaEntity agama) {
      agamaRepository.delete(agama);
   }

   @Override
   public void deleteById(long id) {
      agamaRepository.deleteById(id);
   }
}
