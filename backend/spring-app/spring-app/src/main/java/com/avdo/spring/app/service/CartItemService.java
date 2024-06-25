package com.avdo.spring.app.service;

import com.avdo.spring.app.controller.dto.CreateCartItemRequest;
import com.avdo.spring.app.entity.Cart;
import com.avdo.spring.app.entity.CartItem;
import com.avdo.spring.app.entity.Product;
import com.avdo.spring.app.repository.CartItemRepository;
import com.avdo.spring.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository,
                           CartService cartService,
                           ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.cartService = cartService;
        this.productService = productService;
    }

    public List<CartItem> findAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem createCartItem(CreateCartItemRequest createCartItemRequest) {
        User user = extractUserFromToken();
        CartItem cartItem = new CartItem();
        Cart cart;
        Product product;

        cart = createOrFindCart(user);
        product = getProduct(createCartItemRequest);

        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setDateCreated(Date.valueOf(LocalDate.now()));
        return cartItemRepository.save(cartItem);
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
            e.printStackTrace();
            throw e;
        }
        return cart;
    }

    private User extractUserFromToken() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
