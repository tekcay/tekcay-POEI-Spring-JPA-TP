package com.example.tp.service;

import com.example.tp.entity.ToDo;
import com.example.tp.interfaces.IDAO;

import com.example.tp.tools.ServiceHibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService implements IDAO<ToDo> {

    private ServiceHibernate serviceHibernate;
    private Session session;

    public ToDoService(ServiceHibernate serviceHibernate) {
        this.serviceHibernate = serviceHibernate;
        session = this.serviceHibernate.getSession();
    }


    @Override
    public boolean add(ToDo o) {
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean modify(ToDo o) {
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean remove(ToDo o) {
        session.beginTransaction();
        session.remove(o);
        session.getTransaction().commit();
        return true;
    }

    /**
     * @param isDone
     * @return all the {@code ToDo}s whether they are {@code done} or not
     */
    public List<ToDo> getToDos(boolean isDone) {
        return session.createQuery("SELECT p FROM todo WHERE p.isDone = " + isDone, ToDo.class).getResultList();
    }



}
