package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name= "responseHeaderServlet" , urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        //[response-header]
//        response.setHeader("Content-Type", "text/plain");
//        response.setHeader("Cache-Control", "no-cache, no-store, revalidate");
//        response.setHeader("Pragma", "no-cache");

        //[Header]
//        content(response);
        redirect(response);

    }

    private void redirect(HttpServletResponse response) {
        //Status Code: 302
        //Location: /basic/hello-form.html

        response.setStatus(HttpServletResponse.SC_FOUND); //302
        response.setHeader("Location", "/basic/hello-form.html");
    }

    private void content(HttpServletResponse response) {
        Cookie cookie = new Cookie("mtCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }




}
