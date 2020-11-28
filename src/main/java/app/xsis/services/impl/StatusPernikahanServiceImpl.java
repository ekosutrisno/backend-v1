package app.xsis.services.impl;

import app.xsis.dao.master.StatusPernikahanDao;
import app.xsis.models.master.StatusPernikahanEntity;
import app.xsis.services.StatusPernikahanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusPernikahanServiceImpl implements StatusPernikahanService {

   @Autowired
   private StatusPernikahanDao statusPernikahanDao;

   @Override
   public List<StatusPernikahanEntity> getAllData() {
      return statusPernikahanDao.findAll();
   }

   @Override
   public Optional<StatusPernikahanEntity> getDataById(long id) {
      return statusPernikahanDao.findById(id);
   }

   @Override
   public StatusPernikahanEntity saveStatusPernikahan(StatusPernikahanEntity tipeJadwalEntity) {
      return statusPernikahanDao.create(tipeJadwalEntity);
   }
}
