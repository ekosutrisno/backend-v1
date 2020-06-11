package app.xsis.controllers;

import app.xsis.models.transaction.BiodataEntity;
import app.xsis.services.BiodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/rest-biodata",produces = "application/json")
public class BiodataRestController {
   @Autowired
   private BiodataService biodataService;

   public BiodataRestController(BiodataService biodataService) {
      this.biodataService = biodataService;
   }

   @GetMapping
   public List<BiodataEntity> getAlBiodata(){
      return biodataService.getAllBiodata();
   }

   @GetMapping("/page")
   public Page<BiodataEntity> getAlBiodataPage(Pageable pageable){
      return biodataService.findAll(pageable);
   }
}
