package app.xsis.services;

import app.xsis.models.master.TipeJadwalEntity;

import java.util.List;
import java.util.Optional;

public interface TipeJadwalService {
   List<TipeJadwalEntity> getAllData();

   Optional<TipeJadwalEntity> getDataById(long id);

   TipeJadwalEntity saveTipeJadwal(TipeJadwalEntity tipeJadwalEntity);

}
