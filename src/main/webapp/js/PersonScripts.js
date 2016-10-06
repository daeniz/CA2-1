/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $("#searchterm").hide();
    $("#searchterm2").hide();

    $("#listpeople").click(function (event) {
        event.preventDefault();
        $("#searchterm").show();

        renderPersonListAll();
    });

    $("#searchterm").on('keyup', function (e) {
        e.preventDefault();

        var q = $("#searchterm").val();
        var request = $.ajax({
            url: "api/person/search/" + q,
            method: "GET",
            dataType: "json"
        });
        request.done(function (data) {
            renderPersonSearch(data);
        }
        );
        request.fail(function (jqXHR, textStatus) {
            alert("request failed " + textStatus);
        });

    });

    $("#listzipcodes").on('click', function (e) {
        e.preventDefault();
        $.get("api/company/zip", function (data) {
            var list = data == null ? [] : (data instanceof Array ? data : [data]);
            $("#content").html("<table  class='table table-striped'>" +
                    "<thead> <tr><th>Zip Code</th><th>city</th>" +
                    "<th>actions</th></thead><tbody id='mytable'>");

            $.each(list, function (index, zip) {
                $("#mytable").append("<tr> " +
                        "<td>" + zip['zipCode'] + "</td> " +
                        "<td>" + zip['city'] + "</td><td><a href='#'>List people</a></td>"
                        );

            });

            $("#mytable").append("</tr></tbody></table>");

        }, "json");

    });

    function renderPersonListAll() {
        $.ajax({
            url: "api/person/complete/",
            method: "GET",
            dataType: "json",
            success: function (data) {
                var result = data;

                $("#content").html("<table  class='table table-striped'>" +
                        "<thead> <tr><th>id</th><th>First Name</th>" +
                        "<th>LastName</th><th>E-mail</th>" +
                        "<th>Street</th><th>City</th><th>Zip</th></tr></thead><tbody id='mytable'>");


                result.forEach(function (person) {
                    if (person.address === undefined) {
                        person.address = "";
                    }

                    $("#mytable").append("<tr> " +
                            "<td>" + person['id'] + "</td> " +
                            "<td>" + person['firstName'] + "</td>" +
                            "<td>" + person['lastName'] + "</td>" +
                            "<td>" + person['email'] + "</td>" +
                            "<td>" + person['address']['street'] + "</td>" +
                            "<td>" + person['address']['city'] + "</td>" +
                            "<td>" + person['address']['zip'] + "</td></tr>");


                });



            }

        });


    }
    ;

    function renderPersonSearch(data) {
        var result = data;


        $("#content").html("<table  class='table table-striped'>" +
                "<thead> <tr><th>id</th><th>First Name</th>" +
                "<th>LastName</th><th>E-mail</th>" +
                "<th>Street</th><th>City</th><th>Zip</th></tr></thead><tbody id='mytable'>");


        result.forEach(function (person) {
            if (person.address === undefined) {
                person.address = "";
            }

            $("#mytable").append("<tr> " +
                    "<td>" + person['id'] + "</td> " +
                    "<td>" + person['firstName'] + "</td>" +
                    "<td>" + person['lastName'] + "</td>" +
                    "<td>" + person['email'] + "</td>" +
                    "<td>" + person['address']['street'] + "</td>" +
                    "<td>" + person['address']['city'] + "</td>" +
                    "<td>" + person['address']['zip'] + "</td></tr>");


        });

    }
    ;

});
