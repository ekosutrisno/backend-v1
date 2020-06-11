package app.xsis.dao.transaction.impl;

import app.xsis.dao.transaction.BiodataDao;
import app.xsis.models.transaction.BiodataEntity;
import app.xsis.repository.BiodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BiodataDaoImpl implements BiodataDao {
   @Autowired
   private BiodataRepository biodataRepository;

   public BiodataDaoImpl(BiodataRepository biodataRepository) {
      this.biodataRepository = biodataRepository;
   }

   @Override
   public Optional<BiodataEntity> findById(Long id) {
      return biodataRepository.findById(id);
   }

   @Override
   public List<BiodataEntity> findAll() {
      return biodataRepository.findAll();
   }

   @Override
   public BiodataEntity create(BiodataEntity entity) {
      return biodataRepository.save(entity);
   }

   @Override
   public BiodataEntity update(BiodataEntity entity) {
      return biodataRepository.save(entity);
   }

   @Override
   public void delete(BiodataEntity entity) {
      biodataRepository.delete(entity);
   }

   @Override
   public void deleteById(long entityId) {
      biodataRepository.deleteById(entityId);
   }

   @Override
   public BiodataEntity findByReligion(Long id) {
      return biodataRepository.findByReligion(id);
   }

   @Override
   public BiodataEntity findByMaritalStatus(Long id) {
      return biodataRepository.findByMaritalStatus(id);
   }

   @Override
   public BiodataEntity findByIdentityType(Long id) {
      return biodataRepository.findByIdentityType(id);
   }

   @Override
   public Page<BiodataEntity> findAll(Pageable pageable) {
      return biodataRepository.findAll(pageable);
   }
}
