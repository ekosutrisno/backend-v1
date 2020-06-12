package app.xsis.models.master;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = StatusPernikahanEntity.TABLE_NAME)
public class StatusPernikahanEntity implements Serializable {
   static final String TABLE_NAME = "m_status_pernikahan";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "kode_status", nullable = false, length = 5)
   private String kodeStatus;

   @Column(name = "nama", nullable = false, length = 50)
   private String nama;

   @Column(name = "deskripsi", length = 100)
   private String deskripsi;
}
