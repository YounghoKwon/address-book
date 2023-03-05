package com.example.addressbook.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;

    private Integer cellPhone;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @CreatedDate
    private LocalDateTime createTime;

    public Address(Long idx, String name, Integer cellPhone) {
        this.idx = idx;
        this.name = name;
        this.cellPhone = cellPhone;
    }

}
