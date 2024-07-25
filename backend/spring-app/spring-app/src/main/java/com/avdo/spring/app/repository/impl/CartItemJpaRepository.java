package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.crud.CrudCartRepository;
import com.avdo.spring.app.repository.crud.CrudProductRepository;
import com.avdo.spring.app.repository.entity.CartEntity;
import com.avdo.spring.app.repository.entity.CartItemEntity;
import com.avdo.spring.app.repository.entity.ProductEntity;
import com.avdo.spring.app.repository.entity.UserEntity;
import com.avdo.spring.app.repository.CartItemRepository;
import com.avdo.spring.app.repository.ProductRepository;
import com.avdo.spring.app.repository.crud.CrudCartItemRepository;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import com.avdo.spring.app.utils.UserUtils;
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

    @Autowired
    public CartItemJpaRepository(CrudCartItemRepository crudCartItemRepository,
                                 CrudProductRepository crudProductRepository,
                                 CrudCartRepository crudCartRepository) {
        this.crudCartItemRepository = crudCartItemRepository;
        this.crudProductRepository = crudProductRepository;
        this.crudCartRepository = crudCartRepository;
    }

    @Override
    public CartItem saveCartItem(CreateCartItemRequest createCartItemRequest, Cart cart) {
        User user = UserUtils.getCurrentUser();
        UserEntity userEntity = UserEntity.fromUser(user);

        CartItemEntity cartItemEntity = new CartItemEntity();
        CartEntity cartEntity = crudCartRepository.findByUserEntityId(userEntity.getId()).orElseThrow();
        cartItemEntity.setCartEntity(cartEntity);
        cartItemEntity.setProductEntity(crudProductRepository.findById(createCartItemRequest.getProductId()).orElseThrow());
        cartItemEntity.setQuantity(createCartItemRequest.getQuantity());
        cartItemEntity.setDateCreated(Date.valueOf(LocalDate.now()));

        CartItemEntity savedCartItem = crudCartItemRepository.save(cartItemEntity);
        List<CartItemEntity> cartItemEntities = crudCartItemRepository.findByCartEntity_Id(cartEntity.getId());
        cartEntity.setItems(cartItemEntities);

        return savedCartItem.toDomainModel();
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
