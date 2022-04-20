package com.mall.entry;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author weijie liu
 * @since 2022-02-10
 */
@Data
@Entity(name = "user")
@Component
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;
    @Column(columnDefinition = "user_name")
    private String userName;
    @Column(columnDefinition = "pass_word")
    private String passWord;
    @Column(columnDefinition = "birth_date")
    private Date birthDate;
    @Column(columnDefinition = "country")
    private String country;
    @Column(columnDefinition = "city")
    private String city;
    @Column(columnDefinition = "town")
    private String town;
}
