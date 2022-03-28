function manager_report_page() {
    let anchor_report = document.getElementById("man_report");
    let anchor_report_i = document.getElementById("man_report_i");
    let report_text = document.getElementById("manager_report_page_text");
    console.log("mokada meee dashboard");
    anchor_report.style.backgroundColor = "white";
    anchor_report_i.style.color = "black";
    report_text.style.color = "black";
  }


function branch_revenue_report(){
    $.ajax({
        method: "POST",
        url: "managerbranchrevenue",
        dataType: "json",

        success: function (result) {
            console.log(result);
            let arrMonth= new Array();
            let arrCount = new Array();
            i =0;

            $.map(result, function (x) {
                arrMonth[i] = x['X'];
                arrCount[i] = x['Y'];
                i += 1;
            });


            new Chart("revenue_branch_report", {
                type: "line",
                data: {
                    labels: arrMonth,
                    datasets: [{
                        data: arrCount,
                        borderColor: "#00aba9",
                        fill: false
                    }]

                },
                options: {
                    plugins: {
                        legend: {
                            display: false
                        }
                    },
                    legend: {display: false},
                    title: {
                        display: false
                    }
                }
            });
        },
        error: function (error) {
            console.log(error );
        }
    });
}

function branch_member_register_report(){
    $.ajax({
        method: "POST",
        url: "managerbranchrevenue",
        dataType: "json",

        success: function (result) {
            console.log(result);
            let arrMonth= new Array();
            let arrCount = new Array();
            i =0;

            $.map(result, function (x) {
                arrMonth[i] = x['X'];
                arrCount[i] = x['Y'];
                i += 1;
            });


            new Chart("member_registration", {
                type: "line",
                data: {
                    labels: arrMonth,
                    datasets: [{
                        data: arrCount,
                        borderColor: "#00aba9",
                        fill: false
                    }]

                },
                options: {
                    plugins: {
                        legend: {
                            display: false
                        }
                    },
                    legend: {display: false},
                    title: {
                        display: false
                    }
                }
            });
        },
        error: function (error) {
            console.log(error );
        }
    });
}

function branch_member() {

    $.ajax({
        method:'POST',
        url:"managerbranchmembercount",
        dataType:'json',
        // contentType:"application/json",
    }).done(function(result){
        var xValues = ["Active Members", "Banned Members"];
        var yValues = [result[0], result[1]];
        var barColors = [
            "#00aba9",
            "#2b5797"
        ];

        new Chart("branch_member_statistics", {
            type: "pie",
            data: {
                labels: xValues,
                datasets: [{
                    backgroundColor: barColors,
                    data: yValues
                }]
            },
            options :{
                title: {
                    display: true,
                    text: "Members"
                }
            }
        });
    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });
}
