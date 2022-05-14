package com.antigaspillage.demo.dao;

import com.antigaspillage.demo.data.Role;
import com.antigaspillage.demo.data.User;
import com.antigaspillage.demo.form.AppUserForm;
import com.antigaspillage.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

@Repository
@Transactional
public class UserDAOImpl implements IUserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    public User createAppUser(AppUserForm form) {

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        List<Role> listRole =  entityManager.createQuery("select r from Role r where r.name = 'USER_CLIENT'").getResultList();
        List<User> userList = userRepository.findAll();
        User user = new User();

        String firstname = form.getFirstname();
        String lastname = form.getLastname();
        String email = form.getEmail();
        String phoneNumber = form.getPhoneNumber();
        String adresse = form.getAdresse();
        String encrytedPassword = this.passwordEncoder.encode(form.getPassword());

        List<Role> roleList = entityManager.createQuery("select r from Role r where r.name='USER_CLIENT'").getResultList();
        Role role = roleList.get(0);



        Long lastId = nextUserId();
        if (form.getPassword()== form.confirmPassword && form.getPassword().length()>8)
            user = new User(lastId, firstname, lastname, adresse, email, phoneNumber, encrytedPassword, timestamp, role);
        else
            user = null;

        return user;
    }

    public Long nextUserId(){
        Long idRole = entityManager.createQuery("select max(u.id) from User u", Long.class).getSingleResult();
        if (idRole == null)
            return Long.valueOf(1);
        else
            return idRole+1;
    }

    @Override
    public List<User> findAll() {
        Query query = entityManager.createQuery("select u from User u");
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findByEmail(String email) {
        return entityManager.getReference(User.class, email);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }
}
