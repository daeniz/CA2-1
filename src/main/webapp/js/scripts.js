/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $("#listcompanies").click(function () {
        $("#personlist").hide();
        event.preventDefault();
       
        renderList();
    });
    
    //For rendering the Companylist
    function renderList() {
        $.ajax({
            type: 'GET',
            url: "api/company/complete",
            dataType: "json", // data type of response
            success: function (data) {
                var list = data === null ? [] : (data instanceof Array ? data : [data]);
                //Add table header
                $('#content').html("<table id='comTable' class='table'><thead><tr><th>Name</th>" + 
                        " <th>Description</th><th>Street</th><th>CVR</th>");
                //Go through the list
                $.each(list, function (index, company) {
                    $('#comTable').append("<tr><td>" + company.name + "</td><td>" + company.description
                            + "</td><td> " + company.street + "</td><td>"
                            + company.cvr + "</td></tr>"
                            );
                });
                $("comTable").append("</table>");
            }
        });
    }

   

    $("#search").keyup(function (e) {
        event.preventDefault();

        var q1 = $("#search").val();
        q = q1.trim();

        $.get("api/company/search/" + q, function (data) {
            var list = data === null ? [] : (data instanceof Array ? data : [data]);
            $('#content').html("<table id='comTable' class='table'><thead><tr><th>Name</th>" + 
                        " <th>Description</th><th>Street</th><th>CVR</th>");
            $.each(list, function (index, company) {
                $('#comTable').append("<tr><td>" + company.name + "</td><td>" + company.description
                            + "</td><td> " + company.street + "</td><td>"
                            + company.cvr + "</td></tr>"
                            );
            });
        });
    });
});

