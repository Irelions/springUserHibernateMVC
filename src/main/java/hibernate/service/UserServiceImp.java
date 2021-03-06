package hibernate.service;

import hibernate.dao.UserDao;
import hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User showUser(int id) {
      return userDao.showUser(id);
   }

   @Transactional
   @Override
   public void delete(int id) {
      userDao.delete(id);
   }

   @Transactional
   @Override
   public void update(int id, User user) {
      userDao.update(id, user);
   }
}
