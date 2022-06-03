package Spring.Entity;

import javax.persistence.*;

@Entity //해당 클래스를 에티티로 사용[DB 내 테이블과 매핑]
@Table(name = "test") //DB 에서 사용될 테이블 이름 정하기. 생략하면 클래스명이 테이블명.
public class TestEntity { //클래스
    @Id //기본키 설정 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI 자동번호
    public int no;
    @Column //DB 에서 사용할 필드
    public String content;

}
//jpa : 클래스를 DB 테이블 처럼 사용하자
    //1. JAVA 클래스를 엔티티화 하면 DB 테이블 자동생성
    //java <-----------JPA 매핑-----------> DB
    //entity 클래스                        table
    //  필드                               필드
    //예)게시물번호  <------연결-------    게시물번호
    //   게시물내용  <------연결-------  게시물 내용