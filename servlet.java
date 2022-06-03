import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ex6_servlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con;
        Statement st;
        try (PrintWriter out = response.getWriter()) {
           String n=request.getParameter("t1");
           String q1=request.getParameter("q1");
           String q2=request.getParameter("q2");
           String q3=request.getParameter("q3");
           String q4=request.getParameter("q4");
           String q5=request.getParameter("q5");
           String q6=request.getParameter("q6");
            String q7=request.getParameter("q7");
           if(q1.equals("True"))
               mark+=1;
           if(q2.equals("True"))
               mark+=1;
           if(q3.equals("executeUpdate()"))
               mark+=1;
           if(q4.equals("Drivermanager.getconnection()"))
               mark+=1;
           if(q5.equals("True"))
               mark+=1;
           if(q6.equals("False"))
               mark+=1;
           if(q7.equals("Type1"))
               mark+=1;
           out.println("Name:"+n+" "+"Mark:"+mark);
           con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
           st=con.createStatement
           String insert="insert into details values('"+n+"',"+mark+")";//double quote for strings
           st.executeUpdate(insert);//no change in query--executeQuery //for updating already created query executeUpdate
           out.println("<br>"+" Row Inserted");
           con.close();
                         

        }
        catch(Exception e)
        {
            
        }

    }

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
