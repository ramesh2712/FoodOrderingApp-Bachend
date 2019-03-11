package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;
    public CustomerEntity createCustomer (CustomerEntity customerEntity){
        entityManager.persist(customerEntity);
        return customerEntity;

    }

    public CustomerEntity contactCheck (CustomerEntity customerEntity){
        try{
            return entityManager.createNamedQuery("contactNumber", CustomerEntity.class).setParameter("number",customerEntity.getContactNumber())
                    .getSingleResult();
        }catch(NoResultException nre){
            return null;
        }


    }
}
