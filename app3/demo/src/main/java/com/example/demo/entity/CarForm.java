package com.example.demo.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CarForm {

    @NotNull(message = "brand is required")
    @Size(min = 2, message = "min is 2")
    private String brand;

    @NotNull(message = "name is required")
    @Size(min = 2, message = "min is 2")
    private String name;

    @NotNull(message = "year is required")
    @Max(value = 2023, message = "max value is 2023")
    @Min(value = 2000, message = "min value is 2000")
    private int year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
