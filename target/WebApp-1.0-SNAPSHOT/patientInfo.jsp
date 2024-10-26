<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Patient Data App</title>
    <link rel="stylesheet" href="patientInfo.css">
    <script>
        function copyToClipboard(text, element) {
            navigator.clipboard.writeText(text.substring(text.indexOf(":")+2)).then(function() {
                // Show copied message
                let copiedMessage = document.createElement("div");
                copiedMessage.textContent = text.substring(0,text.indexOf(":"))+" is copied to clipboard";
                copiedMessage.style.position = "fixed";
                copiedMessage.style.bottom = "20px";
                copiedMessage.style.right = "20px";
                copiedMessage.style.backgroundColor = "#0d6efd";
                copiedMessage.style.color = "white";
                copiedMessage.style.padding = "10px";
                copiedMessage.style.borderRadius = "5px";
                copiedMessage.style.zIndex = "1000";
                document.body.appendChild(copiedMessage);

                // Remove the message after 2 seconds
                setTimeout(function() {
                    document.body.removeChild(copiedMessage);
                }, 2000);
            }, function(err) {
                console.error('Async: Could not copy text: ', err);
            });
        }
    </script>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>Patient Info:</h2>
    <ul>
        <% List<String> infos = (List<String>) request.getAttribute("patientInfo");
            for (String info : infos) { %>
        <li onclick="copyToClipboard('<%=info%>', this)"><%=info%></li>
        <% } %>
    </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
