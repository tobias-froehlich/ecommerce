<html>
<p>${info}</p>
<table border="1" cellspacing="0" cellpadding="1">
    <tr class="tableHeader">
        <td>ID</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>User Name</td>
        <td>Password</td>
        <td></td>
        <td></td>
    </tr>
    <#foreach user in users>
        <tr class="tableBody">
            <td>${user.getId()}</td>
            <td>${user.getFirstName()}</td>
            <td>${user.getLastName()}</td>
            <td>${user.getUsername()}</td>
            <td>${user.getPassword()}</td>
            <td>
                <form action="/edituserform" method="get">
                    <input type="hidden" name="id" value="${user.getId()}"/>
                    <input type="submit" value="Edit"/>
                </form>
            </td>
            <td>
                <form action="/deleteuserform" method="get">
                    <input type="hidden" name="id" value="${user.getId()}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </#foreach>
</table>

<form action="/adduserform" method="get">
    <input type="submit" value="Add User"/>
</form>

</html>