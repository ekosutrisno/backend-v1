package app.xsis.services.impl;

import app.xsis.dao.master.TipeJadwalDao;
import app.xsis.models.master.TipeJadwalEntity;
import app.xsis.services.TipeJadwalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipeJadwalServiceImpl implements TipeJadwalService {
   @Autowired
   private TipeJadwalDao tipeJadwalDao;

   public TipeJadwalServiceImpl(TipeJadwalDao tipeJadwalDao) {
      this.tipeJadwalDao = tipeJadwalDao;
   }

   @Override
   public List<TipeJadwalEntity> getAllData() {
      return tipeJadwalDao.findAll();
   }

   @Override
   public Optional<TipeJadwalEntity> getDataById(long id) {
      if (tipeJadwalDao.findById(id) == null) {
         return Optional.empty();
      }
      return tipeJadwalDao.findById(id);
   }

   @Override
   public TipeJadwalEntity saveTipeJadwal(TipeJadwalEntity tipeJadwalEntity) {
      return tipeJadwalDao.create(tipeJadwalEntity);
   }
}
