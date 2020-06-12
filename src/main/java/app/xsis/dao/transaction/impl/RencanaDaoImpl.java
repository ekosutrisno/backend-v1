package app.xsis.dao.transaction.impl;

import app.xsis.dao.transaction.RencanaDao;
import app.xsis.models.transaction.RencanaEntity;
import app.xsis.repository.RencanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class RencanaDaoImpl implements RencanaDao {

   @Autowired
   private RencanaRepository rencanaRepository;

   public RencanaDaoImpl(RencanaRepository rencanaRepository) {
      this.rencanaRepository = rencanaRepository;
   }

   @Override
   public Page<RencanaEntity> searchData(Date tgl_mulai, Date tgl_sampai, Pageable pageable) {
      return rencanaRepository.searchData(tgl_mulai, tgl_sampai, pageable);
   }

   @Override
   public Page<RencanaEntity> findAll(Pageable pageable) {
      return rencanaRepository.findAll(pageable);
   }

   @Override
   public Optional<RencanaEntity> findById(Long id) {
      return rencanaRepository.findById(id);
   }

   @Override
   public List<RencanaEntity> findAll() {
      return rencanaRepository.findAll();
   }

   @Override
   public RencanaEntity create(RencanaEntity entity) {
      return rencanaRepository.save(entity);
   }

   @Override
   public RencanaEntity update(RencanaEntity entity) {
      return rencanaRepository.save(entity);
   }

   @Override
   public void delete(RencanaEntity entity) {
      rencanaRepository.delete(entity);
   }

   @Override
   public void deleteById(long entityId) {
      rencanaRepository.deleteById(entityId);
   }
}
