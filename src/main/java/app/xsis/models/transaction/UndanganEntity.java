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
@Table(name = UndanganEntity.TABLE_NAME)
@SecondaryTable(name = UndanganEntity.TABLE_NAME_SECONDARY, pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
@EqualsAndHashCode(callSuper = false)
public class UndanganEntity extends CommonEntity {
   static final String TABLE_NAME = "x_undangan";
   static final String TABLE_NAME_SECONDARY = "x_undangan_detail";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @ManyToOne
   @JoinColumn(name = "schedule_type_id")
   private TipeJadwalEntity scheduleTypeId;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
   @Column(name = "invitation_date")
   private Date invitationDate;

   @Column(name = "invitation_code", length = 20)
   private String invitationCode;

   @Column(name = "time", length = 10)
   private String time;

   @Column(name = "other_ro_tro", length = 100)
   private String otherRoTro;

   @Column(name = "location", length = 100)
   private String location;

   @OneToOne
   @JoinColumn(name = "ro")
   private EmployeeEntity ro;

   @OneToOne
   @JoinColumn(name = "tro")
   private EmployeeEntity tro;

   @Column(name = "status", length = 50)
   private String status;

   //Undangan detail set Table
   @OneToOne
   @JoinColumn(name = "biodata_id", nullable = false, table = "x_undangan_detail")
   private BiodataEntity biodataId;

   @Column(name = "notes", length = 1000, table = "x_undangan_detail")
   private String notes;
}
