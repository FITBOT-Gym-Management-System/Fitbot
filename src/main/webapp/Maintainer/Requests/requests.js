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
function requestMaintainerBackgroundOn(){
  // alert("on");
  $('#background_maintainer_form').css('display','block');
  $('#background_maintainer_form1').css('display','block');
}
function requestMaintainerBackgroundOff(){
  // alert("off");
  $('#background_maintainer_form').css('display','none');
  $('#background_maintainer_form1').css('display','none');
}

function PopupForm(popId){
  // alert("call popupForm"+popId);
  $('#maintain_form_view').show();
  requestMaintainerBackgroundOn();
  // document.getElementById("maintain_form_view").classList.toggle("active");
  // console.log("in pop"+popId);
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

    console.log(result);
    let requestDate=result.re_date["year"]+"-"+("0" + (result.re_date["month"])).slice(-2)+"-"+("0" + result.re_date["day"]).slice(-2);
    console.log(requestDate);

    let requestTime=result.re_time["hour"]+":"+("0" + (result.re_time["minute"])).slice(-2)+":"+("0" + result.re_time["second"]).slice(-2);
    console.log(requestTime);

    document.getElementById("branch_name").value = result.branch;
    // $('#branch_name').css("color","grey");

    document.getElementById("equipment_type").value = result.equipment_type;
    // $('#equipment_type').css("color","grey");

    document.getElementById("maintain_description").value = result.description;
    // $('#maintain_description').css("color","grey");

    document.getElementById("maintain_request_date").value = requestDate;
    // $('#maintain_request_date').css("color","grey");

    document.getElementById("maintain_request_time").value = requestTime;
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
      requestMaintainerBackgroundOff();
    });

    $('#btn_cancel_maintain').click(function(){
      close_form_Popup();
      requestMaintainerBackgroundOff();
    });

  }).fail(function (a,b,err) {
    alert("Data loading error");
    console.log(a,b,err);

  });

}

function PopupCompletForm(popId){
  $('#maintain_form_view').show();
  requestMaintainerBackgroundOn();

  var x = document.getElementById("btn_add_maintain");
  x.disabled = true;

  $('#branch_id_inForm').html(' ');
  $('#equipment_type_inForm').html(' ');
  $('#problem_dis').html(' ');
  $('#req_date').html(' ');
  $('#req_time').html(' ');
  $('#maintain_pic').html(' ');
  $('#maintain_add_note').html(' ');


  $.ajax({
    method:'POST',
    url:"maintainerWrite",
    data: {popId:popId}
    // dataType: 'json',
    // contentType: "application/json",
  }).done(function (result){

    console.log(result);

    let requestDate=result.re_date["year"]+"-"+("0" + (result.re_date["month"])).slice(-2)+"-"+("0" + result.re_date["day"]).slice(-2);
    let requestTime=result.re_time["hour"]+":"+("0" + (result.re_time["minute"])).slice(-2)+":"+("0" + result.re_time["second"]).slice(-2);

    document.getElementById("branch_name").value = result.branch;
    // $('#branch_name').css("color","grey");

    document.getElementById("equipment_type").value = result.equipment_type;
    // $('#equipment_type').css("color","grey");

    document.getElementById("maintain_description").value = result.description;
    // $('#maintain_description').css("color","grey");

    document.getElementById("maintain_request_date").value = requestDate;
    // $('#maintain_request_date').css("color","grey");

    document.getElementById("maintain_request_time").value = requestTime;




    // document.getElementById("maintain_pic").value = result.complet_img;
    // $('#branch_name').css("color","grey");

    document.getElementById("maintain_add_note").value =result.complet_dis;
    // $('#equipment_type').css("color","grey");



    $('#btn_cancel_maintain').click(function(){
      close_form_Popup();
      requestMaintainerBackgroundOff();
    });


  }).fail(function (a,b,err) {
    alert("Data loading error");
    console.log(a,b,err);

  });

}

function close_form_Popup(){
  $('#maintain_form_view').hide();
   $('#maintain_form input[type="text"],input[type="file"], input[type="date"] , input[type="time"], textarea').val("");
}

function submitFormMaintainer(popId) {


  // Validate Username
  $('#image_file_check').hide();
  $('#note_check_maintain').hide();



    $('#maintain_form').submit(function (e) {
      e.preventDefault();

      let complet_dis = $('#maintain_add_note').val();
      let complet_img = $('#maintain_pic').val();

        let date = new Date();
        let currentDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);


        var today = new Date();
        var currentTime = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();

        $.ajax({
          method: 'POST',
          url: "maintainerForm",
          // contentType: 'application/json; charset=utf-8',
          data: {popId:popId, complet_dis: complet_dis, complet_img: complet_img,currentDate:currentDate,currentTime:currentTime},

          success: function (result) {

            if (result.trim() == "1") {

              reloadRequestData();
              $('#maintainer_form input[type="text"],input[type="file"],input[type="date"]  input[type="time"], textarea').val('');
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
