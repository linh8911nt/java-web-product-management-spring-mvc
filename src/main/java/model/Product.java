package model;

import java.util.List;

public class Product {
    private int id;
    private String code;
    private String name;
    private double price;
    private int category_id;
    private String category;
    List<Integer> categories_id;

    public Product() {
    }

    public Product(int id, String code, String name, double price,int category_id, String category, List<Integer> categories_id) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.category_id = category_id;
        this.category = category;
        this.categories_id = categories_id;
    }

    public List<Integer> getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(List<Integer> categories_id) {
        this.categories_id = categories_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
