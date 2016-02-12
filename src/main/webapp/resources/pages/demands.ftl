<#include "template/base.ftl"/>

<#macro content>

<div class="page-bar">
    <div class="page-toolbar">
        <div class="btn-group pull-right">
            <a href="/demands/add/${cust_id}" class="btn btn-default btn-sm">
                <i class="fa fa-plus"></i> Add</a>
        </div>
    </div>
</div>

    <#list demands as demand>
    <div class="portlet blue-hoki box">
        <div class="portlet-title">
            <div class="caption">
                <i class="fa fa-cogs"></i>Customer demands
            </div>
            <div class="actions">
                <a href="/cars/find/${demand.id}" class="btn btn-default btn-sm">
                    <i class="fa fa-car"></i> Find cars </a>
                <a href="/demands/${demand.id}/edit" class="btn btn-default btn-sm">
                    <i class="fa fa-pencil"></i> Edit </a>
                <a href="/demands/${demand.id}/remove" class="btn btn-default btn-sm">
                    <i class="fa fa-trash"></i> Remove </a>
            </div>
        </div>
        <div class="portlet-body">
            <div class="row static-info">
                <div class="col-md-5 name">
                    Engine volume:
                </div>
                <div class="col-md-7 value">
                ${demand.minEngineVolume} - ${demand.maxEngineVolume}
                </div>
            </div>
            <div class="row static-info">
                <div class="col-md-5 name">
                    Horse powers:
                </div>
                <div class="col-md-7 value">
                ${demand.minHorsePower} - ${demand.maxHorsePower}
                </div>
            </div>
            <div class="row static-info">
                <div class="col-md-5 name">
                    Top speed:
                </div>
                <div class="col-md-7 value">
                ${demand.minTopSpeed} - ${demand.maxTopSpeed}
                </div>
            </div>
            <div class="row static-info">
                <div class="col-md-5 name">
                    Price:
                </div>
                <div class="col-md-7 value">
                ${demand.minPrice} - ${demand.maxPrice}
                </div>
            </div>
        </div>
    </div>
    </#list>


</#macro>

<@base title="Demands"/>