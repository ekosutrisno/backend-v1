package app.xsis.dto;

import lombok.Data;

@Data
public class ResponseCustomById {
   private boolean success;
   private int kode_status;
   private String status;
   private String message;
}
