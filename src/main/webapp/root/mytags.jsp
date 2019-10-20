<%-- <%@ taglib prefix="t" uri="/mutiLang-tags"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<% 
String path = request.getContextPath();
String basePath = "";
if (80 == request.getServerPort()) {
	basePath = request.getScheme() + "://" + request.getServerName() + path;
} else {
	basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
}
%>
<c:set var="webRoot" value="<%=basePath%>" />
<c:set var="jsRoot" value="${webRoot}/static/js" />
<c:set var="picRoot" value="${webRoot}/static/picture" />


<link rel="shortcut icon" href="${picRoot}/titlePicture/melon.jpg" />