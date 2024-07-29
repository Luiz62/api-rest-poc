package luiz62.com.github.apirest.resources;

import lombok.RequiredArgsConstructor;
import luiz62.com.github.apirest.domain.UserEntity;
import luiz62.com.github.apirest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserResource {

    private final IUserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
