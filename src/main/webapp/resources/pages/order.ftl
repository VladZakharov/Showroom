<#include "template/base.ftl"/>

<#macro content>

<div class="portlet yellow box">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-cogs"></i>Customer Information
        </div>
        <div class="actions">
            <a href="/customers/${customer.id}/demands" class="btn btn-default btn-sm">
                <i class="fa fa-tasks"></i> Show demands </a>
            <a href="/customers/${customer.id}/edit" class="btn btn-default btn-sm">
                <i class="fa fa-pencil"></i> Edit </a>
            <a href="/customers/${customer.id}/remove" class="btn btn-default btn-sm">
                <i class="fa fa-cross"></i> Remove </a>
        </div>
    </div>
    <div class="portlet-body">
        <div class="row static-info">
            <div class="col-md-5 name">
                Customer:
            </div>
            <div class="col-md-7 value">
            ${customer.lastName} ${customer.firstName} ${customer.middleName}
            </div>
        </div>
        <div class="row static-info">
            <div class="col-md-5 name">
                Mobile:
            </div>
            <div class="col-md-7 value">
            ${customer.info.mobile}
            </div>
        </div>
    </div>
</div>

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

</#macro>

<@base title="Orders"/>