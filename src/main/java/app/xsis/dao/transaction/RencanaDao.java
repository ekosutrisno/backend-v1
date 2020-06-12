package app.xsis.dao.transaction;

import app.xsis.dao.IOperations;
import app.xsis.models.transaction.RencanaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface RencanaDao extends IOperations<RencanaEntity> {
   Page<RencanaEntity> searchData(Date tgl_mulai, Date tgl_sampai, Pageable pageable);

   Page<RencanaEntity> findAll(Pageable pageable);

}
