<html>
<#list users>
    <ul>
        <#items as user>
            <li> (${user.getId()}) ${user.getFirstName()} ${user.getLastName()}</li>
        </#items>
    </ul>
</#list>
</html>