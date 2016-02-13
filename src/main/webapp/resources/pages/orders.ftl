<#include "template/base.ftl"/>

<#macro content>

    <#list orders as order>
    <div class="portlet green box">
        <div class="portlet-title">
            <div class="caption">
                <i class="fa fa-cogs"></i>Order Information
            </div>
            <div class="actions">
                <a href="/customers/orders/${order.id}" class="btn btn-default btn-sm">
                    <i class="fa fa-cross"></i> Show </a>
            </div>
            <div class="actions">
                <a href="/customers/orders/${order.id}/close" class="btn btn-default btn-sm">
                    <i class="fa fa-cross"></i> Close </a>
            </div>
        </div>
        <div class="portlet-body">
            <div class="row static-info">
                <div class="col-md-5 name">
                    Car brand:
                </div>
                <div class="col-md-7 value">
                ${order.car.brand.name}
                </div>
            </div>
            <div class="row static-info">
                <div class="col-md-5 name">
                    Price:
                </div>
                <div class="col-md-7 value">
                ${order.car.price}
                </div>
            </div>
            <div class="row static-info">
                <div class="col-md-5 name">
                    Customer:
                </div>
                <div class="col-md-7 value">
                ${order.cust.firstName} ${order.cust.lastName}
                </div>
            </div>
        </div>
    </div>
    </#list>


</#macro>

<@base title="Orders"/>