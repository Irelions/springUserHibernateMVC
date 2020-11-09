package hibernate.dao;

import hibernate.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().saveOrUpdate(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("FROM User");
      return query.getResultList();
   }

   @Override
   public User showUser(int id) {
      return sessionFactory.getCurrentSession().get(User.class, (long)id);
   }

   @Override
   public void delete(int id) {
      sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(User.class, (long)id));
   }

   @Override
   public void update(int id) { ;
   }
}
