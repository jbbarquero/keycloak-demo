package com.malsolo.keycloak.demo.productapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Controller
public class ProductController {

    @GetMapping(path = "/products")
    public String getProducts(Model uiModel) {
        uiModel.addAttribute("products", Stream.of("iPad","iPhone","iPod")
                .map(s -> new Product(UUID.randomUUID().toString(), s))
                .collect(toList()));

        return "products";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "/";
    }
}
