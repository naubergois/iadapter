/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2015-01-11 05:59:07 UTC
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

public final class sendMessage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
 
	
	String nickname = (String)session.getAttribute("nickname");
	
	if (nickname != null && nickname.length() > 0)
	{
		ChatRoomList roomList = (ChatRoomList)application.getAttribute("chatroomlist");
		ChatRoom chatRoom = roomList.getRoomOfChatter(nickname);
		if ( chatRoom != null)
		{
			String msg = request.getParameter("messagebox");
			
			if ( msg != null && msg.length() > 0)
			{
				msg = msg.trim();
				chatRoom.addMessage(new Message(nickname, msg, new java.util.Date().getTime()));
			}
	

      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<LINK rel=\"stylesheet\" type=\"text/css\" href=\"chat.css\">\r\n");
      out.write("<META http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta name=\"Author\" content=\"Sukhwinder Singh (ssruprai@hotmail.com\">\t\r\n");
      out.write("\r\n");
      out.write("<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\r\n");
      out.write("function winopen(path)\r\n");
      out.write("{\r\n");
      out.write("\tchatterinfo = window.open(path,\"chatterwin\",\"scrollbars=no,resizable=yes, width=400, height=300, location=no, toolbar=no, status=no\");\r\n");
      out.write("\tchatterinfo.focus();\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY onLoad=\"document.msg.messagebox.focus();\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("<TABLE width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n");
      out.write("\t<TR> \r\n");
      out.write("\t\t<TD width=\"50%\" align=\"left\" valign=\"top\"> \r\n");
      out.write("\t\t\t<TABLE>\r\n");
      out.write("\t\t\t\t<TR> \r\n");
      out.write("\t\t\t\t\t<FORM name=\"msg\" action=\"sendMessage.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<TD width=\"100%\"> \r\n");
      out.write("\t\t\t\t\t\t\t<INPUT type=\"text\" name=\"messagebox\" maxlength=\"300\" size=\"35\">\r\n");
      out.write("\t\t\t\t\t\t\t<INPUT type=\"hidden\" name=\"nickname\" value=\"");
      out.print(session.getAttribute("nickname"));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<INPUT name=\"submit\" type=\"submit\" value=\"Send\">\r\n");
      out.write("\t\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t</FORM>\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t</TABLE>\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\t\t<TD width=\"50%\"> \r\n");
      out.write("\t\t\t<TABLE border=\"1\" cellpadding=\"3\" cellspacing=\"0\" class=\"panel\">\r\n");
      out.write("\t\t\t\t<TR align=\"left\" valign=\"top\"> \r\n");
      out.write("\t\t\t\t\t<FORM name=\"changeRoom\" method=\"post\" action=\"listrooms.jsp\">\r\n");
      out.write("\t\t\t\t\t\t<TD width=\"15%\"> \r\n");
      out.write("\t\t\t\t\t\t\t<INPUT type=\"hidden\" name=\"n\" value=\"");
      out.print(nickname);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<INPUT name=\"ChangeRoom\" type=\"submit\" id=\"ChangeRoom\" value=\"Change Room\">\r\n");
      out.write("\t\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t</FORM>\r\n");
      out.write("\t\t\t\t\t<FORM name=\"editinfo\" action=\"editinfo\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<TD width=\"20%\"> \r\n");
      out.write("\t\t\t\t\t\t\t<INPUT type=\"button\" value=\"Edit Profile\" onClick='winopen(\"editInfo.jsp\")'>\r\n");
      out.write("\t\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t</FORM>\r\n");
      out.write("\t\t\t\t\t<FORM name=\"find\">\r\n");
      out.write("\t\t\t\t\t\t<TD width=\"10%\"> \r\n");
      out.write("\t\t\t\t\t\t\t<INPUT type=\"button\" value=\"Find\" onClick='winopen(\"find.jsp\")'>\r\n");
      out.write("\t\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t</FORM>\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t<TR align=\"left\" valign=\"top\"> \r\n");
      out.write("\t\t\t\t\t<FORM name=\"refresh\">\r\n");
      out.write("\t\t\t\t\t\t<TD> \r\n");
      out.write("\t\t\t\t\t\t\t<INPUT type=\"Button\" value=\"Refresh\" onClick=\"top.frames[0].location.reload()\">\r\n");
      out.write("\t\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t</FORM>\r\n");
      out.write("\t\t\t\t\t<FORM name=\"logout\" action=\"logout.jsp\" method=\"post\" target=\"_top\">\r\n");
      out.write("\t\t\t\t\t\t<TD width=\"10%\"> \r\n");
      out.write("\t\t\t\t\t\t\t<INPUT type=\"Submit\" value=\"Logout\">\r\n");
      out.write("\t\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t</FORM>\r\n");
      out.write("\t\t\t\t\t<TD>&nbsp;</TD>\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t</TABLE>\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("</TABLE>\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>\r\n");

		}
		else
		{
			out.write("<h2 class=\"error\">Your room couldn't be found. You can't send message</h2>");
		}
	}
	else
	{
		response.sendRedirect("login.jsp");
	}

      out.write('\r');
      out.write('\n');
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