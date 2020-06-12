package app.xsis.services.impl;

import app.xsis.dao.transaction.BiodataDao;
import app.xsis.dao.transaction.EmployeeDao;
import app.xsis.models.transaction.BiodataEntity;
import app.xsis.services.BiodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BiodataServiceImp implements BiodataService {
   @Autowired
   private BiodataDao biodataDao;

   public BiodataServiceImp(BiodataDao biodataDao) {
      this.biodataDao = biodataDao;
   }

   @Override
   public List<BiodataEntity> getAllBiodata() {
      List<BiodataEntity> tempBiodata = new ArrayList<>();

      for (BiodataEntity biodata : biodataDao.findAll()) {
         if (!biodata.getIsDelete())
            tempBiodata.add(biodata);
      }
      return tempBiodata;
   }

   @Override
   public Page<BiodataEntity> findAll(Pageable pageable) {
      return biodataDao.findAll(pageable);
   }

   @Override
   public Optional<BiodataEntity> getBiodataById(Long id) {
      return biodataDao.findById(id);
   }

   @Override
   public BiodataEntity save(BiodataEntity biodataEntity) {
      return biodataDao.create(biodataEntity);
   }

   @Override
   public BiodataEntity update(BiodataEntity biodataEntity) {
      return biodataDao.update(biodataEntity);
   }

   @Override
   public void delete(Long id) {
      biodataDao.deleteById(id);
   }

   @Override
   public BiodataEntity getBiodataByReligion(Long id) {
      return biodataDao.findByReligion(id);
   }

   @Override
   public BiodataEntity getBiodataByMarital(Long id) {
      return biodataDao.findByMaritalStatus(id);
   }

   @Override
   public BiodataEntity getBiodataByIdentity(Long id) {
      return biodataDao.findByIdentityType(id);
   }
}
