package com.spike.domain.customer.gateway;

import com.spike.domain.customer.Customer;
import com.spike.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
