<html>
<form name="myForm" action="useredited" method="post">
    ID <input type="number" name="id" value="${user.id}" readonly /> <br/>
    First Name <input type="text" name="firstName" value="${user.firstName}" /> <br/>
    Last Name <input type="text" name="lastName" value="${user.lastName}" /> <br/>
    Username: <input type="text" name="username" value="maxmustermann" /> <br/>
    Passwort: <input type="text" name="password" value="123"/> <br/>
    <input type="submit" value="edit User" />
</form>
<form action="index" method="get">
    <input type="submit" value="Cancel"/>
</form>
</html>