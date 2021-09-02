package com.example.demo.Control;

import com.example.demo.Model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Tran Thien Trong
 * @Date: 2/9/2021
 * @Desc: This class is model hold person information
 * */

@Repository(value = "registerDAO")
@RepositoryRestResource(path="registers")
@Transactional
public class RegisterDAO implements JpaRepository<Register, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RegisterDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }



    public void addRegister(Register register) {
        Register newRegister = entityManager.merge(register);
    }


    /*___________________________ RETRIEVE ___________________________*/
    @Override
    public List<Register> findAll() {
        Query<Register> query = (Query<Register>) entityManager.createQuery("from Register");
        return query.getResultList();
    }

    @Override
    public Register getById(Integer id) {
        return entityManager.find(Register.class, id);
    }



    /*___________________________ DELETE ___________________________*/
    @Override
    public void deleteById(Integer id) {
        Query<Register> query = (Query<Register>) entityManager.createQuery("DELETE FROM Register WHERE id=:personId");
        query.setParameter("personId",id);
        query.executeUpdate();
    }


    /*___________________________ UPDATE ___________________________*/
    @Override
    public <S extends Register> S save(S register) {
        Register newRegister = entityManager.merge(register);
        register.setId(newRegister.getId());
        return register;
    }

    @Override
    public <S extends Register> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Register> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Register> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Register> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Register> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Register getOne(Integer integer) {
        return null;
    }


    @Override
    public <S extends Register> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Register> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Register> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Register> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Register> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Register> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public List<Register> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Register> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Register> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Register register) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Register> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
