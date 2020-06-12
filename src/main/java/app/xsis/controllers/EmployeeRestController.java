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
@RequestMapping(path = "/rest-employee", produces = "application/json")
public class EmployeeRestController {
   @Autowired
   private EmployeeService employeeService;

   @Autowired
   private BiodataService biodataService;

   public EmployeeRestController(EmployeeService employeeService, BiodataService biodataService) {
      this.employeeService = employeeService;
      this.biodataService = biodataService;
   }

   @GetMapping
   public List<EmployeeEntity> loadAllEmployee() {
      return employeeService.getAllEmployee();
   }

   @GetMapping("/ero")
   public List<EmployeeEntity> loadAllEmployeeIsEro() {
      return employeeService.getEroEmployee();
   }

   @GetMapping("/page")
   public Page<EmployeeEntity> loadAllEmployeeWithPaging(Pageable pageable) {
      return employeeService.getAllEmployePaging(pageable);
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> getEmployeById(@PathVariable Long id) {
      Optional<EmployeeEntity> dataEmployee = employeeService.getEmployeeById(id);

      ResponseCustomById response = new ResponseCustomById();
      response.setSuccess(false);
      response.setKode_status(404);
      response.setStatus("Data Not Found!");
      response.setMessage("Data tidak tersedia atau telah dihapus oleh pengguna/admin.");

      if (dataEmployee.isPresent() && !dataEmployee.get().getIsDelete())
         return new ResponseEntity<>(dataEmployee.get(), HttpStatus.OK);

      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
   }

   @PostMapping
   public Map<String, Object> insertDataEmployee(@RequestBody EmployeeEntity employeeEntity) {
      String email = biodataService.getBiodataById(employeeEntity.getBiodataId().getId()).get().getEmail();

      employeeEntity.setCreatedBy(1L);
      employeeEntity.setCreatedOn(new Date());

      if (employeeEntity.getEroEmail() == null || employeeEntity.getEroEmail() == "")
         employeeEntity.setEroEmail(email);

      //Saving data to table
      employeeService.savaEmployee(employeeEntity);

      ResponseCustom response = new ResponseCustom();
      Map<String, Object> tempDataEmployee = new HashMap<>();
      tempDataEmployee.put("Employee", employeeEntity);

      response.setStatus(true);
      response.setMessage("Data Employee berhasil ditambahkan.");
      response.setData_created(new Date());
      response.setData(tempDataEmployee);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }

   @PutMapping("/{id}")
   public Map<String, Object> updateDataEmploye(@RequestBody EmployeeEntity data, @PathVariable Long id) {
      EmployeeEntity employee = employeeService.getEmployeeById(id).get();
      String email = biodataService.getBiodataById(data.getBiodataId().getId()).get().getEmail();

      employee.setModifedBy(1L);
      employee.setModifedOn(new Date());

      //Set Data Employee
      employee.setBiodataId(data.getBiodataId());
      employee.setEro(data.isEro());
      employee.setIdle(data.isIdle());
      employee.setUserClient(data.isUserClient());

      if (data.getEroEmail() == null || data.getEroEmail() == "")
         employee.setEroEmail(email);
      else
         employee.setEroEmail(data.getEroEmail());

      employeeService.updateEmployee(employee);

      ResponseCustom response = new ResponseCustom();
      Map<String, Object> tempDataEmployee = new HashMap<>();
      tempDataEmployee.put("Employee", employee);

      response.setStatus(true);
      response.setMessage("Data Employee berhasil di Update.");
      response.setData_created(new Date());
      response.setData(tempDataEmployee);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }

   @DeleteMapping("/{id}")
   public Map<String, Object> deleteBiodata(@PathVariable(name = "id") Long id) {
      EmployeeEntity employee = employeeService.getEmployeeById(id).get();

      employee.setIsDelete(true);
      employee.setDeletedBy(1L);
      employee.setDeletedOn(new Date());

      //Saving Employee to Table
      employeeService.updateEmployee(employee);

      ResponseCustom response = new ResponseCustom();
      response.setStatus(true);
      response.setMessage("Data Employee berhasil Dihapus.");
      response.setData_created(new Date());
      response.setData(null);

      Map<String, Object> result = new HashMap<>();
      result.put("response", response);

      return result;
   }
}
