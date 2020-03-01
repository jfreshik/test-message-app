package com.example.vuejs.service;

import com.example.vuejs.model.Message;
import com.example.vuejs.repository.MessageRepository;
import com.example.vuejs.security.SecurityCheck;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository repository;

    public MessageService(MessageRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Message> getMessages() {
        return repository.findAll();
    }

    @SecurityCheck
    @Transactional(noRollbackFor = { UnsupportedOperationException.class })
    public Message save(String text){
        return repository.save(new Message(text));
    }

    @SecurityCheck
    @Transactional
    public boolean remove(Long id) {
        repository.deleteById(id);
        return true;
    }
}
