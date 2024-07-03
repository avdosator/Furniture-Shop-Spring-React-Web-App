package com.avdo.spring.app.service.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCartItemRequest {

    protected final Long productId;

    protected final int quantity;
}
