package com.beom.blog.service;

import com.beom.blog.model.User;
import com.beom.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public int join(User user) {
        try {
             userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
