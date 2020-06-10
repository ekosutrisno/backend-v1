package app.xsis.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@MappedSuperclass
public class CommonEntity {
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "created_on", nullable = false)
   private Date createdOn;

   @Column(name = "created_by", nullable = false)
   private Long createdBy;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "modified_on")
   private Date modifedOn;

   @Column(name = "modified_by")
   private Long modifedBy;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "deleted_on")
   private Date deletedOn;

   @Column(name = "deleted_by")
   private Long deletedBy;

   @Column(name = "isdelete", nullable = false)
   private Boolean isDelete = false;
}
