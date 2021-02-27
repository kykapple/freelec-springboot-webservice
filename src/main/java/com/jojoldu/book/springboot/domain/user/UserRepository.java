package com.jojoldu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Spring Data JPA를 사용하기 위해 JpaRepository 인터페이스를 상속받은 interface를 생성
// JpaRepository 인터페이스를 구현하는 객체는 자동으로 Bean으로 등록 + 기본적인 CRUD 메소드가 자동으로 생성됨
// @Repository 추가할 필요x  // Entity클래스와 함께 위치해야함
public interface UserRepository extends JpaRepository<User, Long> {   // <>안에는 엔티티 클래스 이름과 PK(ID) 필드 타입 지정
    Optional<User> findByEmail(String email);
}
