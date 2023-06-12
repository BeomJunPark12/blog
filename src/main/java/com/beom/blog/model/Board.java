package com.beom.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob    // 대용량 데이터
    private String content; // 섬머노트 라이브러리 사용 예정

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)  // 연관관계 주인이 아님(FK아님), DB에 컬럼을 만들지 마세ㄹ
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
