package dem.alex.staffsalary.services;

import dem.alex.staffsalary.models.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService extends UserRandomizer {

    private Map<Long, User> usersCache;

    @PostConstruct
    private void initCache(){
        usersCache = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            usersCache.put((long) i, getRandomUser(i));
        }
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(usersCache.values());
    }

    public User getUserById(final long id) {
        return usersCache.get(id);
    }
}
