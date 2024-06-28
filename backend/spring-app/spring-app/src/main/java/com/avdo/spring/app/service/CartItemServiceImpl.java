package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.Cart;
import com.avdo.spring.app.entity.CartItemEntity;
import com.avdo.spring.app.entity.Product;
import com.avdo.spring.app.entity.User;
import com.avdo.spring.app.repository.impl.CartItemRepository;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository,
                               CartService cartService,
                               ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.cartService = cartService;
        this.productService = productService;
    }

    public List<CartItemEntity> findAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItemEntity createCartItem(CreateCartItemRequest createCartItemRequest) {
        User user = extractUserFromToken();
        CartItemEntity cartItemEntity = new CartItemEntity();
        Cart cart;
        Product product;

        cart = createOrFindCart(user);
        product = getProduct(createCartItemRequest);

        cartItemEntity.setCart(cart);
        cartItemEntity.setProduct(product);
        cartItemEntity.setQuantity(1);
        cartItemEntity.setDateCreated(Date.valueOf(LocalDate.now()));
        return cartItemRepository.saveCartItem(createCartItemRequest);
    }

    private Product getProduct(CreateCartItemRequest createCartItemRequest) {
        Product product;
        try {
            product = productService.findById(createCartItemRequest.getProductId());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Product not found: " + createCartItemRequest.getProductId(), e);
        }
        return product;
    }

    private Cart createOrFindCart(User user) {
        Cart cart;
        try {
            cart = cartService.findByUserId(user.getId());
            if (cart == null) {
                cart = cartService.createCart(user.getId());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cart;
    }

    private User extractUserFromToken() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
