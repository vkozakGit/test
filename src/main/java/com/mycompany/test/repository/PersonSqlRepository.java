package com.mycompany.test.repository;


import com.mycompany.test.entity.PersonsSql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSqlRepository extends JpaRepository<PersonsSql, Long> {

}
