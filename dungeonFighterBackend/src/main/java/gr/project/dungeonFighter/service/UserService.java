package gr.project.dungeonFighter.service;

import gr.project.dungeonFighter.core.exceptions.AppObjectAccessDeniedException;
import gr.project.dungeonFighter.core.exceptions.AppObjectAlreadyExistException;
import gr.project.dungeonFighter.core.exceptions.AppObjectNotFoundException;
import gr.project.dungeonFighter.core.filters.UserFilters;
import gr.project.dungeonFighter.core.specification.UserSpecification;
import gr.project.dungeonFighter.dto.user.UserChangePasswordDto;
import gr.project.dungeonFighter.dto.user.UserInsertDto;
import gr.project.dungeonFighter.dto.user.UserReadOnlyDto;
import gr.project.dungeonFighter.dto.user.UserUpdateDto;
import gr.project.dungeonFighter.mapper.UserMapper;
import gr.project.dungeonFighter.model.User;
import gr.project.dungeonFighter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserReadOnlyDto saveUser(UserInsertDto insertDto) {
        if (userRepository.findByUsername(insertDto.getUsername()).isPresent()) {
            throw new AppObjectAlreadyExistException("User", "The '" + insertDto.getUsername() + "' is already taken.");
        }

        if (userRepository.findByEmail(insertDto.getEmail()).isPresent()) {
            throw new AppObjectAlreadyExistException("User", "The email " + insertDto.getEmail() + " is already registered.");
        }

        User user = userMapper.toEntity(insertDto);
        user.setPassword(passwordEncoder.encode(insertDto.getPassword()));
        user.setIsActive(true);

        userRepository.save(user);
        return userMapper.toReadOnlyDto(user);
    }

    @Transactional
    public UserReadOnlyDto updateUser(UUID userUuid, UserUpdateDto updateDto) {
        User user = userRepository.findByUuid(userUuid)
                .orElseThrow(() -> new AppObjectNotFoundException("User", "The user " + userUuid + " not found."));

        if (updateDto.getUsername() != null) {
            userRepository.findByUsername(updateDto.getUsername())
                    .filter(existing -> !existing.getUuid().equals(userUuid))
                    .ifPresent(existing -> {
                        throw new AppObjectAlreadyExistException("User", "The username " + updateDto.getUsername() + " is already taken.");
                    });
        }

        if (updateDto.getEmail() != null) {
            userRepository.findByEmail(updateDto.getEmail())
                    .filter(existing -> !existing.getUuid().equals(userUuid))
                    .ifPresent(existing -> {
                        throw new AppObjectAlreadyExistException("User", "The email " + updateDto.getEmail() + " is already registered to another account.");
                    });
        }

        userMapper.toUpdateEntity(updateDto, user);
        return userMapper.toReadOnlyDto(userRepository.save(user));
    }

    @Transactional
    public void changePassword(UUID userUuid, UserChangePasswordDto dto) {
        User user = userRepository.findByUuid(userUuid)
                .orElseThrow(() -> new AppObjectNotFoundException("User", "The user " + userUuid + " not found."));

        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
            throw new AppObjectAccessDeniedException("User", "Invalid old password.");
        }

        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void deactivateUser(UUID userUuid) {
        User user = userRepository.findByUuid(userUuid)
                .orElseThrow(() -> new AppObjectNotFoundException("User", "The user " + userUuid + " was not found."));

        user.setIsActive(false);
        userRepository.save(user);
    }

    @Transactional
    public Page<UserReadOnlyDto> getAllFilteredPageableUsers(Pageable pageable, UserFilters filters) {
        Specification<User> spec = Specification.allOf(
                UserSpecification.searchByUsernameOrEmail(filters.getSearch()),
                UserSpecification.isActive(filters.getIsActive())
        );

        return userRepository.findAll(spec, pageable).map(userMapper::toReadOnlyDto);
    }
}
