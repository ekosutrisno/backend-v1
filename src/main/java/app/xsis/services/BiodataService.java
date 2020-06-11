package app.xsis.services;

import app.xsis.dto.ResponseCustom;
import app.xsis.models.transaction.BiodataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BiodataService {
   List<BiodataEntity> getAllBiodata();

   Page<BiodataEntity> findAll(Pageable pageable);

   Optional<BiodataEntity> getBiodataById(Long id);

   BiodataEntity save(BiodataEntity biodataEntity);

   BiodataEntity update(BiodataEntity biodataEntity);

   void delete(Long id);

   BiodataEntity getBiodataByReligion(Long id);

   BiodataEntity getBiodataByMarital(Long id);

   BiodataEntity getBiodataByIdentity(Long id);

}
