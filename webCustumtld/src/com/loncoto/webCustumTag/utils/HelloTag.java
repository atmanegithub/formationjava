package com.loncoto.webCustumTag.utils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
	PageContext pc =(PageContext) getJspContext();
	 JspWriter writer=   pc.getOut();
	writer.print("<h3> bonjour ,nous sommes le " +new Date() +"</h3>");
	
	}

}
