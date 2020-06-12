package app.xsis.models.transaction;

import app.xsis.models.CommonEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = EmployeeEntity.TABLE_NAME)
@EqualsAndHashCode(callSuper = false)
public class EmployeeEntity extends CommonEntity {
   static final String  TABLE_NAME="x_employee";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @OneToOne
   @JoinColumn(name = "biodata_id", nullable = false, referencedColumnName = "id")
   private BiodataEntity biodataId;

   @Column(name = "is_idle")
   private boolean isIdle;

   @Column(name = "is_ero")
   private boolean isEro;

   @Column(name = "is_user_client")
   private boolean isUserClient;

   @Column(name = "ero_email")
   private String eroEmail;
}
