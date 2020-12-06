package app.xsis.models.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
