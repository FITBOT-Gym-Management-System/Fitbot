function Instructor_mystudents() {
    let anchor_student = document.getElementById("ins_student");
    let anchor_student_i = document.getElementById("ins_student_i");
    let student_text = document.getElementById("Instructor_mystudents_text");
    console.log("mokada meee payments");
    anchor_student.style.backgroundColor = "white";
    anchor_student_i.style.color = "black";
    student_text.style.color = "black";
  }

function close_studentview_Popup() {
    $('#student_view').hide();
}

  function loadStudent(){
      alert("load student");
      var age;
      $('#instructor_student_tab_body').html(' ');
      $.ajax({
          method:'POST',
          url:"instructorsStudent",
          dataType: 'json',
          contentType: "application/json",
      }).done(function (result){
          console.log(result);
          $.map(result,function(x){

              $('#instructor_student_tab_body').append(
                  '<tr class="details_row">'+
                  '<td>'+x.name+'</td>'+
                  '<td>'+x.dob +'</td>'+
                  '<td>'+x.gender+'</td>'+
                  '<td>'+x.workout_plan_name +'</td>'+
                  '<td>'+x.diet_plan_name +'</td>'+
                  '</tr>'

              );
          });

      }).fail(function (a,b,err) {
          alert("Data loading error in student table");
          console.log(a,b,err);

      });

  }

  // function loadStudentBoxData(){
  //   var newReq=0;
  //   var phyReq=0;
  //   var virReq=0;
  //
  //   $.ajax({
  //       method:'POST',
  //       url:"instructorsStudentBoxData",
  //       dataType: 'json',
  //   }).done(function (result){
  //       // console.log("in done")
  //       console.log(result);
  //
  //       result.forEach(element =>{
  //           if(element.status ==1){
  //               newReq++;
  //           }
  //           else if(element.status ==2){
  //               if(element.member_status == 1){
  //                   virReq++;
  //               }
  //               else if(element.member_status == 2){
  //                   phyReq++;
  //               }
  //           }
  //       })
  //       $('#new_request_number').append(
  //           '<h1>'+newReq +'</h1>'
  //       );
  //       $('#physical_request_number').append(
  //           '<h1>'+phyReq +'</h1>'
  //       );
  //       $('#virtual_request_number').append(
  //           '<h1>'+virReq +'</h1>'
  //       );
  //
  //
  //   }).fail(function (a,b,err) {
  //       alert("Data loading error in student table");
  //       console.log(a,b,err);
  //
  //   });
  // }

function printmystudents(){
    $.ajax({
        method:'POST',
        url:"instructorsStudent",
        dataType: 'json',
        contentType: "application/json",
    }).done(function(result){
        $('#mystudents_list_table_body').html('');
        console.log(result);
        $.map(result,function(x){
            $('#mystudents_list_table_body').append(
                `<tr class="employee_info"><td>${x.Name}</td><td>${x.Branch}</td><td>${x.Type}</td><td>${x.Email}</td><td>${x.Membership}</td><td><a onclick="studentsview_popup('${x.MemberId}','${x.Name}'"><i class='bx bxs-show bx-tada bx-flip-horizontal view_popup' ></i></a>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>`
            );
        });
        // searchemployee();

    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });

}

// function studentsview_popup(name){
//     alert(name);
// }

function manager_branch_revenue(){
    let chartStatus = Chart.getChart("BMI_student"); // <canvas> id
    if (chartStatus != undefined) {
        chartStatus.destroy();
    }
    let xValues = ['January','February','August','September','October','November','December'];

    new Chart("BMI_student", {
        type: "line",
        data: {
            labels: xValues,
            datasets: [{
                data: [860, 1140, 1060, 1060, 1070, 1110, 1330,],
                borderColor: "red",
                fill: false
            }]
        },
        options: {
            legend: {display: false}
        }
    });
}

function student_workout(){
    let chartStatus = Chart.getChart("Workout_student"); // <canvas> id
    if (chartStatus != undefined) {
        chartStatus.destroy();
    }
    let xValues = ['January','February','March','April','May','june','July','August','September','October','November','December'];

    new Chart("Workout_student", {
        type: "bar",
        data: {
            labels: xValues,
            datasets: [{
                data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478,7830, 2478],
                borderColor: "red",
                fill: false
            }]
        },
        options: {
            legend: {display: false}
        }
    });
}

function student_weight_vs_time(){
    let chartStatus = Chart.getChart("WeightvsTime_student"); // <canvas> id
    if (chartStatus != undefined) {
        chartStatus.destroy();
    }
    let xValues = ['January','February','March','April','May','june','July','August','September','October','November','December'];

    new Chart("Workout_student", {
        type: "line",
        data: {
            labels: xValues,
            datasets: [{
                data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478],
                borderColor: "red",
                fill: false
            }]
        },
        options: {
            legend: {display: false}
        }
    });
}

