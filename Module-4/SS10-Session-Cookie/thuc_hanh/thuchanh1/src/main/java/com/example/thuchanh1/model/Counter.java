package com.example.thuchanh1.model;

import javax.persistence.*;

@Entity
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counter_id")
    private int countertId;

    private int counter;

    public Counter() {
    }

    public Counter(int countertId, int counter) {
        this.countertId = countertId;
        this.counter = counter;
    }

    public int getCountertId() {
        return countertId;
    }

    public void setCountertId(int countertId) {
        this.countertId = countertId;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int increment() {
        return counter++;
    }
}
