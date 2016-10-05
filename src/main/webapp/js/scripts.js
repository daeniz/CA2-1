/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $("#citytable").hide();
    $("#listcompanies").click(function () {
        event.preventDefault();
       
        renderList();
    });
    $("#countrylist").on("click", "a.cities", function () {
        event.preventDefault();
        $("#countrytable").hide();
        $("#citytable").show();
        var id = $(this).data("city");
        window.console.log(id);
        renderCityList(id);
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
                $('#content').html("<table class='table'><thead><tr><th>1</th>" + 
                        " <th>2</th><th>3</th><th>4</th>");
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

    //For rendering the personlist
    function renderCityList(id) {
        $.ajax({
            type: 'GET',
            url: "api/country/cities/" + id,
            dataType: "json", // data type of response
            success: function (data) {
                var list = data == null ? [] : (data instanceof Array ? data : [data]);
                $('#countrylist').text("");
                $.each(list, function (index, city) {
                    $('#citylist').append("<tr><td>" + city.name + "</td><td>" + city.population
                            + "</td>");
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

