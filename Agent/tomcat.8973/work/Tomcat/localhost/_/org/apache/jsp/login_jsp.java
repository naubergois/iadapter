/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2015-01-11 07:04:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header.jsp", Long.valueOf(1420955346000L));
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

	String nickname = (String) session.getAttribute("nickname");
	if (nickname != null) {
		response.sendRedirect("listrooms.jsp");
	}

      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>S2R Chat - Login</TITLE>\r\n");
      out.write("<META http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta name=\"Author\" content=\"Sukhwinder Singh (ssruprai@hotmail.com\">\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("<!--\r\n");
      out.write("\tif (window.top != window.self) {\r\n");
      out.write("\t\twindow.top.location = window.location;\r\n");
      out.write("\t}\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("<LINK rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/chat.css\">\r\n");
      out.write("<META name=\"author\" content=\"Sukhwinder Singh (ssruprai@hotmail.com)\">\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY bgcolor=\"#FFFFFF\" onLoad=\"document.login.nickname.focus();\">\r\n");
      out.write("\t");
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
      out.write("\t<TABLE width=\"40%\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\"\r\n");
      out.write("\t\talign=\"center\">\r\n");
      out.write("\t\t");

			String d = request.getParameter("d");
			String n = request.getParameter("n");
			String ic = request.getParameter("ic");

			if (d != null && d.equals("t")) {
		
      out.write("\r\n");
      out.write("\t\t<TR>\r\n");
      out.write("\t\t\t<TD>\r\n");
      out.write("\t\t\t\t<TABLE width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\"\r\n");
      out.write("\t\t\t\t\talign=\"center\">\r\n");
      out.write("\t\t\t\t\t<TR>\r\n");
      out.write("\t\t\t\t\t\t<TD colspan=\"2\" align=\"center\"><SPAN class=\"error\">Nickname\r\n");
      out.write("\t\t\t\t\t\t\t\texists</SPAN><BR></TD>\r\n");
      out.write("\t\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t\t<TR>\r\n");
      out.write("\t\t\t\t\t\t<TD colspan=\"2\">Nickname <B>");
      out.print(n);
      out.write("</B> has already been taken\r\n");
      out.write("\t\t\t\t\t\t\tplease select some other nick.\r\n");
      out.write("\t\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t</TABLE>\r\n");
      out.write("\t\t\t</TD>\r\n");
      out.write("\t\t</TR>\r\n");
      out.write("\t\t");

			} else if (ic != null && ic.equals("t")) {
		
      out.write("\r\n");
      out.write("\t\t<TR>\r\n");
      out.write("\t\t\t<TD colspan=\"2\">\r\n");
      out.write("\t\t\t\t<TABLE width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\"\r\n");
      out.write("\t\t\t\t\talign=\"center\">\r\n");
      out.write("\t\t\t\t\t<TR>\r\n");
      out.write("\t\t\t\t\t\t<TD colspan=\"2\" align=\"center\"><SPAN class=\"error\">Incomplete\r\n");
      out.write("\t\t\t\t\t\t\t\tinformation</SPAN></TD>\r\n");
      out.write("\t\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t\t<TR>\r\n");
      out.write("\t\t\t\t\t\t<TD colspan=\"2\"><b>Sex</b> and <b>Nickname</b> must be\r\n");
      out.write("\t\t\t\t\t\t\tentered and nickname must be atleast <b>4</b> characters long and\r\n");
      out.write("\t\t\t\t\t\t\tmust not contain any <b>space</b>.</TD>\r\n");
      out.write("\t\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t</TABLE>\r\n");
      out.write("\t\t\t</TD>\r\n");
      out.write("\t\t</TR>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t\t<TR>\r\n");
      out.write("\t\t\t<TD colspan=\"2\" class=\"panel\">\r\n");
      out.write("\t\t\t\t<FORM name=\"login\" method=\"post\"\r\n");
      out.write("\t\t\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/servlet/login\">\r\n");
      out.write("\t\t\t\t\t<TABLE width=\"100%\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t\t<TR>\r\n");
      out.write("\t\t\t\t\t\t\t<TD width=\"30%\" class=\"white\">Nickname</TD>\r\n");
      out.write("\t\t\t\t\t\t\t<TD width=\"70%\"><INPUT type=\"text\" name=\"nickname\" size=\"15\">\r\n");
      out.write("\t\t\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t\t\t<TR>\r\n");
      out.write("\t\t\t\t\t\t\t<TD width=\"30%\" class=\"white\">Sex</TD>\r\n");
      out.write("\t\t\t\t\t\t\t<TD width=\"70%\"><SELECT size=\"1\" name=\"sex\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<OPTION value=\"m\">Male</OPTION>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<OPTION value=\"f\">Female</OPTION>\r\n");
      out.write("\t\t\t\t\t\t\t</SELECT></TD>\r\n");
      out.write("\t\t\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t\t\t<TR>\r\n");
      out.write("\t\t\t\t\t\t\t<TD>&nbsp;  </TD>\r\n");
      out.write("\t\t\t\t\t\t\t<TD><INPUT type=\"submit\" name=\"Submit\" value=\"Submit\">\r\n");
      out.write("\t\t\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t\t</TABLE>\r\n");
      out.write("\t\t\t\t</FORM>\r\n");
      out.write("\t\t\t</TD>\r\n");
      out.write("\t\t</TR>\r\n");
      out.write("\t</TABLE>\r\n");
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
