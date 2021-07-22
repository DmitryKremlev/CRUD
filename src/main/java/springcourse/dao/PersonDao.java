package springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springcourse.models.User;
import springcourse.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Component

public class PersonDao {

    @Autowired
    private UserService userService;


    public List<User> index() {
        return userService.index();
    }

    public User show(int id) {
        return userService.show(id);
    }

    public void save(User user) {
        userService.save(user);
    }

    public void update(int id, User updatedPerson) {
        userService.update(id, updatedPerson);
    }

    public void delete(int id) {
        userService.delete(id);
    }
}
