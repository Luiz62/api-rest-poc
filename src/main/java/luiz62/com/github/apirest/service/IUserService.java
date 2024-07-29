package luiz62.com.github.apirest.service;

import luiz62.com.github.apirest.domain.dto.UserDTO;
import luiz62.com.github.apirest.domain.entity.UserEntity;

import java.util.List;

public interface IUserService {
    UserEntity findById(Long id);

    List<UserEntity> findAll();

    UserEntity create(UserDTO userDTO);
}
