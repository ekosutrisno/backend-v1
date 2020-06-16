package app.xsis.controllers;

import app.xsis.dto.ResponseCustom;
import app.xsis.models.master.DataIdentitasEntity;
import app.xsis.services.IdentitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/rest-identitas", produces = "application/json")
public class IdentitasRestController {
   @Autowired
   private IdentitasService identitasService;

   public IdentitasRestController(IdentitasService identitasService) {
      this.identitasService = identitasService;
   }

   @GetMapping
   public List<DataIdentitasEntity> getAllDataIdentitas() {
      return identitasService.getAllIdentitas();
   }

   @GetMapping("/{id}")
   public Optional<DataIdentitasEntity> getDataIdentitasById(@PathVariable long id) {
      if (identitasService.getById(id) == null) {
         return Optional.empty();
      }
      return identitasService.getById(id);
   }

   @PostMapping
   public Map<String, Object> insertDataIdentitas(@RequestBody DataIdentitasEntity identitasEntity) {
      ResponseCustom response = new ResponseCustom();
      Map<String, Object> tempData = new HashMap<>();

      DataIdentitasEntity dataIdentitas = identitasService.save(identitasEntity);
      tempData.put("Identitas", dataIdentitas);

      response.setStatus(true);
      response.setMessage("Data berhasil ditambahkan.");
      response.setTime(new Date());
      response.setData(tempData);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);
      return result;
   }
}
