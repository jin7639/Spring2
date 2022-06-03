package Spring.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {
    //JpaRepository 클래스로부터 상속<엔티티명, pk자료형>
}

    //1. save(엔티티) : 해당 엔티티를 DB INSERT

    //트랜잭션 [ DB 용어 ]
        //1. SQL 실행 결과는 성공 / 실패 중 하나
        //2. 트랜잭션 특징
            //원자성 : Commit 아니면 Rollback 둘 중 하나여야함
            //일관성 : 결과가 일관적이어야 함
            //독립성 : 다른 트랜잭션에 대해 독립적
            //지속성 : 결과는 영구저장

        //3. JPA
            //
