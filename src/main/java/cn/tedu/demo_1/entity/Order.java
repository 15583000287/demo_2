package cn.tedu.demo_1.entity;

public class Order {
    private Integer id;
    private String orderNO;
    private String orderPrice;

    public Order() {
    }

    public Order(String orderNO, String orderPrice) {
        this.orderNO = orderNO;
        this.orderPrice = orderPrice;
    }

    public Order(Integer id, String orderNO, String orderPrice) {
        this.id = id;
        this.orderNO = orderNO;
        this.orderPrice = orderPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNO='" + orderNO + '\'' +
                ", orderPrice='" + orderPrice + '\'' +
                '}';
    }
}
