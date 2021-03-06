package servlet;

import dao.ItemsDAO;
import entity.Cart;
import entity.Items;
import sun.plugin2.os.windows.FLASHWINFO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {

    private String action;//表示购物车的动作
    private ItemsDAO iDao = new ItemsDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (request.getParameter("action") != null) {
            this.action = request.getParameter("action");
            if (action.equals("add")) {
               if(addToCart(request, response)){
                   request.getRequestDispatcher("/success.jsp").forward(request,response);
               }else {
                   request.getRequestDispatcher("/failure.jsp").forward(request,response);
               }
            } else if (action.equals("show")) {
                request.getRequestDispatcher("/cart.jsp").forward(request,response);
            }else if(action.equals("delete")){
                if (deleteFromCart(request,response))
                {
                    request.getRequestDispatcher("/cart.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("/cart.jsp").forward(request,response);
                }
            }
        }
    }

    //从购物车中删除商品
    private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Items item = iDao.getItemById(Integer.parseInt(id));
        if (cart.removeGoodsFromCart(item)){
            return true;
        }else{
            return false;
        }
    }

    //添加商品到购物车
    private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String number = request.getParameter("num");
        Items items = iDao.getItemById(Integer.parseInt(id));
        //是否是第一次给购物车添加商品,，需要给session创建一个新的购物车对象
        if (request.getSession().getAttribute("cart")==null){
            Cart cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart.addGoodsInCart(items,Integer.parseInt(number))){
            return true;
        }else{
            return false;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
