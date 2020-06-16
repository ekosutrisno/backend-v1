package app.xsis.controllers;

import app.xsis.dto.ResponseCustom;
import app.xsis.dto.ResponseCustomById;
import app.xsis.models.transaction.UndanganEntity;
import app.xsis.services.UndanganService;
import app.xsis.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/rest-undangan", produces = "application/json")
public class UndanganRestController {
   @Autowired
   private UndanganService undanganService;

   public UndanganRestController(UndanganService undanganService) {
      this.undanganService = undanganService;
   }

   @GetMapping
   public List<UndanganEntity> loadAllDataUndangan() {
      return undanganService.getAllDataUndangan();
   }

   @GetMapping("/page")
   public Page<UndanganEntity> loadAllDataUndanganWithPaging(Pageable pageable) {
      return undanganService.getAllDataUndanganPaging(pageable);
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> getDataUndanganById(@PathVariable Long id) {
      Optional<UndanganEntity> dataUndangan = undanganService.getDataUndanganById(id);
      if (dataUndangan.isPresent() && !dataUndangan.get().getIsDelete())
         return new ResponseEntity<>(dataUndangan.get(), HttpStatus.OK);

      ResponseCustomById respon = new ResponseCustomById();
      respon.setStatus("Data Not Found!");
      respon.setKode_status(404);
      respon.setSuccess(false);
      respon.setMessage("Data tidak tersedia atau telah dihapus.");

      return new ResponseEntity<>(respon, HttpStatus.NOT_FOUND);
   }

   @PostMapping
   public Map<String, Object> insertDataUndangan(@RequestBody UndanganEntity undanganEntity) {
      String kodeUndangan = RandomUtil.generateRandomStringNumber(16);

      undanganEntity.setCreatedBy(1L);
      undanganEntity.setCreatedOn(new Date());
      undanganEntity.setInvitationCode(kodeUndangan);

      //Save Data Rencana
      undanganService.savaDataUndangan(undanganEntity);

      Map<String, Object> tempDataRencana = new HashMap<>();
      tempDataRencana.put("Undangan", undanganEntity);

      ResponseCustom response = new ResponseCustom();
      response.setStatus(true);
      response.setMessage("Data Rencana berhasil ditambahkan.");
      response.setTime(new Date());
      response.setData(tempDataRencana);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }

   @PutMapping("/{id}")
   public Map<String, Object> updateDataUndangan(@RequestBody UndanganEntity data, @PathVariable Long id) {
      UndanganEntity undangan = undanganService.getDataUndanganById(id).get();

      undangan.setModifedBy(1L);
      undangan.setModifedOn(new Date());

      //Set Data Undangan
      undangan.setBiodataId(data.getBiodataId());
      undangan.setInvitationDate(data.getInvitationDate());
      undangan.setLocation(data.getLocation());
      undangan.setNotes(data.getNotes());
      undangan.setOtherRoTro(data.getOtherRoTro());
      undangan.setScheduleTypeId(data.getScheduleTypeId());
      undangan.setStatus(data.getStatus());
      undangan.setTime(data.getTime());
      undangan.setRo(data.getRo());
      undangan.setTro(data.getTro());

      //Update and Save data undangan
      undanganService.updateDataUndangan(undangan);

      Map<String, Object> tempDataRencana = new HashMap<>();
      tempDataRencana.put("Undangan", undangan);

      ResponseCustom response = new ResponseCustom();
      response.setStatus(true);
      response.setMessage("Data Rencana berhasil ditambahkan.");
      response.setTime(new Date());
      response.setData(tempDataRencana);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }

   @DeleteMapping("/{id}")
   public Map<String, Object> deleteBiodata(@PathVariable(name = "id") Long id) {
      UndanganEntity undangan = undanganService.getDataUndanganById(id).get();

      undangan.setIsDelete(true);
      undangan.setDeletedBy(1L);
      undangan.setDeletedOn(new Date());

      //Saving Employee to Table
      undanganService.updateDataUndangan(undangan);

      ResponseCustom response = new ResponseCustom();
      response.setStatus(true);
      response.setMessage("Data Undangan berhasil Dihapus.");
      response.setTime(new Date());
      response.setData(null);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }
}
