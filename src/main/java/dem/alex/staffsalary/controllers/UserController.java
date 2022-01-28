package dem.alex.staffsalary.controllers;

import dem.alex.staffsalary.models.User;
import dem.alex.staffsalary.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping( value = "api/users", produces = "application/json")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping()
    public List<User> getUsers(){
        return  userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") final Long userId) {
        return userService.getUserById(userId);
    }

}
