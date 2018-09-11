package fr.cloudteam.cloudcart.controller;

import static fr.cloudteam.cloudcart.rest.AddArticle.CART_URL;

import fr.cloudteam.cloudcart.bean.PanierBean;
import fr.cloudteam.cloudcart.pojo.Article;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/catalogue")
public class CatalogueController extends HttpServlet {

  private static final String CATALOGUE_VIEW = "/WEB-INF/jsp/catalogue.jsp";

  protected void doRedirect(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher rq = getServletContext().getRequestDispatcher(CATALOGUE_VIEW);
    rq.forward(request, response);
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    Article article = new Article( request.getParameter("reference"), request.getParameter("name"), request.getParameter("link"), Double.parseDouble(request.getParameter("price")));

    PanierBean panierBean = (PanierBean)request.getSession().getAttribute(CART_URL);

    if(panierBean == null) {
      panierBean = new PanierBean();
      panierBean.setCookieClient(request.getSession().getId());
      request.getSession().setAttribute(CART_URL, panierBean);
    }

    panierBean.addArticle(article);

    doRedirect(request, response);
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doRedirect(request, response);
  }
}
