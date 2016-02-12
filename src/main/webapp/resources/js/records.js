$(document).ready(function () {
    updateRecords();
});

var tableName;

var columnNames = [];

function fillTable(id, data) {
    var head = '<thead><tr>';
    for (var i = 0; i < data.columns.length; i++) {
        head += '<th>' + data.columns[i].viewName + '</th>';
    }
    head += '<th>Edit</th><th>Delete</th></tr></thead>';

    var body = '<tbody>';
    for (var i = 0; i < data.records.length; i++) {
        body += '<tr id="' + data.id[i] + '">';
        for (var j = 0; j < data.records[i].length; j++) {
            body += '<td>' + data.records[i][j] + '</td>';
        }
        body += '<td><a class="edit" href="javascript:;">Edit</a></td>' +
            '<td><a class="delete" href="javascript:;">Delete</a></td>';
        body += '</tr>';
    }
    body += '</tbody>';

    tableName = data.tableName;

    for (var i = 0; i < data.columns.length; i++) {
        columnNames.push(data.columns[i].systemName);
    }


    console.log('tableName = ' + tableName);

    $('#' + id).append(head);
    $('#' + id).append(body);
    TableEditable.init(data.columns.length);
}

function updateRecords() {
    tableName = $('table').attr('name');
    $.getJSON('/data/get/' + tableName, function (data) {
        fillTable('sample_editable_1', data);
    })
}

function updateRecord(id, fields) {

    var data = JSON.stringify({
        tableName: tableName,
        id: id,
        columns: columnNames,
        fields: fields
    });

    //console.log(data);

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: '/data/update',
        type: 'POST',
        dataType: 'json',
        data: data,
        success: function (data) {
            console.log(data);
        }
    });
}

function addRecord(nRow, fields, oTable) {

    var data = JSON.stringify({
        tableName: tableName,
        columns: columnNames,
        fields: fields
    });

    //console.log(data);

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: '/data/add',
        type: 'POST',
        dataType: 'json',
        data: data,
        success: function (data) {
            console.log(data);
            $(nRow).attr('id', data.id);
            oTable.fnUpdate(data.id, nRow, 0, false);
            oTable.fnDraw();
        }
    });
}

function deleteRecord(id) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: '/data/delete',
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify({
            tableName: tableName,
            id: id,
        }),
        success: function (data) {
            console.log(data);
        }
    });
}