function maintain_requests() {
  let anchor_requests = document.getElementById("maintainer_requests");
  let anchor_requests_i = document.getElementById("maintainer_requests_i");
  let anchor_requests_text = document.getElementById("maintainer_requests_text");
  // console.log("mokada meee requests");
  anchor_requests.style.backgroundColor = "white";
  anchor_requests_i.style.color = "black";
  anchor_requests_text.style.color = "black";
}


// ----------------------------popup page view---------------------------


function PopupForm(popId){
  alert("call popupForm"+popId);
  $('#maintain_form_view').show();

  console.log("in pop"+popId);
  // window.location.href = 'http://localhost:8080/group39_fitbot_war_exploded/maintainerForm';

  $('#branch_name').html(' ');
  $('#equipment_type').html(' ');
  $('#maintain_description').html(' ');
  $('#maintain_request_date').html(' ');
  $('#maintain_request_time').html(' ');


  $.ajax({
    method:'POST',
    url:"maintainerWrite",
    data: {popId:popId}
  }).done(function (result){
    console.log("in popup/////////");
    console.log(result);
    console.log(result.branch);
    console.log(result.equipment_type);
    console.log(result.description);
    console.log(result.re_date);
    console.log(result.re_time);

    document.getElementById("branch_name").value = result.branch;
    // $('#branch_name').css("color","grey");

    document.getElementById("equipment_type").value = result.equipment_type;
    // $('#equipment_type').css("color","grey");

    document.getElementById("maintain_description").value = result.description;
    // $('#maintain_description').css("color","grey");

    document.getElementById("maintain_request_date").value = result.re_date;
    // $('#maintain_request_date').css("color","grey");

    document.getElementById("maintain_request_time").value = result.re_time;
    // $('#maintain_request_time').css("color","grey");

/*
    $('#branch_name').append(
        '<p>'+result.branch+'</p>'
    );
    $('#equipment_type').append(
        '<p>'+result.equipment_type+'</p>'
    );
    $('#maintain_description').append(
        '<p>'+result.description+'</p>'
    );
    $('#maintain_request_date').append(
        '<p>'+result.re_date+'</p>'
    );
    $('#maintain_request_time').append(
        '<p>'+result.re_time+'</p>'
    );
 */

    $('#btn_add_maintain').click(function(){
      // alert("in submit alert");
      submitFormMaintainer(result.form_id);

    });

    $('#btn_cancel_maintain').click(function(){
      // alert("in submit alert");
      close_form_Popup();

    });

  }).fail(function (a,b,err) {
    alert("Data loading error  Shalani");
    console.log(a,b,err);

  });

}

function PopupCompletForm(popId){
  // alert("call PopupCompletForm");
  $('#maintain_form_view').show();
  alert("in pop"+popId);
  console.log("in pop"+popId);

  console.log("in pop"+popId);
  // window.location.href = 'http://localhost:8080/group39_fitbot_war_exploded/maintainerForm';


  // $('#maintainer_form').show();
  // let form_id_m = "1";
  $('#branch_id_inForm').html(' ');
  $('#equipment_type_inForm').html(' ');
  $('#problem_dis').html(' ');
  $('#req_date').html(' ');
  $('#req_time').html(' ');
  $('#completed_form_data1').html(' ');
  $('#completed_form_data2').html(' ');
  $('#completed_form_data3').html(' ');
  $('#completed_form_data4').html(' ');

  $.ajax({
    method:'POST',
    url:"maintainerWrite",
    data: {popId:popId}
    // dataType: 'json',
    // contentType: "application/json",
  }).done(function (result){
    // alert("Done Shalani");
    let Bname;
    switch (result.branch_id) {
      case "B-0001":
        Bname = "Gampaha";
        break;
      default:
        Bname = "NULL";
        break
    }

    // console.log(result);
    // $.map(result,function(details){
//     $('#branch_id_inForm').append(
//         '<p>'+Bname+'</p>'
//     );
//     $('#equipment_type_inForm').append(
//         '<p>'+result.equipment_type+'</p>'
//     );
//     $('#problem_dis').append(
//         '<p>'+result.description+'</p>'
//     );
//     $('#req_date').append(
//         '<p>'+result.re_date+'</p>'
//     );
//     $('#req_time').append(
//         '<p>'+result.re_time+'</p>'
//     );
//
// //completed data
//
//     $('#completed_form_data1').append(
//         '<p>'+result.complet_dis+'</p>'
//     );
//     $('#completed_form_data2').append(
//         '<p>'+result.complet_img+'</p>'
//     );
//     $('#completed_form_data3').append(
//         '<p>'+result.comp_date+'</p>'
//     );
//     $('#completed_form_data4').append(
//         '<p>'+result.comp_time+'</p>'
//     );

    document.getElementById("branch_name").value = result.branch;
    // $('#branch_name').css("color","grey");

    document.getElementById("equipment_type").value = result.equipment_type;
    // $('#equipment_type').css("color","grey");

    document.getElementById("maintain_description").value = result.description;
    // $('#maintain_description').css("color","grey");

    document.getElementById("maintain_request_date").value = result.re_date;
    // $('#maintain_request_date').css("color","grey");

    document.getElementById("maintain_request_time").value = result.re_time;




    document.getElementById("completed_form_data1").value = result.complet_dis;
    // $('#branch_name').css("color","grey");

    document.getElementById("completed_form_data2").value = result.complet_img;
    // $('#equipment_type').css("color","grey");

    // document.getElementById("completed_form_data3").value = result.comp_date;
    // $('#maintain_description').css("color","grey");

    // document.getElementById("completed_form_data4").value = result.comp_time;
    // $('#maintain_request_date').css("color","grey");


    // let submitBtn = document.querySelector("#formSend_maintainer");
    // $('#formSend_maintainer').addEventListener("click", ()=>{
    //   submitFormMaintainer(popId)
    // });
    $('#submitPopFormId').click(function(){
      // alert("in submit alert");
      submitFormMaintainer(result.form_id);

      // if(operate){
      //   // do smth
      // }
    });

    // if(document.getElementById('button').clicked==true){
    //   alert("in submit");
    // }
    // alert("Data is loading now");
  }).fail(function (a,b,err) {
    alert("Data loading error  Shalani");
    console.log(a,b,err);

  });

}

