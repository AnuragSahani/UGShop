package com.example.ugshop.model.response;

import com.example.ugshop.model.common.OrderStatus;
import com.example.ugshop.network.ErrorResponse;

public class PlaceOrderResponse {
    private ErrorResponse error;
    private boolean ordered;
    private PlaceOrderResponse orderModel;

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public PlaceOrderResponse getOrderModel() {
        return orderModel;
    }

    public void setOrderModel(PlaceOrderResponse orderModel) {
        this.orderModel = orderModel;
    }
}
