package app.xsis.models.master;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = TipeJadwalEntity.TABLE_NAME)
public class TipeJadwalEntity implements Serializable {
   static final String TABLE_NAME="m_type_jadwal";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "kode_type",nullable = false,length = 5)
   private String kodeJadwal;

   @Column(name = "nama",nullable = false,length = 50)
   private String nama;

   @Column(name = "deskripsi",nullable = false,length = 100)
   private String deskripsi;
}
