package com.innowise.repository;

import com.innowise.domain.Message;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
