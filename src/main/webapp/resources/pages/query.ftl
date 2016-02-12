<#include "template/base.ftl"/>

<#macro content>

<div class="portlet light bordered">

    <div class="portlet-title">
        <div class="caption font-green-haze">
            <i class="icon-settings font-green-haze"></i>
            <span class="caption-subject bold uppercase"> Custom query</span>
        </div>
        <div class="actions">
        <#--<a class="btn btn-circle btn-icon-only blue" href="javascript:;">-->
                <#--<i class="icon-cloud-upload"></i>-->
            <#--</a>-->
            <#--<a class="btn btn-circle btn-icon-only green" href="javascript:;">-->
                <#--<i class="icon-wrench"></i>-->
            <#--</a>-->
            <#--<a class="btn btn-circle btn-icon-only red" href="javascript:;">-->
                <#--<i class="icon-trash"></i>-->
            <#--</a>-->
            <#--<a class="btn btn-circle btn-icon-only btn-default fullscreen" href="javascript:;" data-original-title="" title="">-->
            <#--</a>-->
        </div>
    </div>

    <div class="portlet-body form">

        <form role="form" class="form-horizontal">

            <div class="form-body">

                <div class="form-group form-md-line-input">
                    <label class="col-md-2 control-label" for="form_control_1">Query</label>

                    <div class="col-md-10">
                        <input type="text" class="form-control" id="form_control_1" placeholder="Enter your query">

                        <div class="form-control-focus">
                        </div>
                        <span class="help-block">write query and click 'Submit' button</span>
                    </div>
                </div>

            </div>

            <div class="form-actions">
                <div class="row">
                    <div class="col-md-offset-2 col-md-10">
                        <button type="button" class="btn default">Cancel</button>
                        <button id="go-button" type="button" class="btn blue">Submit</button>
                    </div>
                </div>
            </div>

        </form>
    </div>

</div>

<div class="portlet box blue">

    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-edit"></i>Editable Table
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse">
            </a>
            <a href="#portlet-config" data-toggle="modal" class="config">
            </a>
            <a href="javascript:;" class="reload">
            </a>
            <a href="javascript:;" class="remove">
            </a>
        </div>
    </div>

    <div class="portlet-body">

        <div class="table-toolbar">
            <div class="row">
                <div class="col-md-6">
                    <div class="btn-group">
                        <button id="sample_editable_1_new" class="btn green">
                            Add New <i class="fa fa-plus"></i>
                        </button>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="btn-group pull-right">
                        <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i
                                class="fa fa-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu pull-right">
                            <li>
                                <a href="javascript:;">
                                    Print </a>
                            </li>
                            <li>
                                <a href="javascript:;">
                                    Save as PDF </a>
                            </li>
                            <li>
                                <a href="javascript:;">
                                    Export to Excel </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <table name="${table}" class="table table-striped table-hover table-bordered" id="sample_editable_1">

        </table>
    </div>
</div>

</#macro>

<@base title="Query" scripts=[
"/resources/js/records.js",
"/resources/js/customQuery.js",
"/resources/assets/global/plugins/select2/select2.min.js",
"/resources/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js",
"/resources/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js",
"/resources/assets/admin/pages/scripts/table-editable.js",
"/resources/assets/admin/pages/scripts/components-dropdowns.js"
]
styles=[
"/resources/assets/global/plugins/select2/select2.css",
"/resources/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css",
"/resources/assets/global/plugins/bootstrap-select/bootstrap-select.min.css",
"/resources/assets/global/plugins/jquery-multi-select/css/multi-select.css"
]/>