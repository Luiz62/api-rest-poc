package luiz62.com.github.apirest.service;

import luiz62.com.github.apirest.domain.UserEntity;

public interface IUserService {
    UserEntity findById(Long id);
}
