package app.xsis.controllers;

import app.xsis.dto.BiodataDto;
import app.xsis.dto.ResponseCustom;
import app.xsis.dto.ResponseCustomById;
import app.xsis.models.master.AgamaEntity;
import app.xsis.models.master.DataIdentitasEntity;
import app.xsis.models.master.StatusPernikahanEntity;
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
   public Map<String, Object> insertBiodata(@RequestBody BiodataDto data) {
      //new instance object
      BiodataEntity bio = new BiodataEntity();
      DataIdentitasEntity identitas = new DataIdentitasEntity();
      AgamaEntity agama = new AgamaEntity();
      StatusPernikahanEntity statusPernikahan = new StatusPernikahanEntity();

      //Set Object id untuk (identitas tipe, agama, dan status pernikahan)
      identitas.setId(data.getIdentityType());
      agama.setId(data.getReligion());
      statusPernikahan.setId(data.getMaritalStatus());

      //Set gender
      boolean gender = false;
      if (data.getGender() == 1)
         gender = true;
      else if (data.getGender() == 2)
         gender = false;

      //Set Data Common
      bio.setIsComplete(false);
      bio.setIsProcess(true);
      bio.setCreatedBy(1L);
      bio.setCreatedOn(new Date());

      //Biodata Set
      bio.setFullName(data.getFullName());
      bio.setNickName(data.getNickName());
      bio.setPob(data.getPob());
      bio.setDob(data.getDob());
      bio.setGender(gender);
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

      //Set Object
      bio.setMaritalStatus(statusPernikahan);
      bio.setIdentityType(identitas);
      bio.setReligion(agama);

      //Address Set
      bio.setAddress1(data.getAddress1());
      bio.setAddress2(data.getAddress2());
      bio.setPostalCode1(data.getPostalCode1());
      bio.setPostalCode2(data.getPostalCode2());
      bio.setRt1(data.getRt1());
      bio.setRt2(data.getRt2());
      bio.setRw1(data.getRw1());
      bio.setRw2(data.getRw2());
      bio.setKelurahan1(data.getKelurahan1());
      bio.setKelurahan2(data.getKelurahan2());
      bio.setKecamatan1(data.getKecamatan1());
      bio.setKecamatan2(data.getKecamatan2());
      bio.setRegion1(data.getRegion1());
      bio.setRegion2(data.getRegion2());

      //Saving Biodata to Table
      biodataService.save(bio);

      ResponseCustom response = new ResponseCustom();
      Map<String, Object> tempData = new HashMap<>();
      tempData.put("Biodata", bio);

      response.setStatus(true);
      response.setMessage("Data berhasil ditambahkan.");
      response.setTime(new Date());
      response.setData(tempData);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }

   @PutMapping("/{id}")
   public Map<String, Object> updateBiodata(@RequestBody BiodataDto data, @PathVariable(name = "id") Long id) {
      BiodataEntity bio = biodataService.getBiodataById(id).get();
      DataIdentitasEntity identitas = new DataIdentitasEntity();
      AgamaEntity agama = new AgamaEntity();
      StatusPernikahanEntity statusPernikahan = new StatusPernikahanEntity();

      //Set Object id untuk (identitas tipe, agama, dan status pernikahan)
      identitas.setId(data.getIdentityType());
      agama.setId(data.getReligion());
      statusPernikahan.setId(data.getMaritalStatus());

      //Set gender
      boolean gender = false;
      if (data.getGender() == 1)
         gender = true;
      else if (data.getGender() == 2)
         gender = false;

      //Set data Common
      bio.setModifedBy(1L);
      bio.setModifedOn(new Date());

      //Biodata Set
      bio.setFullName(data.getFullName());
      bio.setNickName(data.getNickName());
      bio.setPob(data.getPob());
      bio.setDob(data.getDob());
      bio.setGender(gender);
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

      //Set Object
      bio.setMaritalStatus(statusPernikahan);
      bio.setIdentityType(identitas);
      bio.setReligion(agama);

      //Address Set
      bio.setAddress1(data.getAddress1());
      bio.setAddress2(data.getAddress2());
      bio.setPostalCode1(data.getPostalCode1());
      bio.setPostalCode2(data.getPostalCode2());
      bio.setRt1(data.getRt1());
      bio.setRt2(data.getRt2());
      bio.setRw1(data.getRw1());
      bio.setRw2(data.getRw2());
      bio.setKelurahan1(data.getKelurahan1());
      bio.setKelurahan2(data.getKelurahan2());
      bio.setKecamatan1(data.getKecamatan1());
      bio.setKecamatan2(data.getKecamatan2());
      bio.setRegion1(data.getRegion1());
      bio.setRegion2(data.getRegion2());

      //Saving Biodata & Address to Table
      biodataService.update(bio);

      ResponseCustom response = new ResponseCustom();
      Map<String, Object> tempData = new HashMap<>();
      tempData.put("Biodata", bio);

      response.setStatus(true);
      response.setMessage("Data Biodata berhasil di Update.");
      response.setTime(new Date());
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
      response.setTime(new Date());
      response.setData(null);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }
}
