package com.yourbank.model.client;

public class Client {

    private final String name;

    public Client(String name) {
        this.name = validateName(name);
    }

    public String getName() {
        return name;
    }

    private String validateName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return name.trim();
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}
