package fr.cloudteam.cloudcart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PaymentController", value = "/payment")
public class PaymentController extends AbstractController {

  public static final String PAYMENT_VIEW = "/WEB-INF/jsp/payment.jsp";

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("isPayment", true);
    doRedirect(request, response, PAYMENT_VIEW);

  }
}
