package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.CartItemRepository;
import com.avdo.spring.app.repository.crud.CrudCartItemRepository;
import com.avdo.spring.app.repository.crud.CrudCartRepository;
import com.avdo.spring.app.repository.crud.CrudProductRepository;
import com.avdo.spring.app.repository.crud.CrudUserRepository;
import com.avdo.spring.app.repository.entity.CartEntity;
import com.avdo.spring.app.repository.entity.CartItemEntity;
import com.avdo.spring.app.repository.entity.UserEntity;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartItemJpaRepository implements CartItemRepository {

    private final CrudCartItemRepository crudCartItemRepository;
    private final CrudProductRepository crudProductRepository;
    private final CrudCartRepository crudCartRepository;
    private final CrudUserRepository crudUserRepository;

    @Autowired
    public CartItemJpaRepository(CrudCartItemRepository crudCartItemRepository,
                                 CrudProductRepository crudProductRepository,
                                 CrudCartRepository crudCartRepository,
                                 CrudUserRepository crudUserRepository) {
        this.crudCartItemRepository = crudCartItemRepository;
        this.crudProductRepository = crudProductRepository;
        this.crudCartRepository = crudCartRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public CartItem saveCartItem(CreateCartItemRequest createCartItemRequest, Cart cart, Long userId) {
        UserEntity userEntity = crudUserRepository.findById(userId).orElseThrow();

        CartItemEntity cartItemEntity = new CartItemEntity();
        CartEntity cartEntity = crudCartRepository.findByUserEntityId(userEntity.getId()).orElseThrow();
        cartItemEntity.setCartEntity(cartEntity);
        cartItemEntity.setProductEntity(crudProductRepository.findById(createCartItemRequest.getProductId()).orElseThrow());
        cartItemEntity.setQuantity(createCartItemRequest.getQuantity());
        cartItemEntity.setDateCreated(Date.valueOf(LocalDate.now()));

        return crudCartItemRepository.save(cartItemEntity).toDomainModel();
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
