package luiz62.com.github.apirest.resources;

import lombok.RequiredArgsConstructor;
import luiz62.com.github.apirest.domain.dto.UserDTO;
import luiz62.com.github.apirest.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserResource {

    private final IUserService service;

    private final ModelMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(mapper.map(service.findAll(), new TypeToken<List<UserDTO>>() {}.getType()));
    }
}
