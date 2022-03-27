function maintain_dashboard() {
    let anchor_dashboard = document.getElementById("maintainer_dashboard");
    let anchor_dashboard_i = document.getElementById("maintainer_dashboard_i");
    let anchor_dashboard_text = document.getElementById("maintainer_dashboard_text");
    console.log("mokada meee dashboard");
    anchor_dashboard.style.backgroundColor = "white";
    anchor_dashboard_i.style.color = "black";
    anchor_dashboard_text.style.color = "black";
  }
// console.log("mokada meee dashboard1111111111111");
// $('#formPop').hide();

//
// $(document).ready(function (){
//
//     $('#formPop').load('http://localhost:8080/group39_fitbot_war_exploded/Maintainer/Maintainer_Form/maintainer_form.html #maintainer_form', function (responseTxt, statusTxt, xhr) {
//         if (statusTxt == "error")
//             alert("Error: " + xhr.status + ": " + xhr.statusText);
//
//     });
//     });


$(document).ready(function(){
    $.ajax({
        method:'POST',
        url:"maintainer",
        dataType:'json',

    }).done(function(maintainer){

        // alert(maintainer.first_name);
        $('#dashboard_maintainer_header_name').append(
        '<h1>'+'Hello '+maintainer.first_name+'!!'+'</h1>'
            );
        // alert(data);
    }).fail(function(a,b,err){
        alert("Error name print");
        console.log(a,b,err)
    });

    // $('#phy_mem_diet_plan').click(function(){

    // });

});

function loadNewMaintainers(){
    $.ajax({
        method:'POST',
        url:"maintainer",
        dataType:'json',

    }).done(function(maintainer){

        // alert(maintainer.first_name);
        $('#dashboard_maintainer_header_name').append(
            '<h1>'+'Hello '+maintainer.first_name+'!!'+'</h1>'
        );
        // alert(data);
    }).fail(function(a,b,err){
        alert("Error name print");
        console.log(a,b,err)
    });
}

function getActivityChart(){
    // alert("call activite chart");
    let xValues = [0,0,0,0,0,0,0];
    let yValues = [0,0,0,0,0,0,0];
    let date = new Date();
    let currentDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
    // console.log(currentDate);
    let currentDate1 = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);

    for (let i=0;i<7;i++){
        if(date.getDate()-(i+1)<=0){
            currentDate1 =date.getFullYear()+"-"+("0" + (date.getMonth() + 1)-1).slice(-2)+"-"+("0" + (date.getDate()+30-(i+1))%30).slice(-2);
        }
        else {
            currentDate1 =date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + (date.getDate()+30-(i+1))%30).slice(-2);
        }
        xValues[i]= currentDate1

    }
    // console.log(xValues);

    $.ajax({
        method:'POST',
        url:"maintainerActivityChart",
        dataType:'json',

    }).done(function(activity){

        activity.forEach(element =>{
            let chartDate = element.Date["year"]+"-"+("0" + (element.Date["month"])).slice(-2)+"-"+("0" + element.Date["day"]).slice(-2);

            for (let j=6;j>=0;j--){
                if(chartDate == xValues[j]){
                    yValues[j]=element.Count;
                }
            }

        })
        new Chart("Activity_for_maintainers", {
            type: "bar",
            data: {
                labels: xValues,
                datasets: [{
                    label:"All Activity",
                    data: yValues,
                    // borderColor: ["red","green","blue","orange","brown"],
                    backgroundColor: ["#5a356e"],
                    fill: true
                }]
            },
            options: {
                legend: {display: false}
            }
        });

    }).fail(function(a,b,err){
        alert("Error name print");
        console.log(a,b,err)
    });


}
