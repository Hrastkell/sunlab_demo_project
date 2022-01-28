package kz.sunlab.demo.service;

import kz.sunlab.demo.dto.ApplyResponse;
import kz.sunlab.demo.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
     ApplyResponse saveUser(User user);
}
