package com.demo.service;


import com.demo.domain.Order;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class OrderServiceTest  {


    @Test
    public void testPlaceOrder_withOneArgument() {
        Order or = mock(Order.class);
        OrderService orderServiceMock = mock(OrderService.class);
        orderServiceMock.placeOrder(or);
        verify(orderServiceMock).placeOrder(or);
    }

    @Test
    public void testPlaceOrder_withTwoArguments() {
        OrderService orderServiceMock = mock(OrderService.class);
        when(orderServiceMock.placeOrder(any(Order.class), anyString())).thenReturn(true);
        assertTrue(orderServiceMock.placeOrder(new Order(), "Order Placed"));
    }
}

