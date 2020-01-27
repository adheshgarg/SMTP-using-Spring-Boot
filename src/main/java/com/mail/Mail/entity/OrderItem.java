package com.mail.Mail.entity;

import lombok.Data;

@Data
public class OrderItem {
    private String orderId;
    private String merchantId;
    private String productId;
    private String productName;
    private String imageUrl;
    private int quantityBrought;
    private double productPrice;

    public String getImageUrl() {
        return imageUrl;
    }
}
