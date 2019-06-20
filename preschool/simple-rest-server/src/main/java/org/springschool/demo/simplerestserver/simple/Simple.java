package org.springschool.demo.simplerestserver.simple;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Simple {

    @Id
    @GeneratedValue
    private Long id;

    private String dataString;
    private Integer dataInteger;

}
