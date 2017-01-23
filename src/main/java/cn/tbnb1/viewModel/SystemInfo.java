package cn.tbnb1.viewModel;

import java.io.Serializable;

@SuppressWarnings("all")
public class SystemInfo implements Serializable {

	private  String ServerName;
	private   int ServerPort;
	private  String remoteHost;
	private  String host;
	private  String header;
	private   String propertyname;
	private  String propertyversion;
	private    String propertyarch;
	private String protocol;
	private   String ecoding;
	private String accept;
	private    String acceptLanguage;
	private String acceptEncoding;
	private    String connection;
	private   String cookie;
	private   String requestUrl;
	private  String localName;
	private   int remotePort;
	private String method;
	public String getServerName() {
		return ServerName;
	}
	public void setServerName(String serverName) {
		ServerName = serverName;
	}
	public int getServerPort() {
		return ServerPort;
	}
	public void setServerPort(int serverPort) {
		ServerPort = serverPort;
	}
	public String getRemoteHost() {
		return remoteHost;
	}
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getPropertyname() {
		return propertyname;
	}
	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}
	public String getPropertyversion() {
		return propertyversion;
	}
	public void setPropertyversion(String propertyversion) {
		this.propertyversion = propertyversion;
	}
	public String getPropertyarch() {
		return propertyarch;
	}
	public void setPropertyarch(String propertyarch) {
		this.propertyarch = propertyarch;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getEcoding() {
		return ecoding;
	}
	public void setEcoding(String ecoding) {
		this.ecoding = ecoding;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getAcceptLanguage() {
		return acceptLanguage;
	}
	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}
	public String getAcceptEncoding() {
		return acceptEncoding;
	}
	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public int getRemotePort() {
		return remotePort;
	}
	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public SystemInfo(String serverName, int serverPort, String remoteHost,
			String host, String header, String propertyname,
			String propertyversion, String propertyarch, String protocol,
			String ecoding, String accept, String acceptLanguage,
			String acceptEncoding, String connection, String cookie,
			String requestUrl, String localName, int remotePort, String method) {
		super();
		ServerName = serverName;
		ServerPort = serverPort;
		this.remoteHost = remoteHost;
		this.host = host;
		this.header = header;
		this.propertyname = propertyname;
		this.propertyversion = propertyversion;
		this.propertyarch = propertyarch;
		this.protocol = protocol;
		this.ecoding = ecoding;
		this.accept = accept;
		this.acceptLanguage = acceptLanguage;
		this.acceptEncoding = acceptEncoding;
		this.connection = connection;
		this.cookie = cookie;
		this.requestUrl = requestUrl;
		this.localName = localName;
		this.remotePort = remotePort;
		this.method = method;
	}
}
