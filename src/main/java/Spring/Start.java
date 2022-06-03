package Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class);
    }
    
    
}
/*
    패키지 구조
        1.src
            2.main
                3.java :백엔드
                    4.root 패키지[임의]
                        5.controller 패키지
                          dto 패키지
                          dao(entity) 패키지
                          service 패키지
                          Start 클래스
                3. resources : 프론트엔드, 설정파일
                    4. static : css, js, img
                       templates : html
 */
//스프링 : java를 이용한 미리 만들어진 다양한 API들
    //스프링부트 : 스프링 API 중 자주 사용되는 API들 기본 셋팅을 해줌
        //@SpringBootApplication
        //1. MVC 컴포넌트 기본값 셋팅
        //2. 톰캣 내장 서버 지원
        //3. RESTful API : HTTP(URL)를 이용한 자원공유
    //1. SpringApplication.run(Start.class); 스프링 실행

    //2. 타임리프 : 템플릿 엔진(정적문서에 데이터를 넣어주는 프로그램)
        //템플릿엔진
            //백엔드 : JSP(스프링에서는 권장하지 않음 -> 확장자가 War 이기 때문), 타임리프, 머스테치(스프링 공식)
            //프론트엔드 : HTML, JS, REACT, Vue.js
        //백엔드(java,spring) : DB 처리, RESTFUL API 제작
        //프론트엔드 JS : RESTFUL API URL을 이용한 데이터 교환

    //1. view <-----템플릿엔진----->controller
        //스프링
        //1.클라이언트가 URL 을 요청했을 경우

    //3. 데이터베이스
        //1.DAO : 순수자바형식 SQL 작성
        //2.SQL Mapper [XML방식] : MyDatis(DBMS)
        //3.JPA : JDBC (JAVA-DB) API
            //SQL암기 -> 힘들다 -> sql문법을 java문법으로 바꿔서 사용
            //사용목적 : sql 작성코드 줄이기~! 하지만 한계가 있음

    //Spring Data JPA
    //MySQL Driver