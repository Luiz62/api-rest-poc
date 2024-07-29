package luiz62.com.github.apirest.service.impl;

import lombok.RequiredArgsConstructor;
import luiz62.com.github.apirest.domain.entity.UserEntity;
import luiz62.com.github.apirest.repository.UserRepository;
import luiz62.com.github.apirest.service.IUserService;
import luiz62.com.github.apirest.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements IUserService {

    private final UserRepository repository;

    @Override
    public UserEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
