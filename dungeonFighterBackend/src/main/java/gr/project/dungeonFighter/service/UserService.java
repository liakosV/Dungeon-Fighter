package gr.project.dungeonFighter.service;

import gr.project.dungeonFighter.mapper.UserMapper;
import gr.project.dungeonFighter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;


}
