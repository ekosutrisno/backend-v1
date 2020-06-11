package app.xsis.models.transaction;

import app.xsis.models.CommonEntity;
import app.xsis.models.master.AgamaEntity;
import app.xsis.models.master.DataIdentitasEntity;
import app.xsis.models.master.StatusPernikahanEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = BiodataEntity.TABLE_NAME)
@SecondaryTable(name = BiodataEntity.TABLE_NAME_SECONDARY, pkJoinColumns = @PrimaryKeyJoinColumn(name = "biodataId"))
@EqualsAndHashCode(callSuper = false)
public class BiodataEntity extends CommonEntity {
   public static final String TABLE_NAME = "x_biodata";
   public static final String TABLE_NAME_SECONDARY = "x_address";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "fullname", nullable = false)
   private String fullName;

   @Column(name = "nick_name", nullable = false, length = 100)
   private String nickName;

   @Column(name = "pob", nullable = false, length = 100)
   private String pob;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
   @Column(name = "dob", nullable = false)
   private Date dob;

   @Column(name = "gender", nullable = false)
   private Boolean gender;

   @Column(name = "hight")
   private Integer hight;

   @Column(name = "weight")
   private Integer weight;

   @Column(name = "nationality", length = 100)
   private String nationality;

   @Column(name = "ethnic", length = 50)
   private String ethnic;

   @Column(name = "hobby")
   private String hobby;

   @Column(name = "email", nullable = false, length = 100)
   private String email;

   @Column(name = "identity_no", nullable = false, length = 50)
   private String identityNo;

   @Column(name = "phone_number1", nullable = false, length = 50)
   private String phoneNumber1;

   @Column(name = "phone_number2", length = 50)
   private String phoneNumber2;

   @Column(name = "parent_phone_number", nullable = false, length = 50)
   private String parentPhoneNumber;

   @Column(name = "child_sequence", length = 5)
   private String childSequence;

   @Column(name = "how_many_brothers", length = 5)
   private String howManyBrothers;

   @Column(name = "addrbook_id")
   private Long addrbookId;

   @Column(name = "token", length = 10)
   private String token;

   @Column(name = "expired_token")
   private Date expiredToken;

   @Column(name = "marriage_year", length = 10)
   private String marriageYear;

   @Column(name = "company_id", nullable = false)
   private Long companyId;

   @Column(name = "is_process")
   private Boolean isProcess;

   @Column(name = "is_complete")
   private Boolean isComplete;

   // Join dengan Status Pernikahan
   @ManyToOne
   @JoinColumn(name = "marital_status_id", nullable = false, referencedColumnName = "id")
   private StatusPernikahanEntity maritalStatus;

   // Join Dengan table Identitas_type_id
   @ManyToOne
   @JoinColumn(name = "identity_type_id", nullable = false, referencedColumnName = "id")
   private DataIdentitasEntity identityType;

   // Join dengan table religion
   @ManyToOne
   @JoinColumn(name = "religion_id", referencedColumnName = "id")
   private AgamaEntity religion;

   // Mapping ke table address
   @Embedded
   AddresEntity address;
}

@Embeddable
@Data
class AddresEntity {

   @Column(name = "address1", length = 1000, table = "x_address")
   private String address1;

   @Column(name = "postal_code1", length = 20, table = "x_address")
   private String postalCode1;

   @Column(name = "rt1", length = 5, table = "x_address")
   private String rt1;

   @Column(name = "rw1", length = 5, table = "x_address")
   private String rw1;

   @Column(name = "kelurahan1", length = 100, table = "x_address")
   private String kelurahan1;

   @Column(name = "kecamatan1", length = 100, table = "x_address")
   private String kecamatan1;

   @Column(name = "region1", length = 100, table = "x_address")
   private String region1;

   @Column(name = "address2", length = 1000, table = "x_address")
   private String address2;

   @Column(name = "postal_code2", length = 20, table = "x_address")
   private String postalCode2;

   @Column(name = "rt2", length = 5, table = "x_address")
   private String rt2;

   @Column(name = "rw2", length = 5, table = "x_address")
   private String rw2;

   @Column(name = "kelurahan2", length = 100, table = "x_address")
   private String kelurahan2;

   @Column(name = "kecamatan2", length = 100, table = "x_address")
   private String kecamatan2;

   @Column(name = "region2", length = 100, table = "x_address")
   private String region2;
}
