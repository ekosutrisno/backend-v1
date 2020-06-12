package app.xsis.controllers;

import app.xsis.dto.ResponseCustom;
import app.xsis.dto.ResponseCustomById;
import app.xsis.models.transaction.RencanaEntity;
import app.xsis.services.RencanaService;
import app.xsis.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/rest-rencana", produces = "application/json")
public class RencanaRestController {

   @Autowired
   private RencanaService rencanaService;

   public RencanaRestController(RencanaService rencanaService) {
      this.rencanaService = rencanaService;
   }

   @GetMapping
   public List<RencanaEntity> loadAllDataRencana() {
      return rencanaService.getAllDataRencana();
   }

   @GetMapping("/page")
   public Page<RencanaEntity> loadAllDataRencanaWithPaging(Pageable pageable) {
      return rencanaService.getAllDataRencanaPaging(pageable);
   }

   @GetMapping("/search")
   public Page<RencanaEntity> searchAllDataRencanaWithPaging(@RequestParam String mulai, @RequestParam String sampai, Pageable pageable) throws ParseException {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

      Date dateMulai = formatter.parse(mulai);
      Date dateSampai = formatter.parse(sampai);

      return rencanaService.searchAllDataRencanaBerdasarkanSchedule(dateMulai, dateSampai, pageable);
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> getDataRencanaById(@PathVariable Long id) {
      Optional<RencanaEntity> dataRencana = rencanaService.getDataRencanaById(id);
      ResponseCustomById response = new ResponseCustomById();

      response.setSuccess(false);
      response.setKode_status(404);
      response.setStatus("Data Not Found!.");
      response.setMessage("Data yang anda minta tidak tersedia atau telah dihapus.");

      if (dataRencana.isPresent() && !dataRencana.get().getIsDelete())
         return new ResponseEntity<>(dataRencana.get(), HttpStatus.OK);

      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
   }

   @PostMapping
   public Map<String, Object> saveDataRencana(@RequestBody RencanaEntity rencanaEntity) {
      String kodeUndangan = RandomUtil.generateRandomStringNumber(16);

      rencanaEntity.setCreatedBy(1L);
      rencanaEntity.setCreatedOn(new Date());
      rencanaEntity.setScheduleCode(kodeUndangan);

      //Save Data Rencana
      rencanaService.saveDataRencana(rencanaEntity);

      Map<String, Object> tempDataRencana = new HashMap<>();
      tempDataRencana.put("Rencana", rencanaEntity);

      ResponseCustom response = new ResponseCustom();
      response.setStatus(true);
      response.setMessage("Data Rencana berhasil ditambahkan.");
      response.setData_created(new Date());
      response.setData(tempDataRencana);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }

   @PutMapping("/{id}")
   public Map<String, Object> updateDataRencana(@RequestBody RencanaEntity data, @PathVariable("id") Long id) {
      RencanaEntity rencana = rencanaService.getDataRencanaById(id).get();

      rencana.setModifedBy(1L);
      rencana.setModifedOn(new Date());

      rencana.setAutomaticMail(data.isAutomaticMail());
      rencana.setLocation(data.getLocation());
      rencana.setNotes(data.getNotes());
      rencana.setOtherRoTro(data.getOtherRoTro());
      rencana.setStatus(data.getStatus());
      rencana.setScheduleTypeId(data.getScheduleTypeId());
      rencana.setSentDate(data.getSentDate());
      rencana.setTime(data.getTime());
      rencana.setScheduleDate(data.getScheduleDate());
      rencana.setRo(data.getRo());
      rencana.setTro(data.getTro());

      //Save Update Rencana
      rencanaService.updateDataRencana(rencana);

      Map<String, Object> tempDataRencana = new HashMap<>();
      tempDataRencana.put("Rencana", rencana);

      ResponseCustom response = new ResponseCustom();
      response.setStatus(true);
      response.setMessage("Data Rencana berhasil diupdate.");
      response.setData_created(new Date());
      response.setData(tempDataRencana);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }

   @DeleteMapping("/{id}")
   public Map<String, Object> deleteDataRencana(@PathVariable("id") Long id) {
      RencanaEntity rencana = rencanaService.getDataRencanaById(id).get();

      rencana.setIsDelete(true);
      rencana.setDeletedBy(1L);
      rencana.setDeletedOn(new Date());

      //Saving data after update is delete
      rencanaService.updateDataRencana(rencana);

      ResponseCustom response = new ResponseCustom();
      response.setStatus(true);
      response.setMessage("Data Rencana berhasil Dihapus.");
      response.setData_created(new Date());
      response.setData(null);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }
}
