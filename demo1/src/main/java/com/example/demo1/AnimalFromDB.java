package com.example.demo1;

import com.google.gson.Gson;
import enitity.Animal;

import javax.persistence.*;
import javax.ws.rs.*;
import java.util.List;
import java.util.Random;

@Path("/animal_db")
public class AnimalFromDB {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");


    @Path("/animalfromdb")
    @GET
    @Produces("application/json")
    public String getAnimal(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a",Animal.class);
            List<Animal> animalList = query.getResultList();
            return new Gson().toJson(animalList);
        } finally {
            em.close();
        }
    }

    @Path("/animalbyid/{id}")
    @GET
    @Produces("application/json")
    public String getAnimalByID(@PathParam("id") int id){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a WHERE a.pid = :id",Animal.class);
            query.setParameter("id",id);
            Animal animal = query.getSingleResult();
            return new Gson().toJson(animal);
        } finally {
            em.close();
        }
    }

    @Path("/animalbytype/{type}")
    @GET
    @Produces("application/json")
    public String getAnimalByType(@PathParam("type") String type){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a WHERE a.animal =:type",Animal.class);
            query.setParameter("type",type);
            Animal animal = query.getSingleResult();

            //Fix Null
            if(animal.getId() == null){
                return "Sut";
            }
            return new Gson().toJson(animal);
        } finally {
            em.close();
        }
    }

    @Path("/randomanimal")
    @GET
    @Produces("application/json")
    public String randomAnimal(){
        EntityManager em = emf.createEntityManager();
        try{
            Query counter = em.createQuery("SELECT COUNT(a.pid) FROM Animal a");
            Long counterRes = (Long) counter.getSingleResult();
            double rnd = Math.floor(Math.random()*counterRes+1);
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a WHERE a.pid=:id",Animal.class);
            query.setParameter("id", rnd);
            Animal animal = query.getSingleResult();

            return new Gson().toJson(animal);
        } finally {
            em.close();
        }
    }



}