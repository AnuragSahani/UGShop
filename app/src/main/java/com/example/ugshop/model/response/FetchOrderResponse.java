package com.example.ugshop.model.response;

import com.example.ugshop.model.common.OrderModel;
import com.example.ugshop.network.ErrorResponse;

public class FetchOrderResponse {
    private ErrorResponse error;
    private OrderModel orderModel;
    private  boolean getModel;

    public boolean isGetModel() {
        return getModel;
    }

    public void setGetModel(boolean getModel) {
        this.getModel = getModel;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public OrderModel getOrderModel() {
        return orderModel;
    }

    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }
}
