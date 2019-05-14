package by.it.group673602.kozlovskaya.lab6_7.src.main.java.app.domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



@Embeddable
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {
    @Enumerated(EnumType.STRING)
    private City actualCity;
    private String actualAddress;
    @Enumerated(EnumType.STRING)
    private City releaseCity;
    private String releaseAddress;
}
