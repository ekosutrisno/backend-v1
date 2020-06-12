package app.xsis.controllers;

import app.xsis.dto.ResponseCustom;
import app.xsis.dto.ResponseCustomById;
import app.xsis.models.transaction.BiodataEntity;
import app.xsis.models.transaction.EmployeeEntity;
import app.xsis.services.BiodataService;
import app.xsis.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/rest-biodata", produces = "application/json")
public class BiodataRestController {
   @Autowired
   private BiodataService biodataService;

   @Autowired
   private EmployeeService employeeService;

   public BiodataRestController(BiodataService biodataService, EmployeeService employeeService) {
      this.biodataService = biodataService;
      this.employeeService = employeeService;
   }

   @GetMapping
   public List<BiodataEntity> getAlBiodata() {
      return biodataService.getAllBiodata();
   }

   @GetMapping("/page")
   public Page<BiodataEntity> getAlBiodataPage(Pageable pageable) {
      return biodataService.findAll(pageable);
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> getBiodataById(@PathVariable(name = "id") Long id) {
      Optional<BiodataEntity> biodata = biodataService.getBiodataById(id);

      ResponseCustomById response = new ResponseCustomById();
      response.setSuccess(false);
      response.setKode_status(404);
      response.setStatus("Data Not Found!");
      response.setMessage("Data tidak tersedia atau telah dihapus oleh pengguna/admin.");

      if (biodata.isPresent() && !biodata.get().getIsDelete()) {
         return new ResponseEntity<>(biodata.get(), HttpStatus.OK);
      }

      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
   }

   @PostMapping
   public Map<String, Object> insertBiodata(@RequestBody BiodataEntity bio) {
      bio.setIsComplete(false);
      bio.setIsProcess(true);

      bio.setCreatedBy(1L);
      bio.setCreatedOn(new Date());

      //Saving Biodata to Table
      biodataService.save(bio);

      ResponseCustom response = new ResponseCustom();
      Map<String, Object> tempData = new HashMap<>();
      tempData.put("Biodata", bio);

      response.setStatus(true);
      response.setMessage("Data berhasil ditambahkan.");
      response.setData_created(new Date());
      response.setData(tempData);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }

   @PutMapping("/{id}")
   public Map<String, Object> updateBiodata(@RequestBody BiodataEntity data, @PathVariable(name = "id") Long id) {
      BiodataEntity bio = biodataService.getBiodataById(id).get();

      bio.setModifedBy(1L);
      bio.setModifedOn(new Date());

      //Biodata Set
      bio.setFullName(data.getFullName());
      bio.setNickName(data.getNickName());
      bio.setPob(data.getPob());
      bio.setDob(data.getDob());
      bio.setHight(data.getHight());
      bio.setWeight(data.getWeight());
      bio.setNationality(data.getNationality());
      bio.setEthnic(data.getEthnic());
      bio.setHobby(data.getHobby());
      bio.setEmail(data.getEmail());
      bio.setIdentityNo(data.getIdentityNo());
      bio.setPhoneNumber1(data.getPhoneNumber1());
      bio.setPhoneNumber2(data.getPhoneNumber2());
      bio.setParentPhoneNumber(data.getParentPhoneNumber());
      bio.setChildSequence(data.getChildSequence());
      bio.setHowManyBrothers(data.getHowManyBrothers());
      bio.setAddrbookId(data.getAddrbookId());
      bio.setToken(data.getToken());
      bio.setExpiredToken(data.getExpiredToken());
      bio.setMarriageYear(data.getMarriageYear());
      bio.setCompanyId(data.getCompanyId());
      bio.setMaritalStatus(data.getMaritalStatus());
      bio.setIdentityType(data.getIdentityType());
      bio.setReligion(data.getReligion());

      //Address Set
      bio.setAddress1(data.getAddress1());
      bio.setAddress2(data.getAddress2());
      bio.setPostalCode1(data.getPostalCode1());
      bio.setPostalCode2(data.getPostalCode2());
      bio.setRt1(data.getRt1());
      bio.setRt2(data.getRt2());
      bio.setKelurahan1(data.getKelurahan1());
      bio.setKelurahan2(data.getKelurahan2());
      bio.setKecamatan1(data.getKecamatan1());
      bio.setKecamatan2(data.getKecamatan2());
      bio.setRegion1(data.getRegion1());
      bio.setRegion2(data.getRegion2());

      //Saving Biodata & Address to Table
      biodataService.save(bio);

      ResponseCustom response = new ResponseCustom();
      Map<String, Object> tempData = new HashMap<>();
      tempData.put("Biodata", bio);

      response.setStatus(true);
      response.setMessage("Data Biodata berhasil di Update.");
      response.setData_created(new Date());
      response.setData(tempData);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }

   @DeleteMapping("/{id}")
   public Map<String, Object> deleteBiodata(@PathVariable(name = "id") Long id) {
      BiodataEntity biodata = biodataService.getBiodataById(id).get();
      EmployeeEntity employee = employeeService.getSingleEmployee(id);

      biodata.setIsDelete(true);
      biodata.setDeletedBy(1L);
      biodata.setDeletedOn(new Date());

      //Saving Biodata to Table
      biodataService.update(biodata);

      employee.setIsDelete(true);
      employee.setDeletedBy(1L);
      employee.setDeletedOn(new Date());

      //Saving Employee to Table
      employeeService.updateEmployee(employee);

      ResponseCustom response = new ResponseCustom();
      response.setStatus(true);
      response.setMessage("Data Biodata berhasil Dihapus.");
      response.setData_created(new Date());
      response.setData(null);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }
}
