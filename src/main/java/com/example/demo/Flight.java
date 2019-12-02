package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 3)
    private String departingAirport;

    @NotNull
    @Size(min = 3)
    private String arrivingAirport;

    @NotNull
    @Size(min = 3)
    private String airline;

    @NotNull
    @Min(1)
    private int price;

    @NotNull
    @Size(min = 5)
    private String date;

    @NotNull
    @Size(min = 1)
    private String flightNumber;

    @NotNull
    @Size(min = 1)
    private String type;

    private String flightshot;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartingAirport() {
        return departingAirport;
    }

    public void setDepartingAirport(String departingAirport) {
        this.departingAirport = departingAirport;
    }

    public String getArrivingAirport() {
        return arrivingAirport;
    }

    public void setArrivingAirport(String arrivingAirport) {
        this.arrivingAirport = arrivingAirport;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlightshot() {
        return flightshot;
    }

    public void setFlightshot(String flightshot) {
        this.flightshot = flightshot;
    }
}
