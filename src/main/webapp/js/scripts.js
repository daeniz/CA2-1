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
                            + company.cvr + "</td><td><a href='#' id='edit" + index + "'> Edit</a></td></tr>"
                            );
                    // Function for edit
                    $("#edit" + index).click(function (event) {
                        console.log(company.name);
                        event.preventDefault();
                        $("#searchterm2").hide();

                        $("#description").val(company.description);
                        $('#content').html("<table id='comTable' class='table table-striped'><thead><tr><th>Name</th>" +
                                " <th>Description</th><th>Street</th><th>CVR</th><th>Action</th><tbody id='comtable'>" +
                                "<td><input id='name' class='input'></td>" +
                                "<td><input id='description' class='input'></td>" +
                                "<td><input id='street' class='input'></td>" +
                                "<td><input id='cvr' class='input'></td>" +
                                "<td><a href='#' id='submitEdit'>Submit</a> / <a href='#' id='delete'>Delete</a></td>");

                        $("#name").val(company.name);
                        $("#description").val(company.description);
                        $("#street").val(company.street);
                        $("#cvr").val(company.cvr);
                        $("#submitEdit").on("click", function () {
                            console.log(company.name);
                            company.name = $("#name").val();
                            company.description = $("#description").val();
                            company.street = $("#street").val();
                            company.cvr = $("#cvr").val();
                            putEdit(company);
                        });
                        $("#delete").on("click", function () {
                            console.log("Delete" + company.name);
                            del(company);
                        });
                    });


                });
                $("comTable").append("</tbody></table>");
            }
        });
    }




    $("#searchterm2").on('keyup', function (e) {

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
                            + company.cvr + "</td><td><a href='#' id='edit" + index + "'> Edit</a></td></tr>"
                            );
                    // Function for edit
                    $("#edit" + index).click(function (event) {
                        console.log(company.name);
                        event.preventDefault();
                        $("#searchterm2").hide();

                        $("#description").val(company.description);
                        $('#content').html("<form><table id='comTable' class='table table-striped'><thead><tr><th>Name</th>" +
                                " <th>Description</th><th>Street</th><th>CVR</th><th>Action</th><tbody id='comtable'>" +
                                
                                "<td><input id='name' class='input'></td>" +
                                "<td><input id='description' class='input'></td>" +
                                "<td><input id='street' class='input'></td>" +
                                "<td><input id='cvr' class='input'></td>" +
                                "<td><a href='#' id='submitEdit'>Submit</a> / <a href='#' id='delete'>Delete</a></td>");

                        $("#name").val(company.name);
                        $("#description").val(company.description);
                        $("#street").val(company.street);
                        $("#cvr").val(company.cvr);
                        $("#submitEdit").on("click", function () {
                            console.log(company.name);
                            company.name = $("#name").val();
                            company.description = $("#description").val();
                            company.street = $("#street").val();
                            company.cvr = $("#cvr").val();
                            putEdit(company);
                        });
                        $("#delete").on("click", function () {
                            console.log("Delete" + company.name);
                            del(company);
                        });
                    });
            });
            $("comTable").append("</tbody></table><form>");
        });
    });
});

function putEdit(company) {
    //var obj = {name:company.name,description:company.description,cvr:company.cvr};

    $.ajax({
        type: 'PUT',
        url: "api/company",
        dataType: "json", // data type of response
        contentType: "application/json",
        data: JSON.stringify(company),
        success: function (data) {
            console.log("PUT-Succes");
        }
    });
}
;


function del(company) {
    //var obj = {name:company.name,description:company.description,cvr:company.cvr};

    $.ajax({
        type: 'DELETE',
        url: "api/company/"+company.id,
        dataType: "json", // data type of response
        contentType: "application/json",
        success: function (data) {
            console.log("DELETE-Succes");
        }
    });
}
;

