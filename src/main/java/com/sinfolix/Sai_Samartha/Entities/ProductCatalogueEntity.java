package com.sinfolix.Sai_Samartha.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalogueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    private int quantity;
    private int price;
    private int discount;
    private String companyName;
    private String medicineName;
    private int minAge;
    private int maxAge;
    private int realMrp;
    private int discountMrp;
    private String prodDescription;
    private String comments;
    private  List<String> categories = new ArrayList<>();

}
