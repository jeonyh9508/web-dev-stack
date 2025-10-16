package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners( AuditingEntityListener.class ) // JPA Auditing을 활성화하여 생성/수정 시간 자동 처리
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    // 생성 시간을 자동으로 감지 -> jpa에 매핑
    @CreatedDate
    private Date created;

    // 수정 시간을 자동으로 감지 -> jpa에 매핑
    @LastModifiedDate
    private Date updated;
    private Integer member_id;
}
