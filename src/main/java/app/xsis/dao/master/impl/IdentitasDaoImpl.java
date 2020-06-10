package app.xsis.dao.master.impl;

import app.xsis.dao.master.IdentitasDao;
import app.xsis.models.master.DataIdentitasEntity;
import app.xsis.repository.DataIdentitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IdentitasDaoImpl implements IdentitasDao {
   @Autowired
   private DataIdentitasRepository identitasRepository;

   public IdentitasDaoImpl(DataIdentitasRepository identitasRepository) {
      this.identitasRepository = identitasRepository;
   }

   @Override
   public Optional<DataIdentitasEntity> findById(Long id) {
      return identitasRepository.findById(id);
   }

   @Override
   public List<DataIdentitasEntity> findAll() {
      return identitasRepository.findAll();
   }

   @Override
   public DataIdentitasEntity create(DataIdentitasEntity identitas) {
      return identitasRepository.save(identitas);
   }

   @Override
   public DataIdentitasEntity update(DataIdentitasEntity identitas) {
      return identitasRepository.save(identitas);
   }

   @Override
   public void delete(DataIdentitasEntity identitas) {
      identitasRepository.delete(identitas);
   }

   @Override
   public void deleteById(long entityId) {
      identitasRepository.deleteById(entityId);
   }
}
