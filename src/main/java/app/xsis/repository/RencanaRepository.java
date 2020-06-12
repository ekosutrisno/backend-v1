package app.xsis.repository;

import app.xsis.models.transaction.RencanaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RencanaRepository extends JpaRepository<RencanaEntity, Long> {

   String CARI_DATA = "select r from RencanaEntity r where r.scheduleDate between ?1 and ?2";
   String DATA_QUERY = "select r from RencanaEntity r where r.isDelete = false";

   @Query(value = CARI_DATA)
   Page<RencanaEntity> searchData(Date tgl_mulai, Date tgl_sampai, Pageable pageable);

   @Query(value = DATA_QUERY)
   Page<RencanaEntity> findAll(Pageable pageable);
}
