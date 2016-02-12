<#include "template/base.ftl"/>

<#macro content>

<div class="row">
    <div class="col-md-12">
        <!-- BEGIN VALIDATION STATES-->
        <div class="portlet box green">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-gift"></i>Edit demands
                </div>
            </div>
            <div class="portlet-body form">
                <!-- BEGIN FORM-->
                <form action="/demands/add/${c_id}" id="form_sample_3" class="form-horizontal" method="post">
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
                            <label class="control-label col-md-3">Car brands <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <select class="form-control" name="brands" multiple>
                                    <#list brands as brand>
                                        <option
                                            <#if demands??>
                                                <#list demands.brands as d_brand>
                                                    <#if d_brand.name == brand.name>
                                                            selected
                                                    </#if>
                                                </#list>
                                            </#if>
                                                            value="${brand.name}">${brand.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Colors <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <select class="form-control" name="colors" multiple>
                                    <#list colors as color>
                                        <option
                                            <#if demands??>
                                                <#list demands.colors as d_color>
                                                    <#if d_color.name == color.name>
                                                            selected
                                                    </#if>
                                                </#list>
                                            </#if>
                                                            value="${color.name}">${color.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Car condition <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <select class="form-control" name="conditions" multiple>
                                    <#list conditions as cond>
                                        <option
                                            <#if demands??>
                                                <#list demands.conditions as d_cond>
                                                    <#if d_cond.name == cond.name>
                                                            selected
                                                    </#if>
                                                </#list>
                                            </#if>
                                                            value="${cond.name}">${cond.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Engine volume <span class="required">
										* </span>
                            </label>

                            <label class="control-label col-md-1">Min: </label>

                            <div class="col-md-2">
                                <input name="minEV" type="text" class="form-control"
                                    <#if demands??>
                                       value="${demands.minEngineVolume}"
                                    </#if>
                                />
                            </div>

                            <label class="control-label col-md-1">Max: </label>

                            <div class="col-md-2">
                                <input name="maxEV" type="text" class="form-control"
                                    <#if demands??>
                                       value="${demands.maxEngineVolume}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Horse powers <span class="required">
										* </span>
                            </label>

                            <label class="control-label col-md-1">Min: </label>

                            <div class="col-md-2">
                                <input name="minHP" type="text" class="form-control"
                                    <#if demands??>
                                       value="${demands.minHorsePower}"
                                    </#if>
                                />
                            </div>

                            <label class="control-label col-md-1">Max: </label>

                            <div class="col-md-2">
                                <input name="maxHP" type="text" class="form-control"
                                    <#if demands??>
                                       value="${demands.maxHorsePower}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Top speed <span class="required">
										* </span>
                            </label>

                            <label class="control-label col-md-1">Min: </label>

                            <div class="col-md-2">
                                <input name="minTS" type="text" class="form-control"
                                    <#if demands??>
                                       value="${demands.minTopSpeed}"
                                    </#if>
                                />
                            </div>

                            <label class="control-label col-md-1">Max: </label>

                            <div class="col-md-2">
                                <input name="maxTS" type="text" class="form-control"
                                    <#if demands??>
                                       value="${demands.maxTopSpeed}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Price <span class="required">
										* </span>
                            </label>

                            <label class="control-label col-md-1">Min: </label>

                            <div class="col-md-2">
                                <input name="minP" type="text" class="form-control"
                                    <#if demands??>
                                       value="${demands.minPrice}"
                                    </#if>
                                />
                            </div>

                            <label class="control-label col-md-1">Max: </label>

                            <div class="col-md-2">
                                <input name="maxP" type="text" class="form-control"
                                    <#if demands??>
                                       value="${demands.maxPrice}"
                                    </#if>
                                />
                            </div>
                        </div>

                    </div>
                    <div class="form-actions">
                        <div class="row">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn green">Submit</button>
                                <button href="/customers/${c_id}" type="button" class="btn default">Cancel</button>
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


<@base title="Demands" scripts=[
"/resources/assets/global/plugins/jquery-validation/js/jquery.validate.min.js",
"/resources/assets/global/plugins/jquery-validation/js/additional-methods.min.js",
"/resources/assets/global/scripts/metronic.js",
"/resources/assets/admin/pages/scripts/form-validation.js",
"/resources/js/runValidation.js"
]/>