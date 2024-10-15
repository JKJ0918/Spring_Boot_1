package org.zerock.memberboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity // 테이블 담당
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity{

    @Id
    private String email ;  // 이메일로 로그인

    private String password ;  // 암호 처리

    private String name ;  // 사용자명
    //Hibernate:
    //        create table member (
    //        email varchar(255) not null,
    //        moddate datetime(6),
    //        reg_date datetime(6),
    //        name varchar(255),
    //        password varchar(255),
    //        primary key (email)
    //        ) engine=InnoDB

}



