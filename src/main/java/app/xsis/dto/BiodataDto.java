package app.xsis.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class BiodataDto {
   private Long id;
   private String fullName;
   private String nickName;
   private String pob;
   private Date dob;
   private Integer gender;
   private Integer hight;
   private Integer weight;
   private String nationality;
   private String ethnic;
   private String hobby;
   private String email;
   private String identityNo;
   private String phoneNumber1;
   private String phoneNumber2;
   private String parentPhoneNumber;
   private String childSequence;
   private String howManyBrothers;
   private Long addrbookId;
   private String token;
   private Date expiredToken;
   private String marriageYear;
   private Long companyId;
   private Boolean isProcess;
   private Boolean isComplete;
   private Long maritalStatus;
   private Long identityType;
   private Long religion;
   private String address1;
   private String postalCode1;
   private String rt1;
   private String rw1;
   private String kelurahan1;
   private String kecamatan1;
   private String region1;
   private String address2;
   private String postalCode2;
   private String rt2;
   private String rw2;
   private String kelurahan2;
   private String kecamatan2;
   private String region2;

}
