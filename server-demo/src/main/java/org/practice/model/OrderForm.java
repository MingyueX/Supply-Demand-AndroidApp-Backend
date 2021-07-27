package org.practice.model;

import java.math.BigDecimal;

public class OrderForm {
    Integer id;
    Integer uidPost;
    Integer uidRespond;
    Integer postId;
    BigDecimal price;
    String context;
    enum status{
        CANCELED,
        UNPAID,
        PAID,
        FINISHED,
        REFUNDING,
        REFUNDED
    };
    enum delivery{
        EXPRESS,
        FACETOFACE
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUidPost() {
        return uidPost;
    }

    public void setUidPost(Integer uidPost) {
        this.uidPost = uidPost;
    }

    public Integer getUidRespond() {
        return uidRespond;
    }

    public void setUidRespond(Integer uidRespond) {
        this.uidRespond = uidRespond;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
