package com.cbfacademy.api_assessment.order;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String symbol;
    private double price;
    private int volume;
    private String side;
    private Instant timestamp;

    public Order (){};

    public Order(UUID id, String symbol, double price, int volume, String side, Instant timestamp){
        this.id = id;
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.side = side;
        this.timestamp = timestamp;
    }

    //Getters and Setters
    public UUID getOrderId(){
        return id;
    }


    public String getSymbol(){
        return symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getVolume(){
        return volume;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public String getSide(){
        return side;
    }

    public void setSide(String side){
        this.side = side;
    }

    public Instant getTimestamp(String side){
        return timestamp;
    }

    public void setTimestamp(Instant timestamp){
        this.timestamp = timestamp;
    }
}