function studentsview_popup(memberID,name){

    document.getElementById('student_name_head').innerHTML= name;
    // $.ajax({
    //     method:'POST',
    //     url:"instructoreachstudent",
    //     data : {
    //         member_id:name
    //     },
    //     // contentType:"application/json",
    // }).done(function(result){
    //     $('#student_title_values').html('');
    //     $('#student_name_head').html('');
    //             $('#student_name_head').append(
    //                 `<h1>${result.Name}</h1>`
    //             );
    //             $('#student_title_values').append(
    //                 `<ul><li>${result.Branch}</li><li>${result.Membership}</li><li>${result.Dob}</li><li>${result.Height}</li><li>${result.Weight}</li></ul>`
    //             );
    //
    // }).fail(function(a,b,err){
    //     alert("Error");
    //     console.log(a,b,err);
    // });

    student_weight_vs_time();
    manager_branch_revenue()
    //BMIStudent(name);
    // student_workout();
    // student_weight_vs_time();
    $('#student_view').show();
}

function BMIStudent(name){
    $.ajax({
        method:"POST",
        url:"studentupdateweightdata",
        data: {
            memberID: name
        },
        success: function (result){
            console.log(result);
            let arrDate = new Array();
            let arrWeight = new Array();
            let todayDateNew;
            let i = 0;

            $.map(result,function(x){
                todayDateNew = x.update_date["year"]+"-"+("0"+x.update_date["month"]).slice(-2)+"-"+("0"+x.update_date["day"]).slice(-2);
                // arrDate[i] = x["update_date"];
                arrDate[i] = todayDateNew;
                arrWeight[i] = x["new_weight"];
                i += 1;
            });

            $.ajax({
                method:"POST",
                url:"instructoreachstudent",
                data: {
                    memberID: name
                },
                success: function (result){
                    console.log(result);
                    let height = parseFloat(result.Height);
                    let BMI;
                    let arrBMI = new Array();
                    arrWeight.forEach(calculateBMI);
                    function calculateBMI(value, index, array){
                        BMI = (parseFloat(value)*100*100)/(height*height)
                        arrBMI[index] = BMI.toFixed(4);
                    }

                    new Chart("BMI_student", {
                        type: "line",
                        data: {
                            labels: arrDate.reverse(),
                            datasets: [{
                                label: 'BMI ',
                                // data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478],
                                data: arrBMI.reverse(),
                                borderColor: "blue",
                                fill: false
                            }]
                        },
                        options: {
                            title: {
                                display: true,
                                text: "BMI vs Weight"
                            },
                            legend: {display: true},
                            scales: {
                                yAxes: [{
                                    scaleLabel: {
                                        display: true,
                                        labelString: 'BMI'
                                    }
                                }],
                                xAxes: [{
                                    scaleLabel: {
                                        display: true,
                                        labelString: 'Weight'
                                    }
                                }]
                            }
                        }
                    });
                },
                error: function(error){
                    console.log(error+"edit profile");
                }
            });
        },
        error: function(error){
            console.log(error+"edit profile");
        }
    });
}

function studentcount(){
    $.ajax({
        method:'POST',
        url:"instructorstudentcount",
        dataType:'json',
        // contentType:"application/json",
    }).done(function(result){
        $('#new_request_number').html('');
        $('#physical_request_number').html('');
        $('#virtual_request_number').html('');

        $('#new_request_number').append(

            `<p>${result[1]}</p>`
        );
        $('#physical_request_number').append(

            `<p>${result[0]}</p>`
        );

        $('#virtual_request_number').append(

            `<p>${result[0]+result[1]}</p>`
        );


        // alert(result);
        // alert("Data is comming babe");
    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });
}

function StudentCaloriesBurned(memberID) {
    let completed_date_arr;

    $.ajax({
        method: "POST",
        url: "instructorstudentcalories",
        data: {
            memberID: memberID
        },
        // contentType:"application/json",
        success: function (result) {
            console.log(result);

            let arrDate = new Array();
            let arrCalories = new Array();
            let i = 0;

            $.map(result, function (x) {
                completed_date_arr = x.completed_date["year"] + "-" + x.completed_date["month"] + "-" + x.completed_date["day"];
                // arrDate[i] = x["update_date"];
                arrDate[i] = completed_date_arr;
                arrCalories[i] = x["total_calories"];
                i += 1;
            });
            console.log(arrDate);
            console.log(arrCalories);

            //arrDate.sort();

            new Chart("Workout_student", {
                type: "line",
                data: {
                    labels: arrDate,
                    datasets: [{
                        label: 'BMI ',
                        // data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478],
                        data: arrCalories,
                        borderColor: "blue",
                        fill: false
                    }]
                },
                options: {
                    title: {
                        display: true,
                        text: "Calories vs Date"
                    },
                    legend: {display: true},
                    scales: {
                        yAxes: [{
                            scaleLabel: {
                                display: true,
                                labelString: 'BMI'
                            }
                        }],
                        xAxes: [{
                            scaleLabel: {
                                display: true,
                                labelString: 'Weight'
                            }
                        }]
                    }
                }
            });
        },
        error: function (error) {
            console.log(error + "edit profile");
        }
    });

}
