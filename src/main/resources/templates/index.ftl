<html>
<p>${info}</p>
<table border="1" cellspacing="0" cellpadding="1">
    <tr class="tableHeader">
        <td>ID</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td></td>
        <td></td>
    </tr>
    <#foreach user in users>
        <tr class="tableBody">
            <td>${user.getId()}</td>
            <td>${user.getFirstName()}</td>
            <td>${user.getLastName()}</td>
            <td><a href="/edituserform?id=${user.getId()}">edit</a></td>
            <td><a href="/deleteuserform?id=${user.getId()}">delete</a></td>
        </tr>
    </#foreach>
</table>

<form  action="adduserform" method="get">
    <input type="submit" value="Add User"/>
</form>

</html>