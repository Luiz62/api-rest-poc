package luiz62.com.github.apirest.resources;

import lombok.RequiredArgsConstructor;
import luiz62.com.github.apirest.domain.dto.UserDTO;
import luiz62.com.github.apirest.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(service.create(dto).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
