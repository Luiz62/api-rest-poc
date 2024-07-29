package luiz62.com.github.apirest.service.impl;

import lombok.RequiredArgsConstructor;
import luiz62.com.github.apirest.domain.dto.UserDTO;
import luiz62.com.github.apirest.domain.entity.UserEntity;
import luiz62.com.github.apirest.repository.UserRepository;
import luiz62.com.github.apirest.service.IUserService;
import luiz62.com.github.apirest.service.exceptions.DataIntegratyViolationException;
import luiz62.com.github.apirest.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements IUserService {

    private final UserRepository repository;

    private final ModelMapper mapper;

    @Override
    public UserEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public UserEntity create(UserDTO userDTO) {
        findByEmail(userDTO);
        return repository.save(mapper.map(userDTO, UserEntity.class));
    }

    @Override
    public void findByEmail(UserDTO userDTO) {
        Optional<UserEntity> userEntity = repository.findByEmail(userDTO.getEmail());
        if (userEntity.isPresent()) {
            throw new DataIntegratyViolationException("E-mail ja cadastrado no sistema");
        }
    }
}
