package app.xsis.dao.transaction.impl;

import app.xsis.dao.transaction.UndanganDao;
import app.xsis.models.transaction.UndanganEntity;
import app.xsis.repository.UndanganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UndanganDaoImpl implements UndanganDao {
   @Autowired
   private UndanganRepository undanganRepository;

   public UndanganDaoImpl(UndanganRepository undanganRepository) {
      this.undanganRepository = undanganRepository;
   }

   @Override
   public Optional<UndanganEntity> findById(Long id) {
      return undanganRepository.findById(id);
   }

   @Override
   public List<UndanganEntity> findAll() {
      return undanganRepository.findAll();
   }

   @Override
   public UndanganEntity create(UndanganEntity entity) {
      return undanganRepository.save(entity);
   }

   @Override
   public UndanganEntity update(UndanganEntity entity) {
      return undanganRepository.save(entity);
   }

   @Override
   public void delete(UndanganEntity entity) {
      undanganRepository.delete(entity);
   }

   @Override
   public void deleteById(long entityId) {
      undanganRepository.deleteById(entityId);
   }

   @Override
   public Page<UndanganEntity> findAll(Pageable pageable) {
      return undanganRepository.findAll(pageable);
   }
}
