package com.antigaspillage.demo.dao;

import com.antigaspillage.demo.data.Role;
import com.antigaspillage.demo.data.Trader;
import com.antigaspillage.demo.data.User;
import com.antigaspillage.demo.form.AppTraderForm;
import com.antigaspillage.demo.form.AppUserForm;
import com.antigaspillage.demo.repository.TraderRepository;
import com.antigaspillage.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class TraderDAOImpl implements ITraderDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private TraderRepository traderRepository;

    @Override
    public List<Trader> findAll() {
        return null;
    }

    @Override
    public void add(Trader trader) {

    }

    @Override
    public Trader findByRef(Long id) {
        return entityManager.getReference(Trader.class, id);
    }


    public Trader addNewTrader(AppTraderForm form, User user) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());


        String companyName = form.getCompanyName();
        String localisation = form.getLocation();
        String description = form.getDescription();

        List<Role> roleList = entityManager.createQuery("select r from Role r where r.name='USER_CLIENT'").getResultList();
        Role role = roleList.get(0);


        Long lastId = nextUserId();

        Trader trader = new Trader(user, companyName, localisation, description, timestamp);

        return trader;
    }

    public Long nextUserId(){
        Long idRole = entityManager.createQuery("select max(t.id) from Trader t", Long.class).getSingleResult();
        if (idRole == null)
            return Long.valueOf(1);
        else
            return idRole+1;
    }

    @Override
    public Trader findByName(String name) {
        return null;
    }

    @Override
    public void delete(Trader role) {

    }
}
