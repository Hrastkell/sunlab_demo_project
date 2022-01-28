package kz.sunlab.demo.service;

import kz.sunlab.demo.dto.ApplyResponse;
import kz.sunlab.demo.model.User;
import kz.sunlab.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public ApplyResponse saveUser(User user) {
        User savedUser = userRepository.save(user.toUserEntity()).toUser();
        ApplyResponse response = new ApplyResponse();
        if (savedUser.getId() != null) {
            response.setStatusMessage(String.format("user is saved with id = %d", savedUser.getId()));
        }
        return response;
    }
}
