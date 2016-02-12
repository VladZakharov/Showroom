<#include "template/base.ftl"/>

<#macro content>

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

<@base title="Table" scripts=[
"/resources/js/records.js",
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