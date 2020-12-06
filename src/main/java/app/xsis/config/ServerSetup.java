package app.xsis.config;

import app.xsis.dao.master.AgamaDao;
import app.xsis.models.master.AgamaEntity;
import app.xsis.models.master.DataIdentitasEntity;
import app.xsis.models.master.StatusPernikahanEntity;
import app.xsis.models.master.TipeJadwalEntity;
import app.xsis.repository.AgamaRepository;
import app.xsis.repository.DataIdentitasRepository;
import app.xsis.repository.StatusPernikahanRepository;
import app.xsis.repository.TipeJadwalRepositrory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ServerSetup implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ServerSetup.class);

    @Autowired
    private AgamaRepository agamaRepository;
    @Autowired
    private DataIdentitasRepository dataIdentitasRepository;
    @Autowired
    private StatusPernikahanRepository statusPernikahanRepository;
    @Autowired
    private TipeJadwalRepositrory tipeJadwalRepositrory;

    @Override
    public void run(String... args) throws Exception {
        List<AgamaEntity> agamaEntityList = List.of(
                new AgamaEntity(1L, "ISLAM", "AG001", "ISLAM"),
                new AgamaEntity(2L, "KRISTEN", "AG002", "KRISTEN"),
                new AgamaEntity(3L, "HINDU", "AG003", "HINDU"),
                new AgamaEntity(4L, "BUHDA", "AG004", "BUDHA"),
                new AgamaEntity(5L, "KONGHUCU", "AG005", "KONGHUCU")
        );

        // Save Agama Master
        if (agamaRepository.findAll().size() <= 0) {
            agamaRepository.saveAll(agamaEntityList);
            logger.info("Agama Insert Succesfully");
        }

        List<DataIdentitasEntity> dataIdentitasEntityList = List.of(
                new DataIdentitasEntity(1L, "ID001", "KTP", "Kartu Tanda Penduduk"),
                new DataIdentitasEntity(2L, "ID002", "SIM", "Surat Izin Mengemudi"),
                new DataIdentitasEntity(3L, "ID003", "PASSPORT", "PASSPORT"),
                new DataIdentitasEntity(4L, "ID004", "NPWP", "Nomor Pokok Wajib Pajak"),
                new DataIdentitasEntity(5L, "ID005", "BPJS", "BPJS")
        );

        // Save Data Identitas Master
        if (dataIdentitasRepository.findAll().size() <= 0) {
            dataIdentitasRepository.saveAll(dataIdentitasEntityList);
            logger.info("Data Identitas Insert Succesfully");
        }

        List<StatusPernikahanEntity> statusPernikahanEntityList = List.of(
                new StatusPernikahanEntity(1L, "ST001", "SINGLE", "Single"),
                new StatusPernikahanEntity(2L, "ST002", "MENIKAH", "Sudah Menikah"),
                new StatusPernikahanEntity(3L, "ST003", "DUDA/JANDA", "Duda/Janda")
        );

        // Save Status Pernikahan Master
        if (statusPernikahanRepository.findAll().size() <= 0) {
            statusPernikahanRepository.saveAll(statusPernikahanEntityList);
            logger.info("Status Pernikahan Insert Succesfully");
        }

        List<TipeJadwalEntity> tipeJadwalEntityList = List.of(
                new TipeJadwalEntity(1L, "JD001", "BOOTCAMP", "BOOTCAMP"),
                new TipeJadwalEntity(2L, "JD002", "FILTERING", "FILTERING"),
                new TipeJadwalEntity(3L, "JD003", "NEOP", "NEOP"),
                new TipeJadwalEntity(4L, "JD004", "PRA-PLACEMENT", "PRA-PLACEMENT"),
                new TipeJadwalEntity(5L, "JD005", "INTERVIEW", "INTERVIEW"),
                new TipeJadwalEntity(6L, "JD006", "PLACEMENT", "PLACEMENT"),
                new TipeJadwalEntity(7L, "JD007", "GATHERING", "GATHERING")
        );

        // Save Tipe Jadwal Master
        if (tipeJadwalRepositrory.findAll().size() <= 0) {
            tipeJadwalRepositrory.saveAll(tipeJadwalEntityList);
            logger.info("Tipe Jadwal Insert Succesfully");
        }

    }

}
