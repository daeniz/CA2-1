/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    renderList();
    $("#citytable").hide();
    $("#listcountries").click(function () {
        event.preventDefault();
        $("#countrytable").show();
        $("#citytable").hide();
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
    //For rendering the personlist
    function renderList() {
        $.ajax({
            type: 'GET',
            url: "api/country",
            dataType: "json", // data type of response
            success: function (data) {
                var list = data == null ? [] : (data instanceof Array ? data : [data]);
                $('#countrylist').text("");
                $.each(list, function (index, country) {
                    $('#countrylist').append("<tr><td>" + country.code + "</td><td>" + country.name
                            + "</td><td> " + country.continent + "</td><td>"
                            + country.capital + "</td><td>"
                            + "<a href='#' class='cities' data-city='" + country.code + "'>List cities </a></td></tr>"
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

