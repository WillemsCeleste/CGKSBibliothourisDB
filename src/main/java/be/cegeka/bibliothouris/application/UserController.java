package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
@Transactional
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping
    @Secured("ROLE_ADMIN")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void addRegisteredUser(@RequestParam(value = "name", required = true) String name,
                        @RequestParam(value = "password", required = true) String password) {
        userService.addUser(name, password);
    }

}
