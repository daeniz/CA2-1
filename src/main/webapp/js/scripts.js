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
                var list = data == null ? [] : (data instanceof Array ? data : [data]);
                //Add table header
                $('#content').html("<table class='table'><thead><tr><th>Name</th>" + 
                        " <th>Description</th><th>Street</th><th>CVR</th>");
                //Go through the list
                $.each(list, function (index, company) {
                    $('#content').append("<tr><td>" + company.name + "</td><td>" + company.description
                            + "</td><td> " + company.street + "</td><td>"
                            + company.cvr + "</td><td>"
                            );
                });
            }
        });
    }

   

    $("#search").keyup(function (e) {
        event.preventDefault();

        var q1 = $("#search").val();
        q = q1.trim();

        $.get("api/country/search/" + q, function (data) {
            var list = data == null ? [] : (data instanceof Array ? data : [data]);
            $('#countrylist').text("");
            $.each(list, function (index, country) {
                $('#countrylist').append("<tr><td>" + country.code + "</td><td>" + country.name
                        + "</td><td> " + country.continent + "</td><td>"
                        + country.capital + "</td><td>"
                        + "<a href='#' class='cities' data-city='" + country.code + "'>List cities </a></td></tr>"
                        );
            });
        });
    });
})

