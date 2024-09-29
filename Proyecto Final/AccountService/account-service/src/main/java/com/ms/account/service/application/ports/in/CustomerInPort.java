package com.ms.account.service.application.ports.in;

import com.ms.account.service.domain.models.Customer;

public interface CustomerInPort {
    Customer getCustomerById(Long id,
                             String xCmClientRequestId,
                             String xCmClientUserAgent );
}
