<#macro head title="" styles=[]>
<head>
    <meta charset="utf-8"/>
    <title>${title}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="/resources/assets/global/fonts/OpenSans.css" rel="stylesheet"
          type="text/css"/>
    <link href="/resources/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="/resources/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="/resources/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/resources/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="/resources/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"
          type="text/css"/>
    <!-- END GLOBAL MANDATORY STYLES -->

    <#list styles as style>
        <link rel="stylesheet" type="text/css" href="${style}"/>
    </#list>

    <!-- BEGIN THEME STYLES -->
    <link href="/resources/assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="/resources/assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="/resources/assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
    <link id="style_color" href="/resources/assets/admin/layout/css/themes/darkblue.css" rel="stylesheet"
          type="text/css"/>
    <link href="/resources/assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME STYLES -->
    <link rel="shortcut icon" href="favicon.ico"/>

</head>
</#macro>