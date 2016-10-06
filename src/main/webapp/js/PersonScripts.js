/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {

    $("#searchterm").keyup(function (e) {
        e.preventDefault();
        $("#results").html("");

        var q = $("#searchterm").val();
        var request = $.ajax({
            url: "api/person/search/" + q,
            method: "GET",
            dataType: "json"
        });
        request.done(function (data) {
            renderPersonSearch(data)
        }
        );
        request.fail(function (jqXHR, textStatus) {
            alert("request failed " + textStatus);
        });

    });

    function renderPersonSearch(data) {
        var result = data;

        //$("#results").append('<table class="table table-bordered">');
        //$("#results").append('<thead> <tr> <th>#</th>   <th>First Name</th>   <th>Last Name</th>   </tr> </thead>');
        //$("#results").append('<tbody>');
        result.forEach(function (person) {

            $("#results").append("<tr> <td>" +
                    person['id'] + "</td><td> " +
                    person['firstName'] + "</td><td>" +
                    person['lastName'] + "</td><td>" +
                    person['email'] + "</td><td>" +
                    person['address']['street'] + "</td><td>" +
                    person['address']['city'] + "</td><td>" +
                    person['address']['zip'] + "</td>" +
                    "</tr>");
        });
    }
    ;

});
