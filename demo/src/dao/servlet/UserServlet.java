package dao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request,response);
		response.getWriter().write("test");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// TODO Auto-generated method stub
		String result="";
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(name==""||name==null||name.length()>20) {
			try {
				result="�������û��������ܳ���20���ַ���";
				request.setAttribute("message", result);
				response.sendRedirect("login.jsp");
				return;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(password==""||password==null||password.length()>20) {
			try {
				result="���������루���ܳ���20���ַ���";
				request.setAttribute("message", result);
				response.sendRedirect("login.jsp");
				return;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {  
            Class.forName("com.mysql.jdbc.Driver");  
        } catch (Exception e) {  
            System.out.print("Class Not Found Exception");  
        }  
          
        //����URL  
        String url = "jdbc:mysql://localhost:3306/suns";  
        Connection conn = null;  
        Statement stmt = null;  
        ResultSet rs = null;  
          
        try {  
            conn = (Connection) DriverManager.getConnection(url,"root","123456");  
            stmt = (Statement) conn.createStatement();  
              
            String sql = "select * from user where name='"+name+"' and password= '"+password+"'";  
            rs = stmt.executeQuery(sql);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
    HttpSession session = request.getSession();  
    session.setAttribute("name", name);  
          
    try {  
        if(rs.next()){  
            session.setAttribute("email",rs.getString("email")) ;  
            response.sendRedirect("success.jsp") ;  
            return;  
        }else{  
            session.setAttribute("message", "�û��������벻ƥ�䡣");  
				response.sendRedirect("fail.jsp") ;  
            return;  
        }  
          
    } catch (Exception e) {  
        e.printStackTrace();  
    }  
      
	}

}
