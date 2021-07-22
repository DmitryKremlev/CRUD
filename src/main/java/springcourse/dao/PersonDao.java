package springcourse.dao;

import springcourse.models.User;

import java.util.List;

public interface PersonDao {
    public List<User> index();
    public User show(int id);
    public void save(User user);
    public void update(int id, User updatedPerson);
    public void delete(int id);
}
