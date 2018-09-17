package fr.cloudteam.cloudcart.controller;

import static fr.cloudteam.cloudcart.rest.AddArticle.CART;

import fr.cloudteam.cloudcart.bean.PanierBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController extends HttpServlet {

  protected void doRedirect(HttpServletRequest request,
      HttpServletResponse response, String url) throws ServletException, IOException {
    RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
    rq.forward(request, response);
  }

  protected PanierBean getOrCreatePanierFromSession(HttpServletRequest request) {
    PanierBean panierBean = (PanierBean)request.getSession().getAttribute(CART);

    if(panierBean == null) {
      panierBean = new PanierBean();
      panierBean.setCookieClient(request.getSession().getId());
      request.getSession().setAttribute(CART, panierBean);
    }

    return panierBean;
  }
}
