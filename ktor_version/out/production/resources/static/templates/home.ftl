<!DOCTYPE html>
<#--ftlvariable name="data" type="com.federico.d.bernst.view.HomeFreeMarkerClass"-->
<html lang="en">
<head>
    <link rel="stylesheet" href="/static/templates/home.css">
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<ul>
    <#list data.empresas as empresa>
        <li>${empresa}</li>
    </#list>
</ul>
</body>
</html>