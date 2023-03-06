package com.example.addressbook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Getter
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
