package app.xsis.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class ResponseCustom {
   private boolean status;
   private String message;
   private Date time;
   private Map<String,Object> data;
}
