<#include "header.ftl"/>
<#include "container.ftl"/>
<#include "footer.ftl"/>
<#macro body title="" small="" scripts=[]>

<body class="page-header-fixed page-quick-sidebar-over-content">

<!-- BEGIN HEADER -->
    <@header/>
<!-- END HEADER -->

<div class="clearfix">
</div>

<!-- BEGIN CONTAINER -->
    <@container title=title small=small/>
<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->
    <@footer/>
<!-- END FOOTER -->

<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="/resources/assets/global/plugins/respond.min.js"></script>
<script src="/resources/assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="/resources/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="/resources/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>

<script src="/resources/js/getTablesNames.js"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="/resources/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="/resources/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/resources/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
        type="text/javascript"></script>
<script src="/resources/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
        type="text/javascript"></script>
<script src="/resources/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="/resources/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="/resources/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="/resources/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
        type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script src="/resources/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="/resources/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="/resources/assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="/resources/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>

    <#list scripts as script>
    <script src="${script}"></script>
    </#list>

<script>
//    jQuery(document).ready(function () {
//        $('body').html($('body').html().replace(/&nbsp;/g, ''));
//        $('.form').attr('action',
//                $('.form').attr('action').replace(/\s+/g, '')
//        );
//    });
</script>

<script>
    jQuery(document).ready(function () {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        QuickSidebar.init(); // init quick sidebar
        Demo.init(); // init demo features

    });
</script>

    <#--<@script/>-->

<!-- END JAVASCRIPTS -->
</body>

</#macro>