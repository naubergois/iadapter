/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2015-01-11 08:27:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import sukhwinder.chat.*;

public final class listrooms_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/header.jsp", Long.valueOf(1420955346000L));
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1420955346000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- Written by Sukhwinder Singh (ssruprai@hotmail.com -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>SS Chat - Room List</TITLE>\r\n");
      out.write("<LINK rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/chat.css\">\r\n");
      out.write("<meta name=\"Author\" content=\"Sukhwinder Singh (ssruprai@hotmail.com\">\t\r\n");
      out.write("<SCRIPT language=\"JavaScript\">\r\n");
      out.write("\t <!--\r\n");
      out.write("\t if(window.top != window.self)\r\n");
      out.write("\t {\r\n");
      out.write("\t\t window.top.location = window.location;\r\n");
      out.write("\t }\r\n");
      out.write("\t //-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("</HEAD>\r\n");
      out.write("\r\n");
      out.write("<BODY bgcolor=\"#FFFFFF\">\r\n");



String nickname = (String)session.getAttribute("nickname");
if (nickname == null || nickname == "")
{
	response.sendRedirect("login.jsp");
	//System.out.println("Redirecting");
}
else
{
	String roomname = request.getParameter("rn");	
	String descr = request.getParameter("sd");
	boolean see = false;
	if (descr != null && descr.equals("y"))
	{
		see = true;
	}

      out.write('\r');
      out.write('\n');
      out.write("<div align=\"center\">\r\n");
      out.write("<center>\r\n");
      out.write("<table width=\"100%\" border=\"0\">\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"100%\" class=\"title\">S2R Chat</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</center>\r\n");
      out.write("</div>\r\n");
      out.write("<br>");
      out.write("\r\n");
      out.write("<TABLE width=\"80%\" align=\"center\">\t\r\n");
      out.write("\t<!--<tr>\r\n");
      out.write("\t\t<td class=\"normal\">Welcome <span class=\"chattername\">");
      out.print(nickname);
      out.write("</span></td>\r\n");
      out.write("\t</tr>\t\r\n");
      out.write("\t-->\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD width=\"100%\">Select the room you want to enter or click view description to view description\r\n");
      out.write("\t\t\t about the room.\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("</TABLE>\r\n");
      out.write("<BR>\r\n");
      out.write("\t");

				
		
		try
		{
			ChatRoomList roomlist = (ChatRoomList)application.getAttribute("chatroomlist");
			ChatRoom[] chatrooms = roomlist.getRoomListArray();
			if(roomname == null)
			{
				roomname = roomlist.getRoomOfChatter(nickname).getName();
			}
			roomname = roomname.trim();

	
      out.write("\r\n");
      out.write("<DIV align=\"center\">\r\n");
      out.write("<CENTER>\r\n");
      out.write("\t<FORM name=\"chatrooms\" action=\"");
      out.print(request.getContextPath());
      out.write("/start.jsp\" method=\"post\">\r\n");
      out.write("\t<TABLE width=\"80%\" border=\"1\" cellspacing=\"1\" cellpadding=\"1\" align=\"center\">\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t<TD colspan=\"2\" class=\"pagetitle\">Room List</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t");

			for (int i = 0; i < chatrooms.length; i++)
			{
				if (chatrooms[i].getName().equalsIgnoreCase("StartUp"))
					continue;
	
      out.write("\r\n");
      out.write("\t\t<TR>\r\n");
      out.write("\t\t<TD width=\"50%\">\r\n");
      out.write("\t\t<INPUT type=radio name=\"rn\" value=\"");
      out.print(chatrooms[i].getName());
      out.write("\"\r\n");
      out.write("\t\t");
if (chatrooms[i].getName().equals(roomname))
			out.write("checked");
      out.write('>');
      out.print(chatrooms[i].getName());
      out.write("</A>\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\t");

				if (see == true && chatrooms[i].getName().equals(roomname))
				{
	
      out.write("\t\r\n");
      out.write("\t\t\t<TD width=\"50%\">");
      out.print(chatrooms[i].getDescription());
      out.write("</TD>\r\n");
      out.write("\t");

				}
				else
				{
	
      out.write("\r\n");
      out.write("\t\t\t<TD width=\"50%\"><A href=\"");
      out.print(request.getContextPath());
      out.write("/listrooms.jsp?rn=");
      out.print(chatrooms[i].getName());
      out.write("&sd=y\">View Description</A></TD>\r\n");
      out.write("\t");

				}
	
      out.write("\r\n");
      out.write("\t\t</TR>\r\n");
      out.write("\t");

			}
		}
		catch (Exception e)
		{
			System.out.println("Unable to get handle to Servlet Context: " + e.getMessage());
			e.printStackTrace();
		}

      out.write("\r\n");
      out.write("<TR>\r\n");
      out.write("\t<TD>&nbsp;<A href=\"");
      out.print(request.getContextPath());
      out.write("/addRoom.jsp\" title=\"Add new Room\">Add new Room</A></TD>\r\n");
      out.write("\t<TD><INPUT type=\"Submit\" value=\"Start\"></TD>\r\n");
      out.write("</TR>\r\n");
      out.write("</TABLE>\r\n");
      out.write("</FORM>\r\n");
      out.write("</CENTER>\r\n");
      out.write("</DIV>\r\n");

	}

      out.write('\r');
      out.write('\n');
      out.write("<DIV align=\"center\">\r\n");
      out.write("<CENTER>\r\n");
      out.write("<TABLE width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"3\" cellspacing=\"0\">\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD width=\"100%\" align=\"center\">");

		String n = (String)session.getAttribute("nickname");
		if (n != null && n.length() > 0)
		{
			out.write("<a href=\"logout.jsp\">Logout</a>");
			out.write(" <a href=\"listrooms.jsp\">List of Rooms</a>");
		}
		
      out.write(" </TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("</TABLE>\r\n");
      out.write("</CENTER>\r\n");
      out.write("</DIV>");
      out.write("\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
