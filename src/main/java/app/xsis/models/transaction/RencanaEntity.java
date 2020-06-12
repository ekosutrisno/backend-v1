package app.xsis.models.transaction;

import app.xsis.models.CommonEntity;
import app.xsis.models.master.TipeJadwalEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = RencanaEntity.TABLE_NAME)
@EqualsAndHashCode(callSuper = false)
public class RencanaEntity extends CommonEntity {
   static final String TABLE_NAME = "x_rencana_jadwal";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = " schedule_code", length = 20)
   private String scheduleCode;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
   @Column(name = " schedule_date")
   private Date scheduleDate;

   @Column(name = "time", length = 10)
   private String time;

   @OneToOne
   @JoinColumn(name = "ro")
   private EmployeeEntity ro;

   @OneToOne
   @JoinColumn(name = "tro")
   private EmployeeEntity tro;

   @OneToOne
   @JoinColumn(name = "schedule_type_id", nullable = false, referencedColumnName = "id")
   private TipeJadwalEntity scheduleTypeId;

   @Column(name = "location", length = 100)
   private String location;

   @Column(name = "other_ro_tro", length = 100)
   private String otherRoTro;

   @Column(name = "notes", length = 1000)
   private String notes;

   @Column(name = "is_automatic_mail")
   private boolean isAutomaticMail;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
   @Column(name = "sent_date")
   private Date sentDate;

   @Column(name = "status", length = 50)
   private String status;
}
