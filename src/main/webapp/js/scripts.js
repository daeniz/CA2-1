/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $("#searchterm").hide();
    $("#searchterm2").hide();
    $("#listcompanies").click(function () {
        $("#personlist").hide();
        $("#searchterm").hide();
        $("#searchterm2").show();
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
                $('#content').html("<table id='comTable' class='table table-striped'><thead><tr><th>Name</th>" + 
                        " <th>Description</th><th>Street</th><th>CVR</th><tbody id='comtable'>");
                //Go through the list
                $.each(list, function (index, company) {
                    $('#comTable').append("<tr><td>" + company.name + "</td><td>" + company.description
                            + "</td><td> " + company.street + "</td><td>"
                            + company.cvr + "</td></tr>"
                            );
                });
                $("comTable").append("</tbody></table>");
            }
        });
    }


   

    $("#searchterm2").on('keyup', function(e) {
        
        event.preventDefault();

        var q1 = $("#searchterm2").val();
        q = q1.trim();

        $.get("api/company/search/" + q, function (data) {
            var list = data === null ? [] : (data instanceof Array ? data : [data]);
            $('#content').html("<table id='comTable' class='table'><thead><tr><th>Name</th>" + 
                        " <th>Description</th><th>Street</th><th>CVR</th><tbody id='comtable'>");
            $.each(list, function (index, company) {
                $('#comTable').append("<tr><td>" + company.name + "</td><td>" + company.description
                            + "</td><td> " + company.street + "</td><td>"
                            + company.cvr + "</td></tr>"
                            );
            });
            $("comTable").append("</tbody></table>");
        });
    });
});

