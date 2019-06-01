package by.it.udalyou.server;


import by.it.udalyou.calculator.CalcException;
import by.it.udalyou.calculator.Parser;
import by.it.udalyou.calculator.Var;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebCalculator extends AbstractHandler
{
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
        throws IOException, ServletException
    {
        String expression=request.getParameter("expression");
        String result="";
        if (expression!=null)
            result=calc(expression);
        else
            expression="";
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().printf(Html.form,expression,result);
    }

    private String calc(String expression) {
        Parser parser=new Parser();
        try {
            Var result = parser.calc(expression);
            return result.toString();
        } catch (CalcException e) {
            return "ERROR:"+e.toString();
        }
    }

    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8090);
        server.setHandler(new WebCalculator());
        server.start();
        server.join();
    }
}