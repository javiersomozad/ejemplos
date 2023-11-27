<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Spring Tag Samples 
</h1>
<h2>Spring tag samples</h2>
<P>Each link leads to a sample page</P>
<ul>
<li><a href="<c:url value="tagMessage" />"><strong>message</strong> tag sample</a></li>
<li><a href="<c:url value="tagUrl" />"><strong>url</strong> tag sample</a></li>
<li><a href="<c:url value="tagTheme" />"><strong>theme</strong> tag sample</a></li>
<li><a href="<c:url value="tagTransform" />"><strong>transform</strong> tag sample</a></li>
<li><a href="<c:url value="tagEval" />"><strong>eval</strong> tag sample</a></li>
<li><a href="<c:url value="tagBind" />"><strong>bind</strong> tag sample</a></li>
<li><a href="<c:url value="tagEscapeBody" />"><strong>escapeBody</strong> tag sample</a></li>
<li><a href="<c:url value="tagHasBindErrors" />"><strong>hasBindErrors</strong> tag sample</a></li>
<li><a href="<c:url value="tagHtmlEscape" />"><strong>htmlEscape</strong> tag sample</a></li>
<li><a href="<c:url value="tagNestedPath" />"><strong>nestedPath</strong> tag sample</a></li>
</ul>
</body>
</html>
