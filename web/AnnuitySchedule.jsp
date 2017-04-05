<%-- 
    Document   : AnnuitySchedule
    Created on : Feb 14, 2017, 7:01:40 PM
    Author     : Erin K Kennon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity Schedule</title>
    </head>
    <body>
        <h1>Annuity Schedule</h1>
        
        <table border="1">
            <tr>
                <th bgcolor="DBDAC1">
                    Month
                </th>
                <th bgcolor="DBDAC1">
                    Beginning Balance
                </th>
                <th bgcolor="DBDAC1">
                    Deposit at Beginning of Month
                </th>
                <th bgcolor="DBDAC1">
                    Interest Earned
                </th>
                <th bgcolor="DBDAC1">
                    Deposit at End of Month
                </th>
                <th bgcolor="DBDAC1">
                    Ending Balance
                </th>
            </tr>
            
            <c:forEach var="annmo" items="${annuity.monthData}">
                <!-- bgcolor="DAD7F3" -->
                
                   
            <tr>
                 
                <td align="right">
                    ${annmo.month}
                </td>
                <td align="right">
                    ${annmo.begBal}
                </td>
                <td align="right">
                    ${annmo.begDep}
                </td>
                <td align="right">
                    ${annmo.iearn}
                </td>
                <td align="right">
                    ${annmo.endDep}
                </td>
                <td align="right">
                    ${annmo.endBal}
                </td>
                    
            </tr>
            </c:forEach>
        </table>
        
        <p>
            <a href="AnnuityResult.jsp">Annuity Result</a>
        </p>
        <p>
            <a href="AnnuityInput.jsp">Return to Annuity Input</a>
        </p>
        <p>
            <a href="NewAnnuity.jsp">Create New Annuity</a>
        </p>

    </body>
</html>
