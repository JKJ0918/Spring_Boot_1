package org.zerock.memberboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 직접적으로 테이블을 생성 하지 않는 엔티티임
@EntityListeners(value = {AuditingEntityListener.class}) // 감시체제용  (등록이냐 수정이냐)
@Getter
abstract class BaseEntity { // 모든 엔티티의 부모로 날짜 처리용을 담당함.

    @CreatedDate // 생성시간
    @Column(name = "regDate", updatable = false) // 테이블의 필드명 지정, 업데이트 하지 말것
    private LocalDateTime regDate ; // 등록일 담당

    @LastModifiedDate // 수정시간
    @Column(name = "moddate", updatable = true) // ????????????코드 체크
    private LocalDateTime modDate ; // 수정일 담당

}
