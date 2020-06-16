package app.xsis.controllers;


import app.xsis.dto.ResponseCustom;
import app.xsis.models.master.TipeJadwalEntity;
import app.xsis.services.TipeJadwalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/rest-tipejadwal",produces = "application/json")
public class TipeJadwalRestController {
   @Autowired
   private TipeJadwalService tipeJadwalService;

   public TipeJadwalRestController(TipeJadwalService tipeJadwalService) {
      this.tipeJadwalService = tipeJadwalService;
   }

   @GetMapping
   public List<TipeJadwalEntity> getAllDataStatusPernikahan(){
      return tipeJadwalService.getAllData();
   }

   @GetMapping("/{id}")
   public Optional<TipeJadwalEntity> getDataById(@PathVariable long id){
      return tipeJadwalService.getDataById(id);
   }

   @PostMapping
   public Map<String,Object> insertData(@RequestBody TipeJadwalEntity tipeJadwalEntity){
      ResponseCustom response = new ResponseCustom();
      Map<String,Object> tempData = new HashMap<>();

      TipeJadwalEntity dataTipeJadwal = tipeJadwalService.saveTipeJadwal(tipeJadwalEntity);
      tempData.put("TipeJadwal", dataTipeJadwal);

      response.setStatus(true);
      response.setMessage("Data berhasil ditambahkan.");
      response.setTime(new Date());
      response.setData(tempData);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);
      return result;
   }

}
