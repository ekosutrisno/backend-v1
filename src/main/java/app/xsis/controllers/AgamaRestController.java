package app.xsis.controllers;

import app.xsis.dto.ResponseCustom;
import app.xsis.models.master.AgamaEntity;
import app.xsis.services.AgamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/rest-agama", produces = "application/json")
public class AgamaRestController {

   @Autowired
   private AgamaService agamaService;

   public AgamaRestController(AgamaService agamaService) {
      this.agamaService = agamaService;
   }

   @GetMapping
   public List<AgamaEntity> getAllAgama() {
      return agamaService.getAllAgama();
   }

   @GetMapping("/{id}")
   public Optional<AgamaEntity> getAgamaById(@PathVariable("id") long id) {
      return agamaService.getAgamaById(id);
   }

   @PostMapping
   public Map<String, Object> insertData(@RequestBody AgamaEntity agama) {
      ResponseCustom response = new ResponseCustom();
      Map<String, Object> tempData = new HashMap<>();

      AgamaEntity dataAgama = agamaService.saveData(agama);
      tempData.put("Agama", dataAgama);

      response.setStatus(true);
      response.setMessage("Data berhasil ditambahkan.");
      response.setData_created(new Date());
      response.setData(tempData);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }

}
