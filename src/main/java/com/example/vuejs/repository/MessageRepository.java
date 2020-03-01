package com.example.vuejs.repository;

import com.example.vuejs.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message, Long> {

}
