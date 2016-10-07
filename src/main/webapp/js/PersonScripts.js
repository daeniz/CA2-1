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

    $("#content").on("click", "#editperson", function (e) {
        e.preventDefault();
        $("#searchterm").hide();
        $("#searchterm2").hide();
        var id = $(this).data("person");

        $.get("api/person/complete/" + id, function (data) {
            var list = data == null ? [] : (data instanceof Array ? data : [data]);
            $("#content").html("<form class='form-horizontal'><div class='form-group'>" 
                    + "<label class='control-label col-sm-2' for='firstName'>First Name</label><input id='firstName' class='input'/>"
                    + "</div><div class='form-group'>"
                    + "<label class='control-label col-sm-2' for='lastName'>Last Name</label><input id='lastName' class='input'/>"
                    + "</div><div class='form-group'>"
                    + "<label class='control-label col-sm-2' for='street'>Street</label><input id='street' class='input'/>"
                    + "</div><div class='form-group'>"
                    + "<label class='control-label col-sm-2' for='city'>City</label><input id='city' class='input'/>"
                    + "</div><div class='form-group'>"
                    + "<label class='control-label col-sm-2' for='phone'>Phone</label><input id='phone' class='input'/>"
                    + "</div><div class='form-group'>"
                    + "<label class='control-label col-sm-2' for='mail'>e-mail</label><input id='mail' class='input'/>"
                    + "<button id='editButton' class='button'>Send</button></div>"
                    + "</form>");

            $.each(list, function (index, person) {

                $("#firstName").val(person.firstName);
                $("#lastName").val(person.lastName);
                $("#street").val(person.address.street);
                $("#city").val(person.address.city);
                $("#phone").val(person.phone.number);
                $("#mail").val(person.mail);
                
            });
        }, "json");


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
                        "<th>LastName</th><th>E-mail</th><th>Hobbies</th>" +
                        "<th>Street</th><th>City</th><th>Zip</th><th>Action</th></tr></thead><tbody id='mytable'>");


                result.forEach(function (person) {
                    if (person.address === undefined) {
                        person.address = "";
                    }
                    if (person.hobbies === undefined) {
                        person.hobbies = "";
                    }

                    $("#mytable").append("<tr> " +
                            "<td>" + person['id'] + "</td> " +
                            "<td>" + person['firstName'] + "</td>" +
                            "<td>" + person['lastName'] + "</td>" +
                            "<td>" + person['email'] + "</td>" +
                            "<td>" + person['hobbies']['name'] + "</td>" +
                            "<td>" + person['address']['street'] + "</td>" +
                            "<td>" + person['address']['city'] + "</td>" +
                            "<td>" + person['address']['zip'] + "</td>" +
                            "<td><a href='#' id='editperson' data-person='" + person.id + "'>edit / </a><a href='#' id='deleteperson'>delete</a></td></tr>");


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
                "<th>Street</th><th>City</th><th>Zip</th><th>Action</th></tr></thead><tbody id='mytable'>");


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
                    "<td>" + person['address']['zip'] + "</td>" +
                    "<td><a href='#' id='editperson'>edit / </a><a href='#' id='deleteperson'>delete</a></td></tr>");


        });

    }
    ;

});
