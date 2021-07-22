package springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springcourse.dao.PersonDao;
import springcourse.dao.PersonDaoImpl;
import springcourse.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Component
@Repository
public class UserServiceImpl {

    @Autowired
    private PersonDao personDao;
    public List<User> index() {
        return personDao.index();
    }

    public User show(int id) {
        return personDao.show(id);
    }

    public void save(User user) {
        personDao.save(user);
    }

    public void update(int id, User updatedPerson) {
        personDao.update(id, updatedPerson);
    }

    public void delete(int id) {
        personDao.delete(id);
    }

}
