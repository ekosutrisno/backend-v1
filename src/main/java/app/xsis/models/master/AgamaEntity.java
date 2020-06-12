package app.xsis.models.master;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = AgamaEntity.TABLE_NAME)
public class AgamaEntity implements Serializable {
   static final String TABLE_NAME = "m_agama";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "nama", nullable = false)
   private String nama;

   @Column(name = "kode_agama", nullable = false, length = 5)
   private String kodeAgama;

   @Column(name = "deskripsi")
   private String deskripsi;
}
