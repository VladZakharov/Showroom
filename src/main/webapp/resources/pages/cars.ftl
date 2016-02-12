<#include "template/base.ftl"/>

<#macro content>

<div class="page-bar">
    <div class="page-toolbar">
        <div class="btn-group pull-right">
            <a href="/cars/add" class="btn btn-default btn-sm">
                <i class="fa fa-plus"></i> Add car</a>
        </div>
    </div>
</div>

    <#list cars as car>
    <div class="portlet blue-hoki box">
        <div class="portlet-title">
            <div class="caption">
                <i class="fa fa-cogs"></i>Car Information
            </div>
            <div class="actions">
                <a href="/cars/${car.id}/edit" class="btn btn-default btn-sm">
                    <i class="fa fa-pencil"></i> Edit </a>
                <a href="/cars/${car.id}/remove" class="btn btn-default btn-sm">
                    <i class="fa fa-cross"></i> Remove </a>
            </div>
        </div>
        <div class="portlet-body">
            <div class="row static-info">
                <div class="col-md-5 name">
                    Car brand:
                </div>
                <div class="col-md-7 value">
                ${car.brand.name}
                </div>
            </div>
            <div class="row static-info">
                <div class="col-md-5 name">
                    Graduation year:
                </div>
                <div class="col-md-7 value">
                ${car.graduationYear}
                </div>
            </div>
            <div class="row static-info">
                <div class="col-md-5 name">
                    Condition:
                </div>
                <div class="col-md-7 value">
                ${car.condition.name}
                </div>
            </div>
            <div class="row static-info">
                <div class="col-md-5 name">
                    Price:
                </div>
                <div class="col-md-7 value">
                ${car.price}
                </div>
            </div>
        </div>
    </div>
    </#list>


</#macro>

<@base title="Cars"/>