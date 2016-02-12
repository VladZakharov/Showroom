$(document).ready(function () {
    getTablesNames();
});

function getTablesNames() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: '/tables',
        type: 'POST',
        success: function (data) {
            //console.log(data);
            var e = $('#manage-tables');
            for (var i = 0; i < data.length; i++) {
                e.append(
                    '<li><a href="/table/'
                    + data[i] +
                    '"><i class="icon-link"></i> '
                    + data[i] +
                    '</a></li>'
                );
            }
        }
    });
}