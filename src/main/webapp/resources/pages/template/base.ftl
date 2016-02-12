<#include "head.ftl"/>
<#include "body.ftl"/>

<#macro base title="Hello!" scripts=[] styles=[]>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

    <@head title=title styles=styles/>

    <@body title="Main" small="main page small title" scripts=scripts/>

</html>
</#macro>

