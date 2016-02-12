<#include "template/base.ftl"/>

<#macro content>

<div class="row">
    <div class="col-md-12">
        <!-- BEGIN VALIDATION STATES-->
        <div class="portlet box green">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-gift"></i>Add customer
                </div>
            </div>
            <div class="portlet-body form">
                <!-- BEGIN FORM-->
                <form action="/customers/add" id="form_sample_3" class="form-horizontal" method="post">
                    <div class="form-body">

                        <div class="alert alert-danger display-hide">
                            <button class="close" data-close="alert"></button>
                            You have some form errors. Please check below.
                        </div>

                        <div class="alert alert-success display-hide">
                            <button class="close" data-close="alert"></button>
                            Your form validation is successful!
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">First name <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <input name="fn" type="text" class="form-control"
                                    <#if cust??>
                                       value="${cust.firstName}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Middle name <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <input name="mn" type="text" class="form-control"
                                    <#if cust??>
                                       value="${cust.middleName}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Last name <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <input name="ln" type="text" class="form-control"
                                    <#if cust??>
                                       value="${cust.lastName}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Mobile <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <input name="mobile" type="text" class="form-control"
                                    <#if cust??>
                                       value="${cust.info.mobile}"
                                    </#if>
                                />
                            </div>
                        </div>

                    </div>
                    <div class="form-actions">
                        <div class="row">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn green">Submit</button>
                                <button href="/customers/all" type="button" class="btn default">Cancel</button>
                            </div>
                        </div>
                    </div>
                </form>
                <!-- END FORM-->
            </div>
            <!-- END VALIDATION STATES-->
        </div>
    </div>
</div>

</#macro>


<@base title="Cars" scripts=[
"/resources/assets/global/plugins/jquery-validation/js/jquery.validate.min.js",
"/resources/assets/global/plugins/jquery-validation/js/additional-methods.min.js",
"/resources/assets/global/scripts/metronic.js",
"/resources/assets/admin/pages/scripts/form-validation.js",
"/resources/js/runValidation.js"
]/>