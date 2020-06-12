package app.xsis.services.impl;

import app.xsis.dao.transaction.RencanaDao;
import app.xsis.models.transaction.RencanaEntity;
import app.xsis.services.RencanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RencanaServiceImpl implements RencanaService {
   @Autowired
   private RencanaDao rencanaDao;

   public RencanaServiceImpl(RencanaDao rencanaDao) {
      this.rencanaDao = rencanaDao;
   }

   @Override
   public List<RencanaEntity> getAllDataRencana() {
      List<RencanaEntity> dataTemp = new ArrayList<>();
      for (RencanaEntity rencana : rencanaDao.findAll()) {
         if (!rencana.getIsDelete())
            dataTemp.add(rencana);
      }
      return dataTemp;
   }

   @Override
   public Page<RencanaEntity> getAllDataRencanaPaging(Pageable pageable) {
      return rencanaDao.findAll(pageable);
   }


   @Override
   public Page<RencanaEntity> searchAllDataRencanaBerdasarkanSchedule(Date mulai, Date sampai, Pageable pageable) {
      return rencanaDao.searchData(mulai, sampai, pageable);
   }

   @Override
   public Optional<RencanaEntity> getDataRencanaById(Long id) {
      return rencanaDao.findById(id);
   }

   @Override
   public RencanaEntity saveDataRencana(RencanaEntity rencanaEntity) {
      return rencanaDao.create(rencanaEntity);
   }

   @Override
   public RencanaEntity updateDataRencana(RencanaEntity rencanaEntity) {
      return rencanaDao.update(rencanaEntity);
   }

   @Override
   public void deleteDataRencana(Long id) {
      rencanaDao.deleteById(id);
   }
}
