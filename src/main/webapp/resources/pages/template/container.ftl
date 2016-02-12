<#include "page-header.ftl"/>
<#include "sidebar.ftl"/>
<#macro container title="" small="">

<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <@sidebar/>
    <!-- END SIDEBAR -->
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <div class="page-content">
            <!-- BEGIN PAGE HEADER-->
        <#--<@page_header title=title small=small links=["/hello/", "/blabla/"]/>-->
            <!-- END PAGE HEADER-->

            <!-- BEGIN PAGE CONTENT-->
            <div class="row">
                <div class="col-md-12">

                    <@content/>

                </div>
            </div>
            <!-- END PAGE CONTENT-->
        </div>
    </div>
    <!-- END CONTENT -->
</div>

</#macro>