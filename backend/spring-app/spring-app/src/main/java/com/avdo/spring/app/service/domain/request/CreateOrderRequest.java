package com.avdo.spring.app.service.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateOrderRequest {

    protected final Long cartId;
}
