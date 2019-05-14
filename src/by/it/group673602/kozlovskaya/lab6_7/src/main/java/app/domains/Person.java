package by.it.group673602.kozlovskaya.lab6_7.src.main.java.app.domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;


@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer login;
    @NotNull
    @Pattern(regexp = "\\s{0,1}[A-ZА-ЯЁ]{1,1}[a-zа-яё]{2,}(-{0,1}[A-ZА-ЯЁ]{1,1}[a-zа-яё]{2,}){0,1}")
    private String lastName;
    @Pattern(regexp = "\\s{0,1}[A-ZА-ЯЁ]{1,1}[a-zа-яё]{2,}")
    private String firstName;
    @Pattern(regexp = "\\s{0,1}[A-ZА-ЯЁ]{1,1}[a-zа-яё]{2,}")
    private String thirdName;

    private Passport passport;

    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Address address;

    @Enumerated(EnumType.STRING)
    private Nationality nation;

    @Pattern(regexp = "\\+?\\d+([\\(\\s\\-]?\\d+[\\)\\s\\-]?[\\d\\s\\-]+)?")
    private String phone;

    private String homePhone;

}
