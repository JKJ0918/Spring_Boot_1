package org.zerock.memberboard.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer") // writer는 문자열 처리를 제외
public class Board extends BaseEntity {

    @Id // pk 선언 및 자동번호 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY) // 지연로딩 fk 설정(나는 많고 상대편은 1개이다.)
    private Member writer; //부모

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content){
        this.content = content;
    }

    //Hibernate:
    //        create table board (
    //        bno bigint not null auto_increment,
    //        moddate datetime(6),
    //        reg_date datetime(6),
    //        content varchar(255),
    //        title varchar(255),
    //        writer_email varchar(255),
    //        primary key (bno)
    //        ) engine=InnoDB

    //Hibernate:
    //        alter table if exists board
    //        add constraint FK1iu8rhoim4thb0y12cpt01oiu
    //        foreign key (writer_email)
    //        references member (email)


}
