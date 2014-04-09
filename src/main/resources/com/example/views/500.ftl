<#-- @ftlvariable name="" type="com.example.ErrorView" -->
<#import "Layout.ftl" as layout>
<@layout.layout>
<h3>Sorry!</h3>
<h4>Something strange has happened</h4>
<p>${stackTrace}</p>
</@layout.layout>