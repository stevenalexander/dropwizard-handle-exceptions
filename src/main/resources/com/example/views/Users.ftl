<#-- @ftlvariable name="" type="com.example.UsersView" -->
<#import "Layout.ftl" as layout>
<@layout.layout>
<h3>Users</h3>
<div>
    <ul class="list-group">
        <#list users as user>
            <li class="list-group-item">${user.username}</li>
        </#list>
    </ul>
</div>
</@layout.layout>