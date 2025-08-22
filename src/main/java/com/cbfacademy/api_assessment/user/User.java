package com.cbfacademy.api_assessment.user;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String first_name;
    private String last_name;


    public User(){
        this("First Name", "Last Name");
    };

    public User(UUID id, String firstName, String lastName){
        this.id = id;
        this.first_name = firstName;
        this.last_name = lastName;
    }
    public User(String firstName, String lastName){
        this.first_name = firstName;
        this.last_name = lastName;
    }

    public String getFirstName(){
        return first_name;   
    }

    public String getLastName(){
        return last_name;   
    }

    public UUID getUserId(){
        return id;   
    }

    public void setFirstName(String firstName){
        this.first_name = firstName;
    }

    public void setLastName(String lastName){
        this.last_name = lastName;
    }
}
