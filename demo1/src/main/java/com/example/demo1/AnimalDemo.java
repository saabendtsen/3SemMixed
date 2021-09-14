package com.example.demo1;

import com.google.gson.Gson;
import model.AnimalNoDB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/animals")
public class AnimalDemo {
    @GET
    @Produces("text/plain")
    public String getVuf() {
        return "Vuf, from hund";
    }


    @Path("/animal_list")
    @GET
    @Produces("application/json")
    public String getAnimals(){
        return  "[\"Dog\", \"Cat\", \"Mouse\", \"Bird\"]";
    }

    @Path("/animal")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimal(){
        AnimalNoDB animal = new AnimalNoDB("Hund","Miaw");
        return new Gson().toJson(animal);
    }
}