package fr.cloudteam.cloudcart.controller;

import static fr.cloudteam.cloudcart.controller.CatalogueController.CATALOGUE_VIEW;

import fr.cloudteam.cloudcart.pojo.Article;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartController", value = "/cart")
public class CartController extends AbstractController {

  public static final String CART_VIEW = "/WEB-INF/jsp/cart.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRedirect(request, response, CART_VIEW);
    }
}
