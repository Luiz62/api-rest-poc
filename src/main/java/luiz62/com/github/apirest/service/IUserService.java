package luiz62.com.github.apirest.service;

import luiz62.com.github.apirest.domain.entity.UserEntity;

public interface IUserService {
    UserEntity findById(Long id);
}
