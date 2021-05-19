<html>
<form name="myForm" action="userdeleted" method="post">
    ID <input type="number" name="id" value="${user.id}" readonly /> <br/>
    First Name <input type="text" name="firstName" value="${user.firstName}" readonly /> <br/>
    Last Name <input type="text" name="lastName" value="${user.lastName}" readonly /> <br/>
    <input type="submit" value="delete User" />
</form>
<form action="index" method="get">
    <input type="submit" value="Cancel"/>
</form>
</html>