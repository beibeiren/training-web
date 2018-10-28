package com.training.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(name = "helloServlet", initParams = {
		@WebInitParam(name = "name", value = "helloServlet") }, urlPatterns = { "/HelloServlet" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI(); // 请求的全部路径，绝对路径
		System.out.println("uri:" + uri);
		String contextPath = request.getContextPath();
		System.out.println("contextPath:" + contextPath);
		String servletPath = request.getServletPath();
		System.out.println("servletPath:" + servletPath);
		String method = request.getMethod(); // 请求类别
		System.out.println("method:" + method);
		int remotePort = request.getRemotePort(); // 客户端请求端口
		System.out.println("RemotePort:" + remotePort);
		String scheme = request.getScheme(); // http
		System.out.println("scheme:" + scheme);
		String serverName = request.getServerName(); // localhost
		System.out.println("serverName:" + serverName);
		int serverPort = request.getServerPort(); // 8080
		System.out.println("serverPort:" + serverPort);
		String remoteAddr = request.getRemoteAddr(); // remote ip地址
		System.out.println("remoteAddr:" + remoteAddr);
		String url = request.getRequestURL().toString(); // http://localhost:8080/proName/servletName?params
		System.out.println("url:" + url);
		String agent = request.getHeader("User-Agent"); // 获取客户端浏览器信息
		System.out.println("agent:" + agent);
		// request.getRequestDispatcher("/dispatcherServlet"); // <url-pattern>得到请求转发对象
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-----------service--------------");
		super.service(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("-----------destory--------------");
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String name = config.getInitParameter("name");
		System.out.println("-----------init--------------");
		System.out.println(name);
		super.init();
	}

}