function close_form_Popup(){
  $('#maintain_form_view').hide();
   $('#maintain_form input[type="text"], input[type="date"] , input[type="time"], textarea').val("");
}

function submitFormMaintainer(popId) {
    // console.log("In submitForm");
    // console.log(popId);
    // alert("uuu");

    $('#maintain_form').submit(function (e) {
      e.preventDefault();
      // let form_id_m = "1";
      let complet_dis = $('#maintain_add_note').val();
      let complet_img = $('#maintain_pic').val();
      let date = new Date();
      let currentDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
      // console.log(currentDate);

      var today = new Date();
      var currentTime = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
      // console.log(currentTime);
      //
      // console.log(popId);
      // console.log("in function");
      // console.log(complet_dis);
      // console.log(complet_img);

      $.ajax({
        method: 'POST',
        url: "maintainerForm",
        // contentType: 'application/json; charset=utf-8',
        data: {popId:popId, complet_dis: complet_dis, complet_img: complet_img,currentDate:currentDate,currentTime:currentTime},

        success: function (result) {

          // alert("done success");
          if (result.trim() == "1") {
            // alert("done successsssssssssssssss");
            reloadRequestData();
            $('#maintainer_form input[type="text"],input[type="date"]  input[type="time"], textarea').val('');
            $('#maintainer_form').hide();
            Swal.fire({
              icon: 'success',
              title: 'Successfully Submit',
              text: 'Done!',
              confirmButtonText:"Ok",
              confirmButtonColor: '#0E2C4B',
            })
            close_form_Popup();
          }
        },
        fail: function (error) {
          alert(error);
        }
      });
    });
  }


// function submitFormMaintainer(){
//   let form_id_m =1;
//   let complet_dis=$('#complet_dis').val();
//   let complet_img=$('#complet_img').val();
//   let comp_date=$('#comp_date').val();
//   let comp_time=$('#comp_time').val();
//
//   alert("call submit");
//
//   $.ajax({
//     method:'POST',
//     url:"maintainerFormSubmit",
//     // contentType: 'application/json; charset=utf-8',
//     data: {form_id_m:form_id_m, complet_dis:complet_dis, complet_img:complet_img,comp_date:comp_date,comp_time:comp_time},
//
//     success:function (result){
//
//       alert("done success");
//     },
//     fail:function (error){
//       alert(error);
//     }
//
//   });
//
// }


// function searchMaintenanceRequest(){
//   console.log("call searchMaintenanceRequest");
//   $('#maintenance_request_input_search').keyup(function(){
//     let value = $(this).val().toLowerCase();
//     $('#request_details_row').filter(function() {
//       $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
//     });
//   });
// }

function searchMaintenanceRequest(){
  $('#maintenance_request_input_search').keyup(function(){
    // alert("yohan2");
    let value = $(this).val().toLowerCase();
    $('.request_details_row').filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
}
