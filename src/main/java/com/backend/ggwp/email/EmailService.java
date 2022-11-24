package com.backend.ggwp.email;

public interface EmailService {
    String sendSimpleMessage(String to) throws Exception;
}
