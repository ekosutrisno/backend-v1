package app.xsis.services.impl;

import app.xsis.dao.master.IdentitasDao;
import app.xsis.models.master.DataIdentitasEntity;
import app.xsis.services.IdentitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentitasServiceImpl implements IdentitasService {
   @Autowired
   private IdentitasDao identitasDao;

   @Override
   public List<DataIdentitasEntity> getAllIdentitas() {
      return identitasDao.findAll();
   }

   @Override
   public Optional<DataIdentitasEntity> getById(long id) {
      return identitasDao.findById(id);
   }

   @Override
   public DataIdentitasEntity save(DataIdentitasEntity identitasEntity) {
      return identitasDao.create(identitasEntity);
   }
}
