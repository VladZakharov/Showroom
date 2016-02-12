$('#go-button').click(function () {
    getTable($('#form_control_1').val());
});

function getTable(query) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: '/query/execute',
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify({
            query: query
        }),
        success: function (data) {
            console.log(data);
            if (data.tableName === undefined) {
                console.log(data.message)
            } else {
                //$('#sample_editable_1').dataTable().fnDestroy();
                $('#sample_editable_1').empty();
                fillTable('sample_editable_1', data);
            }
        }
    });
}