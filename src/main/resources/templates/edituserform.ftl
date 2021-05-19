<html>
<form name="myForm" action="useredited" method="post">
    ID <input type="number" name="id" value="${user.id}" readonly /> <br/>
    First Name <input type="text" name="firstName" value="${user.firstName}" /> <br/>
    Last Name <input type="text" name="lastName" value="${user.lastName}" /> <br/>
    <input type="submit" value="edit User" />
</form>
</html>