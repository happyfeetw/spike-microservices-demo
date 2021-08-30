package com.spike.domain.customer.gateway;

import com.spike.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
