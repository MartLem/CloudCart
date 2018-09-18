package fr.cloudteam.cloudcart.controller;

import static fr.cloudteam.cloudcart.rest.AddArticle.CART;

import fr.cloudteam.cloudcart.bean.PanierBean;
import fr.cloudteam.cloudcart.pojo.Article;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CatalogueController", value = "/catalogue")
public class CatalogueController extends AbstractController {

  public static final String CATALOGUE_VIEW = "/WEB-INF/jsp/catalogue.jsp";

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    Article article = new Article( request.getParameter("reference"), request.getParameter("name"), request.getParameter("link"), Double.parseDouble(request.getParameter("price")));

    PanierBean panierBean = getOrCreatePanierFromSession(request);
    panierBean.addArticle(article);
    request.setCharacterEncoding("UTF-8");
    doRedirect(request, response, CATALOGUE_VIEW);
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doRedirect(request, response, CATALOGUE_VIEW);

  }
}
