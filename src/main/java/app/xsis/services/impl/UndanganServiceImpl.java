package app.xsis.services.impl;

import app.xsis.dao.transaction.UndanganDao;
import app.xsis.models.transaction.UndanganEntity;
import app.xsis.services.UndanganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UndanganServiceImpl implements UndanganService {
   @Autowired
   private UndanganDao undanganDao;

   public UndanganServiceImpl(UndanganDao undanganDao) {
      this.undanganDao = undanganDao;
   }

   @Override
   public List<UndanganEntity> getAllDataUndangan() {
      List<UndanganEntity> listDataUndangan = new ArrayList<>();

      for (UndanganEntity undangan : undanganDao.findAll()) {
         if (!undangan.getIsDelete())
            listDataUndangan.add(undangan);
      }
      return listDataUndangan;
   }

   @Override
   public Page<UndanganEntity> getAllDataUndanganPaging(Pageable pageable) {
      return undanganDao.findAll(pageable);
   }

   @Override
   public Optional<UndanganEntity> getDataUndanganById(Long id) {
      return undanganDao.findById(id);
   }

   @Override
   public UndanganEntity savaDataUndangan(UndanganEntity undanganEntity) {
      return undanganDao.create(undanganEntity);
   }

   @Override
   public UndanganEntity updateDataUndangan(UndanganEntity undanganEntity) {
      return undanganDao.update(undanganEntity);
   }

   @Override
   public void deleteDataUndangan(Long id) {
      undanganDao.deleteById(id);
   }
}
