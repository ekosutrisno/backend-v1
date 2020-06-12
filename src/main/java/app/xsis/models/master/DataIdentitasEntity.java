package app.xsis.models.master;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = DataIdentitasEntity.TABLE_NAME)
public class DataIdentitasEntity implements Serializable {
   static final  String TABLE_NAME ="m_identitas";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "kode_identitas",length = 50,nullable = false)
   private String kodeIdentitas;

   @Column(name = "nama",length = 50,nullable = false)
   private String nama;

   @Column(name = "deskripsi")
   private String deskripsi;
}
