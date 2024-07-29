package luiz62.com.github.apirest.service;

import luiz62.com.github.apirest.domain.dto.UserDTO;
import luiz62.com.github.apirest.domain.entity.UserEntity;

import java.util.List;

public interface IUserService {
    UserEntity findById(Long id);

    List<UserEntity> findAll();

    UserEntity create(UserDTO userDTO);

    UserEntity update(UserDTO userDTO);

    void delete(Long id);

    void findByEmail(UserDTO userDTO);
}
