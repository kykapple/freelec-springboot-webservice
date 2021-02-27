package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Spring Data JPA를 사용하기 위해 JpaRepository 인터페이스를 상속받은 interface를 생성
// JpaRepository 인터페이스를 구현하는 객체는 자동으로 Bean으로 등록 + 기본적인 CRUD 메소드가 자동으로 생성됨
// @Repository 추가할 필요x  // Entity클래스와 함께 위치해야함
public interface PostsRepository extends JpaRepository<Posts, Long> {  // <>안에는 엔티티 클래스 이름과 PK(ID) 필드 타입 지정

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")  // 사용자가 직접 쿼리 지정 가능
    List<Posts> findAllDesc();
}
