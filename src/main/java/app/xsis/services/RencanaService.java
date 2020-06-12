package app.xsis.services;

import app.xsis.models.transaction.RencanaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RencanaService {
   List<RencanaEntity> getAllDataRencana();

   Page<RencanaEntity> getAllDataRencanaPaging(Pageable pageable);

   Page<RencanaEntity> searchAllDataRencanaBerdasarkanSchedule(Date mulai, Date sampai, Pageable pageable);

   Optional<RencanaEntity> getDataRencanaById(Long id);

   RencanaEntity saveDataRencana(RencanaEntity rencanaEntity);

   RencanaEntity updateDataRencana(RencanaEntity rencanaEntity);

   void deleteDataRencana(Long id);
}
