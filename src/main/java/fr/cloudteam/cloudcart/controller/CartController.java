package fr.cloudteam.cloudcart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CartController", value = "/cart")
public class CartController extends AbstractController {

  public static final String CART_VIEW = "/WEB-INF/jsp/cart.jsp";

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("isPayment", false);
    doRedirect(request, response, CART_VIEW);
  }
}
