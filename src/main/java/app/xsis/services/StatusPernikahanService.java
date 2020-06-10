package app.xsis.services;

import app.xsis.models.master.StatusPernikahanEntity;

import java.util.List;
import java.util.Optional;

public interface StatusPernikahanService {
   List<StatusPernikahanEntity> getAllData();

   Optional<StatusPernikahanEntity> getDataById(long id);

   StatusPernikahanEntity saveStatusPernikahan(StatusPernikahanEntity tipeJadwalEntity);

}
