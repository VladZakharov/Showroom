var TableEditable = function () {

    var handleTable = function (n) {

        function restoreRow(oTable, nRow) {
            var aData = oTable.fnGetData(nRow);
            var jqTds = $('>td', nRow);

            for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                oTable.fnUpdate(aData[i], nRow, i, false);
            }

            oTable.fnDraw();
        }

        function editRow(oTable, nRow) {
            var aData = oTable.fnGetData(nRow);
            var jqTds = $('>td', nRow);
            var i = 0;
            for (; i < n; i++) {
                jqTds[i].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[i] + '">';
            }

            //jqTds[i++].innerHTML = '<select class="form-control select2me" data-placeholder="Select...">' +
            //    '<option value="AL">Alabama</option>' +
            //    '<option value="WY">Wyoming</option>' +
            //    '</select>';

            jqTds[i++].innerHTML = '<a class="edit" href="">Save</a>';
            jqTds[i].innerHTML = '<a class="cancel" href="">Cancel</a>';
        }

        function saveRow(oTable, nRow) {
            var jqInputs = $('input', nRow);
            //var jqSelects = $('select', nRow);
            //console.log(jqSelects[0].value);
            var i = 0;
            for (; i < n; i++) {
                oTable.fnUpdate(jqInputs[i].value, nRow, i, false);
            }
            oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, i++, false);
            oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, i, false);
            oTable.fnDraw();

            if ($(nRow).attr('id') === undefined) {
                console.log('ADD');//TODO
                addRecord(nRow, oTable.fnGetData(nRow).slice(0, n), oTable);
            } else {
                console.log('UPDATE');//TODO
                updateRecord($(nRow).attr('id'), oTable.fnGetData(nRow).slice(0, n));
            }
            //console.log('id = ' + $(nRow).attr('id'));
            //console.log(oTable.fnGetData(nRow).slice(0, n));
        }

        function cancelEditRow(oTable, nRow) {
            var jqInputs = $('input', nRow);
            var i = 0;
            for (; i < n; i++) {
                oTable.fnUpdate(jqInputs[i].value, nRow, i, false);
            }
            oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, i, false);
            oTable.fnDraw();
        }

        var table = $('#sample_editable_1');

        var oTable = table.dataTable({

            // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
            // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js).
            // So when dropdowns used the scrollable div should be removed.
            //"dom": "<'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r>t<'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>",

            "lengthMenu": [
                [10, 20, 30, -1],
                [10, 20, 30, "All"] // change per page values here
            ],

            // Or you can use remote translation file
            //"language": {
            //   url: '//cdn.datatables.net/plug-ins/3cfcc339e89/i18n/Portuguese.json'
            //},

            // set the initial value
            "pageLength": 10,

            "language": {
                "lengthMenu": " _MENU_ records"
            },
            "columnDefs": [{ // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
            "order": [
                [0, "asc"]
            ] // set first column as a default sort by asc
        });

        var tableWrapper = $("#sample_editable_1_wrapper");

        tableWrapper.find(".dataTables_length select").select2({
            showSearchInput: true //hide search box with special css class
        }); // initialize select2 dropdown

        var nEditing = null;
        var nNew = false;

        $('#sample_editable_1_new').click(function (e) {
            e.preventDefault();

            if (nNew && nEditing) {
                if (confirm("Previose row not saved. Do you want to save it ?")) {
                    saveRow(oTable, nEditing); // save
                    $(nEditing).find("td:first").html("Untitled");
                    nEditing = null;
                    nNew = false;
                } else {
                    oTable.fnDeleteRow(nEditing); // cancel
                    nEditing = null;
                    nNew = false;
                    return;
                }
            }

            var data = [];
            for (var i = 0; i < n + 2; i++) data.push('');

            var aiNew = oTable.fnAddData(data);
            var nRow = oTable.fnGetNodes(aiNew[0]);
            editRow(oTable, nRow);
            nEditing = nRow;
            nNew = true;
        });

        table.on('click', '.delete', function (e) {
            e.preventDefault();

            if (confirm("Are you sure to delete this row ?") == false) {
                return;
            }

            var nRow = $(this).parents('tr')[0];

            var aData = oTable.fnGetData(nRow);

            console.log('DELETE');//TODO
            //console.log(oTable);
            //console.log(nRow);
            console.log('id = ' + $(nRow).attr('id'));
            deleteRecord($(nRow).attr('id'));

            oTable.fnDeleteRow(nRow);
            //alert("Deleted! Do not forget to do some ajax to sync with backend :)");
        });

        table.on('click', '.cancel', function (e) {
            e.preventDefault();
            if (nNew) {
                oTable.fnDeleteRow(nEditing);
                nEditing = null;
                nNew = false;
            } else {
                restoreRow(oTable, nEditing);
                nEditing = null;
            }
        });

        table.on('click', '.edit', function (e) {
            e.preventDefault();

            /* Get the row as a parent of the link that was clicked on */
            var nRow = $(this).parents('tr')[0];

            if (nEditing !== null && nEditing != nRow) {
                /* Currently editing - but not this row - restore the old before continuing to edit mode */
                restoreRow(oTable, nEditing);
                editRow(oTable, nRow);
                nEditing = nRow;
            } else if (nEditing == nRow && this.innerHTML == "Save") {
                /* Editing this row and want to save it */

                //var aData = oTable.fnGetData(nEditing);

                saveRow(oTable, nEditing);
                nEditing = null;
                //alert("Updated! Do not forget to do some ajax to sync with backend :)");
            } else {
                /* No edit in progress - let's start one */
                editRow(oTable, nRow);
                nEditing = nRow;
            }
        });
    }

    return {

        //main function to initiate the module
        init: function (n) {
            handleTable(n);
        }

    };

}();
