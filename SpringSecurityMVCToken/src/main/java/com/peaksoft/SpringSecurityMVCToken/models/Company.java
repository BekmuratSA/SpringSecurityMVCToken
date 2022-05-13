package com.peaksoft.SpringSecurityMVCToken.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(generator = "company_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "company_gen", sequenceName = "company_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true, length = 30)
    private String companyName;
    private String locatedCountry;
    private LocalDateTime created;
}
