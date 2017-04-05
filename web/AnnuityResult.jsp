<%-- 
    Document   : AnnuityResult
    Created on : Feb 14, 2017, 6:33:03 PM
    Author     : Erin K Kennon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="annuity" scope="session" class="business.Annuity" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity Results</title>
    </head>
    <body>
        <h1>Annuity Results:</h1>
        <p>
            An Annuity with deposits of
        </p>
        
        <p>
            <jsp:getProperty name="annuity" property="strBegDep" /> at the beginning of each month,
        </p>
        <p>
            <jsp:getProperty name="annuity" property="strEndDep" /> at the end of each month, and
        </p>
        <p>
            Earning <jsp:getProperty name="annuity" property="strRate" /> per year
        </p>
        
        <p>
            Will have a value of: <jsp:getProperty name="annuity" property="strFV" />
        </p>
        
        <p>
            at the end of <jsp:getProperty name="annuity" property="term" />
             months,
        </p>
        <p>
            which includes <jsp:getProperty name="annuity" property="strIntEarned"/> in interest earned.
        </p>
        <br>
        <form action="AnnuitySchedule.jsp" method="post">
            <input type="submit" value="Schedule"/>
        </form>
        <form action="NewAnnuity.jsp" method="post">
            <input type="submit" value="New Annuity"/>
        </form>
        <form action="AnnuityInput.jsp" method="post">
            <input type="submit" value="Update Annuity"/>
        </form>
    </body>
</html>
