<#macro sidebar>

<div class="page-sidebar-wrapper">
    <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
    <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
    <div class="page-sidebar navbar-collapse collapse">
        <!-- BEGIN SIDEBAR MENU -->
        <!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
        <!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
        <!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
        <!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
        <!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
        <ul class="page-sidebar-menu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
            <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
            <li class="sidebar-toggler-wrapper">
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                <div class="sidebar-toggler">
                </div>
                <!-- END SIDEBAR TOGGLER BUTTON -->
            </li>
            <li class="start ">
                <a href="/">
                    <i class="icon-home"></i>
                    <span class="title">Home</span>
                </a>
            </li>
            <li>
                <a href="/customers/all">
                    <i class="icon-bar-chart"></i>
                    <span class="title">Customers</span>
                </a>
            </li>
            <li>
                <a href="/cars/all">
                    <i class="icon-bar-chart"></i>
                    <span class="title">Cars</span>
                </a>
            </li>
            <li>
                <a href="/finder">
                    <i class="icon-bar-chart"></i>
                    <span class="title">Find car</span>
                </a>
            </li>
            <li>
                <a href="/templates">
                    <i class="icon-docs"></i>
                    <span class="title">My templates</span>
                </a>
            </li>
            <li class="last ">
                <a href="javascript:;">
                    <i class="icon-settings"></i>
                    <span class="title">Admin tools</span>
                    <span class="arrow "></span>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a href="javascript:;">
                            <i class="icon-settings"></i> Manage tables <span class="arrow"></span>
                        </a>
                        <ul id="manage-tables" class="sub-menu">
                        <#--<li>-->
                                <#--<a href="/table/cars"><i class="icon-link"></i> Cars</a>-->
                            <#--</li>-->
                            <#--<li>-->
                                <#--<a href="/table/customers"><i class="icon-link"></i> Customers</a>-->
                            <#--</li>-->
                            <#--<li>-->
                                <#--<a href="/table/color"><i class="icon-link"></i> Colors</a>-->
                            <#--</li>-->
                            <#--<li>-->
                                <#--<a href="/table/carbrand"><i class="icon-link"></i> Car Brands</a>-->
                            <#--</li>-->
                        </ul>
                    </li>
                    <li>
                        <a href="/custom">
                            <i class="icon-globe"></i> Write query
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- END SIDEBAR MENU -->
    </div>
</div>

</#macro>