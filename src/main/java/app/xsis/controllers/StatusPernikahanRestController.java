package app.xsis.controllers;

import app.xsis.dto.ResponseCustom;
import app.xsis.models.master.StatusPernikahanEntity;
import app.xsis.services.StatusPernikahanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/rest-status",produces = "application/json")
public class StatusPernikahanRestController {

   @Autowired
   private StatusPernikahanService statusPernikahanService;

   public StatusPernikahanRestController(StatusPernikahanService statusPernikahanService) {
      this.statusPernikahanService = statusPernikahanService;
   }

   @GetMapping
   public List<StatusPernikahanEntity> getAllDataStatusPernikahan(){
      return statusPernikahanService.getAllData();
   }

   @GetMapping("/{id}")
   public Optional<StatusPernikahanEntity> getDataById(@PathVariable long id){
      return statusPernikahanService.getDataById(id);
   }

   @PostMapping
   public Map<String,Object> insertData(@RequestBody StatusPernikahanEntity statusPernikahanEntity){
      ResponseCustom response = new ResponseCustom();
      Map<String,Object> tempData = new HashMap<>();

      StatusPernikahanEntity dataStatus = statusPernikahanService.saveStatusPernikahan(statusPernikahanEntity);
      tempData.put("Status", dataStatus);

      response.setStatus(true);
      response.setMessage("Data berhasil ditambahkan.");
      response.setTime(new Date());
      response.setData(tempData);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);
      return result;
   }
}
