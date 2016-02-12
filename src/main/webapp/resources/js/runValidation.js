//    $('select.select2me').select2();

$('.form-horizontal').attr('action', $('.form-horizontal').attr('action').replace(/\s+/g, ''))

$('.row').each(function () {
    var elem = $(this);
    elem.html(elem.html().replace(/&nbsp;/g, ''));
});

$(document).ready(function () {
    Metronic.init();
    FormValidation.init();
});