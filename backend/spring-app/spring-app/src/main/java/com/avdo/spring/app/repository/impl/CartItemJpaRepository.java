package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.entity.CartItemEntity;
import com.avdo.spring.app.entity.User;
import com.avdo.spring.app.repository.CartRepository;
import com.avdo.spring.app.repository.crud.CrudCartItemRepository;
import com.avdo.spring.app.repository.ProductRepository;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartItemJpaRepository implements CartItemRepository {

    @Autowired
    private final CrudCartItemRepository crudCartItemRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public CartItemJpaRepository(CrudCartItemRepository crudCartItemRepository,
                                 ProductRepository productRepository,
                                 CartRepository cartRepository) {
        this.crudCartItemRepository = crudCartItemRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public CartItem saveCartItem(CreateCartItemRequest createCartItemRequest) {

        User user = extractUserFromToken();
        CartItemEntity cartItemEntity = new CartItemEntity();

        cartItemEntity.setCart(cartRepository.findByUserId(user.getId()).orElseThrow());
        cartItemEntity.setProduct(productRepository.findById(createCartItemRequest.getProductId()).orElseThrow());
        cartItemEntity.setQuantity(createCartItemRequest.getQuantity());
        cartItemEntity.setDateCreated(Date.valueOf(LocalDate.now()));
        CartItemEntity savedCartItemEntity = crudCartItemRepository.save(cartItemEntity);

        return savedCartItemEntity.toDomainModel();
    }

    private User extractUserFromToken() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public List<CartItem> findAllCartItems() {
        List<CartItemEntity> cartItemEntities = crudCartItemRepository.findAll();
        List<CartItem> cartItemModels = new ArrayList<>();
        for (CartItemEntity entity : cartItemEntities) {
            cartItemModels.add(entity.toDomainModel());
        }
        return cartItemModels;
    }
}
