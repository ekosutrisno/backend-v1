package app.xsis.dao.master.impl;

import app.xsis.dao.master.TipeJadwalDao;
import app.xsis.models.master.TipeJadwalEntity;
import app.xsis.repository.TipeJadwalRepositrory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipeJadwalDaoImpl implements TipeJadwalDao {
   @Autowired
   private TipeJadwalRepositrory tipeJadwalRepositrory;

   public TipeJadwalDaoImpl(TipeJadwalRepositrory tipeJadwalRepositrory) {
      this.tipeJadwalRepositrory = tipeJadwalRepositrory;
   }

   @Override
   public Optional<TipeJadwalEntity> findById(Long id) {
      return tipeJadwalRepositrory.findById(id);
   }

   @Override
   public List<TipeJadwalEntity> findAll() {
      return tipeJadwalRepositrory.findAll();
   }

   @Override
   public TipeJadwalEntity create(TipeJadwalEntity entity) {
      return tipeJadwalRepositrory.save(entity);
   }

   @Override
   public TipeJadwalEntity update(TipeJadwalEntity entity) {
      return tipeJadwalRepositrory.save(entity);
   }

   @Override
   public void delete(TipeJadwalEntity entity) {
      tipeJadwalRepositrory.delete(entity);
   }

   @Override
   public void deleteById(long entityId) {
      tipeJadwalRepositrory.deleteById(entityId);
   }
}
