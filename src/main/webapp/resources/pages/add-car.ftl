<#include "template/base.ftl"/>

<#macro content>

<div class="row">
    <div class="col-md-12">
        <!-- BEGIN VALIDATION STATES-->
        <div class="portlet box green">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-gift"></i>Add car
                </div>
            </div>
            <div class="portlet-body form">
                <!-- BEGIN FORM-->
                <form action="/cars/add" id="form_sample_3" class="form-horizontal" method="post">
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
                            <label class="control-label col-md-3">Car brand <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <select class="form-control select2me" name="brand">
                                    <#if !car??>
                                        <option value="">Select brand...</option>
                                    </#if>
                                    <#list brands as brand>
                                        <option
                                            <#if car?? && car.brand.name == brand.name>
                                                    selected
                                            </#if>
                                                    value="${brand.id}">${brand.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Color <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <select class="form-control select2me" name="color">
                                    <#if !spec??>
                                        <option value="">Select color...</option>
                                    </#if>
                                    <#list colors as color>
                                        <option
                                            <#if spec?? && spec.color.name == color.name>
                                                    selected
                                            </#if>
                                                    value="${color.id}">${color.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Car technical condition <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <select class="form-control select2me" name="tc">
                                    <#if !car??>
                                        <option value="">Select condition...</option>
                                    </#if>
                                    <#list conditions as condition>
                                        <option
                                            <#if car?? && car.condition.name == condition.name>
                                                    selected
                                            </#if>
                                                    value="${condition.id}">${condition.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Graduation year <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <select class="form-control select2me" name="year">
                                    <#if !car??>
                                        <option value="">Select year...</option>
                                    </#if>
                                    <#list 1970..2016 as year>
                                        <option
                                            <#if car?? && car.graduationYear == year>
                                                    selected
                                            </#if>
                                                    value="${year}">${year}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Price <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <input name="price" type="text" class="form-control"
                                    <#if car??>
                                       value="${car.price}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Acceleration <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <input name="acc" type="text" class="form-control"
                                    <#if spec??>
                                       value="${spec.acceleration}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Engine Volume <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <input name="ev" type="text" class="form-control"
                                    <#if spec??>
                                       value="${spec.engineVolume}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Horse Powers <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <input name="hp" type="text" class="form-control"
                                    <#if spec??>
                                       value="${spec.horsePowers}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Top speed <span class="required">
										* </span>
                            </label>

                            <div class="col-md-4">
                                <input name="ts" type="text" class="form-control"
                                    <#if spec??>
                                       value="${spec.topSpeed}"
                                    </#if>
                                />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">Extras&nbsp;&nbsp;</label>

                            <div class="col-md-4">
                                <textarea name="extras" class="form-control" rows="2" placeholder="Enter car extras">
                                    <#if car??>
                                        ${car.extras}
                                    </#if>
                                </textarea>
                            </div>
                        </div>

                    </div>
                    <div class="form-actions">
                        <div class="row">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn green">Submit</button>
                                <button href="/cars/all" type="button" class="btn default">Cancel</button>
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