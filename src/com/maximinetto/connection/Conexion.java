/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.connection;

import com.maximinetto.entities.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Administrador
 */
public class Conexion {
    
    private Conexion() {
    }
    
    public static Conexion getInstance() {
        return ConexionHolder.INSTANCE;
    }
    
    private static class ConexionHolder {

        private static final Conexion INSTANCE = new Conexion();
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tarea1");
        private static final EntityManager em = emf.createEntityManager();
        
        
        
    }

    public EntityManager getEntityManager(){
            return ConexionHolder.em;
    }
    
    public void persist(Object object) {
        
        getEntityManager().getTransaction().begin();
        try {
            getEntityManager().persist(object);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } 
    }
    
    public void merge(Object object) {
        
        getEntityManager().getTransaction().begin();
        try {
            getEntityManager().merge(object);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } 
    }
    
     public void refresh(Object object) {
        
        getEntityManager().getTransaction().begin();
        try {
            getEntityManager().refresh(object);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } 
    }
     
    public <T> List<T> select(String hql, Class<T> clase){
        List<T> objects = null;
        getEntityManager().getTransaction().begin();
        try{
            objects = getEntityManager().createQuery(hql, clase).getResultList();
            getEntityManager().getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
        
        return objects;
        
    }  
    
    public <K,V> Map<List<K>, V> pageable(Class<K> clase, int pageSize, long firstResult){
        Session session = getEntityManager().unwrap(Session.class);
        Criteria criteria = session.createCriteria(clase);
        criteria.setFirstResult((int) firstResult);
        criteria.setMaxResults(pageSize);
        List<K> listPage = criteria.list();
        
        Criteria criteriaCount = session.createCriteria(clase);
        criteriaCount.setProjection(Projections.rowCount());
        V count = (V) criteriaCount.uniqueResult();
        Map<List<K>,V> mapa = new HashMap<>(listPage.size());
        mapa.put(listPage, count);
        return mapa;
    }
    
    public <T> List<T> find(String hql, Class<T> clase, Map<String, Object> valores){
        List<T> objects = null;
        getEntityManager().getTransaction().begin();
        try{
            TypedQuery<T> query = getEntityManager().createQuery(hql, clase);
            
            valores.forEach((key, value) -> {
                query.setParameter(key, value);
            });
            
            objects = query.getResultList();
            getEntityManager().getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
        
        return objects;
    }
}
