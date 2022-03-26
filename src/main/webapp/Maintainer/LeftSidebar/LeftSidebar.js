let sidebar = document.querySelector(".sidebar");
let closeBtn = document.querySelector("#btn");
let searchBtn = document.querySelector(".bx-search");

closeBtn.addEventListener("click", ()=>{
  sidebar.classList.toggle("open");
  menuBtnChange();//calling the function(optional)
});

searchBtn.addEventListener("click", ()=>{ // Sidebar open when you click on the search iocn
  sidebar.classList.toggle("open");
  menuBtnChange(); //calling the function(optional)
});

// following are the code to change sidebar button(optional)
function menuBtnChange() {
  if(sidebar.classList.contains("open")){
    closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");//replacing the iocns class
  }else {
    closeBtn.classList.replace("bx-menu-alt-right","bx-menu");//replacing the iocns class
  }
}


var sideBar_links_variable = "#maintainer_dashboard_implementation";

function page_select(sideBar_links_variable){
  if(sideBar_links_variable == "#maintainer_dashboard_implementation"){
    $('#maintainer_dashboard_implementation').hide();
    clear_dashboard_functions("maintainer_dashboard","maintainer_dashboard_i","maintainer_dashboard_text");
    console.log("dashboard");

    //Maintainer Requests
  }else if(sideBar_links_variable == "#maintain_requests"){
    $('#maintain_requests').hide();
    clear_dashboard_functions("maintainer_requests","maintainer_requests_i","maintainer_requests_text");
    console.log("requests");
  }
  // Maintainer Request form submit
  // else if(sideBar_links_variable == "#maintain_requests_form_popup"){
  //   $('#maintain_requests_form_popup').hide();
  //   clear_dashboard_functions("maintainer_requests","maintainer_requests_i","maintainer_requests_text");
  //   console.log("requests popup");
  // }

  //Daily tasks
  else if(sideBar_links_variable == "#maintain_daily_tasks"){
    $('#maintain_daily_tasks').hide();
    clear_dashboard_functions("maintainer_Daily_Task","maintainer_Daily_Task_i","maintainer_Daily_Task_text");
    console.log("Daily tasks");
  }

  //Equipments
  else if(sideBar_links_variable == "#maintain_equipments"){
    $('#maintain_equipments').hide();
    clear_dashboard_functions("maintainer_equipments","maintainer_equipments_i","maintainer_equipments_text");
    console.log("Equipments");
  }
}


function clear_dashboard_functions(full_background,dashboard_icon,dashboard_text) {
  // let payments_physical = document.querySelector(".payments_physical");
  let full_background_ID = document.getElementById(full_background);
  let dashboard_icon_ID = document.getElementById(dashboard_icon);
  let dashboard_text_ID = document.getElementById(dashboard_text);
  console.log("dashboard link closed");
  // payments_physical.className += "_active";
  full_background_ID.style.backgroundColor = "#0E2C4B";
  dashboard_icon_ID.style.color = "white";
  dashboard_text_ID.style.color = "white";
}

var load = [0,0,0,0,0,0,0,0,0,0,0];


//dashboard
$(document).ready(function(){
  $('#maintainer_dashboard_implementation').load('http://localhost:8080/group39_fitbot_war_exploded/Maintainer/Dashboard/dashboard.html #dashboard_maintainer', function (responseTxt, statusTxt, xhr) {

    if (statusTxt == "error") {
      alert("Error: " + xhr.status + ": " + xhr.statusText);
    }
    getTodayTasks();
    reloadRequestData();
    getActivityChart();

    // loadNewMaintainers();

    load[0] += 1;
  });
});


//dashboard
$(document).ready(function (){
  $('#maintainer_dashboard').click(function (){
    if (load[0] == 0) {
      load[0] += 1;

    } else if (sideBar_links_variable == "#maintainer_dashboard_implementation") {
      return;
    } else {
      page_select(sideBar_links_variable);
      sideBar_links_variable = "#maintainer_dashboard_implementation";
      $('#maintainer_dashboard_implementation').show();
    }
  });


  // Maintainer Requests
  $('#maintainer_requests').click(function () {
    page_select(sideBar_links_variable);
    sideBar_links_variable = "#maintain_requests";

    if (load[1] == 0) {
      $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Maintainer/Requests/requests.html #maintain_requests_view', function (responseTxt, statusTxt, xhr) {
        reloadRequestData();


        if (statusTxt == "error")
          alert("Error: " + xhr.status + ": " + xhr.statusText);
      });
      load[1] += 1;
    } else {
      $('#maintain_requests').show();
    }
  });
/*
  // Maintainer Request form submit
  $('#viewBtn_popup_form').click(function () {
    page_select(sideBar_links_variable);
    sideBar_links_variable = "#maintain_requests_form_popup";

    if (load[2] == 0) {

    $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Maintainer/Maintainer_Form/maintainer_form.html #maintain_requests_view', function (responseTxt, statusTxt, xhr) {
      // reloadRequestData();
      console.log("p2");
      if (statusTxt == "error")
        alert("Error: " + xhr.status + ": " + xhr.statusText);
    });

    }
  });

  $(function () {
    $(document).on("click", '#viewBtn_popup_form', function() {
      $('#maintain_requests').hide();
      sideBar_links_variable = "#maintain_requests_form_popup";
      let vvvvvv = $('#viewBtn_popup_form').val();
      console.log("vvvvvv");
      console.log(vvvvvv);
      console.log("vvvvvv");
      if(load[2] == 0){

        $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Maintainer/Maintainer_Form/maintainer_form.html #maintain_form_view',function(responseTxt, statusTxt, xhr){
          // console.log("ammmmmmmmmaaaaaaaaa");
          if(statusTxt == "error")
            alert(`Error: ${xhr.status}: ${xhr.statusText}`);
        });
        load[2] += 1;
      }else{
        $('#maintain_requests_form_popup').show();
      }
    });
  });

*/

  // Maintainer Daily tasks
  $('#maintainer_Daily_Task').click(function () {
    page_select(sideBar_links_variable);
    sideBar_links_variable = "#maintain_daily_tasks";

    if (load[3] == 0) {
      $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Maintainer/Daily_Tasks/daily_tasks.html #daily_tasks_maintainer', function (responseTxt, statusTxt, xhr) {
        getTodayTasks();

        if (statusTxt == "error")
          alert("Error: " + xhr.status + ": " + xhr.statusText);
      });
      load[3] += 1;
    } else {
      $('#maintain_daily_tasks').show();

    }
  });


//Maintainer Equipments
  $('#maintainer_equipments').click(function () {
    page_select(sideBar_links_variable);
    sideBar_links_variable = "#maintain_equipments";


    if (load[4] == 0) {
      $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Maintainer/Equipments/equipments.html #equipment_view_maintainer', function (responseTxt, statusTxt, xhr) {
        loadBranchName();
        let Equipments_id = $('#search_equipment_by_ID').val();
        let Branch_selecter = $('#select_Filter_List').val();
        let List_order = $('#select_Filter_List_order').val();
        console.log(Equipments_id);
        console.log(Branch_selecter);
        console.log(List_order);
        reloadEquipmentsData(Equipments_id,Branch_selecter,List_order);
        if (statusTxt == "error") {
          alert("Error: " + xhr.status + ": " + xhr.statusText);
        }
      });
      load[4] += 1;
    } else {
      $('#maintain_equipments').show();
    }
  });
});


function reloadRequestData(){
  alert("call load function");
  var newCount =0;
  var progressCount =0;
  var completCount =0;

  $('#maintain_requ_tab_body').html(' ');
  $('#new_req_value').html(' ');
  $('#prog_req_value').html(' ');
  $('#compt_req_value').html(' ');

  $('#new_req_value1').html(' ');
  $('#prog_req_value2').html(' ');
  $('#compt_req_value3').html(' ');


  $.ajax({
    method:'POST',
    url:"maintainerRequest",
    dataType: 'json',
    contentType: "application/json",
  }).done(function (result){
    // console.log(result);
    result.forEach(element =>{
    //   $.map(result,function(x){
      let requestDate=element.re_date["year"]+"-"+("0" + (element.re_date["month"])).slice(-2)+"-"+("0" + element.re_date["day"]).slice(-2);
      let completeDate=element.comp_date["year"]+"-"+("0" + (element.comp_date["month"])).slice(-2)+"-"+("0" + element.comp_date["day"]).slice(-2);
      // alert("call load function" +requestDate);
      // console.log(requestDate);
      // console.log(completeDate);
      if(element.status == 1){
        newCount++;
        // onclick="PopupForm(${element.form_id})"
        $('#maintain_requ_tab_body').append(`
            <tr class="request_details_row" id="request_details_row">
            <td> ${element.branch} </td>
            <td> ${element.equipment_type} </td>
            <td> ${requestDate} </td>
            <td> <p></p> </td>
            <td> New </td>
            <td> <div class="button"> <a type="button" id="button1" onclick="ChangeStatus(${element.form_id})">Accepte</a></div></td> 
            <td> <a class="viewBtn"  id= "viewBtn_popup_form" value="(${element.form_id})" onclick="PopupForm(${element.form_id})">View more</a> </td>
            </tr>`
        );
      }
      else if (element.status == 2){
          progressCount++;
          $('#maintain_requ_tab_body').append(`
            <tr class="request_details_row" id="request_details_row">
            <td> ${element.branch} </td>
            <td> ${element.equipment_type} </td>
            <td> ${requestDate} </td>
            <td> <p></p> </td>
            <td> Progress </td>
            <td> <p></p></td> 
            <td> <a class="viewBtn"  id= "viewBtn_popup_form" value="(${element.form_id})" onclick="PopupForm(${element.form_id})">View more</a> </td>
            </tr>`
          );
        }
      else if(element.status == 3){
          completCount++;
          $('#maintain_requ_tab_body').append(`
            <tr class="request_details_row" id="request_details_row">
            <td> ${element.branch} </td>
            <td> ${element.equipment_type} </td>
            <td> ${requestDate} </td>
            <td> ${completeDate} </td>
            <td> Completed </td>
            <td> <p></p></td> 
            <td> <a class="viewBtn"  id= "viewBtn_popup_form" value="(${element.form_id})" onclick="PopupCompletForm(${element.form_id})">View more</a> </td>
            </tr>`
          );
        }
    })

    $('#new_req_value').append(
        '<h1>'+ newCount +'</h1>'
    );

    $('#prog_req_value').append(
        '<h1>'+ progressCount +'</h1>'
    );

    $('#compt_req_value').append(
        '<h1>'+ completCount +'</h1>'
    );

    $('#new_req_value1').append(
        '<h1>'+ newCount +'</h1>'
    );

    $('#prog_req_value2').append(
        '<h1>'+ progressCount +'</h1>'
    );

    $('#compt_req_value3').append(
        '<h1>'+ completCount +'</h1>'
    );



  }).fail(function (a,b,err) {
    alert("Data loading error  Shalani");
    console.log(a,b,err);
  });
}

// function PopupForm(popId){
//
// }


// let id;
function ChangeStatus(fid){
  // console.log(fid);

  $.ajax({
    method:'POST',
    url:"maintainerStatus",
    data: {fid:fid}

  }).done(function (result){
    // alert("ChangeStatus " + result);

    reloadRequestData();

  }).fail(function (a,b,err) {
    alert("Data loading error change status");
    console.log(a,b,err);

  });
}

function log_out_function_maintainer(){
  $.ajax({
    method:"POST",
    url:"logout",
    data:"",
    success: function(result){
      if(result == "1"){
        Swal.fire({
          title: 'Do you want to log out?',
          // text: "Registration is not completed,You won't be able to revert this!",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#0E2C4B',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Yes, log out!'
        }).then((result) => {
          if (result.isConfirmed) {
            window.location.href = "http://localhost:8080/group39_fitbot_war_exploded/login";
          }else if (result.isDenied){
            // Swal.fire('Changes are not saved', '', 'info')
            console.log("Log out cancel");
          }
        })

        // setTimeout(function() {
        //   Swal.fire({
        //     icon: 'success',
        //     title: 'Successfully Logout',
        //     // text: 'Password is successfully updated!',
        //     confirmButtonText:"Ok",
        //     confirmButtonColor: '#0E2C4B',
        //   })
        // }, 2000);
        // console.log("logout is correct");
        // window.location.href = "http://localhost:8080/group39_fitbot_war_exploded";
      }else {
        console.log("Something went wrong");
        setTimeout(function(){
          Swal.fire({
            icon: 'error',
            title: 'Try Again',
            text: 'Logout unsuccessfully!',
            confirmButtonText:"Ok",
            confirmButtonColor: '#932828',
          })
        }, 2000);
      }
    },
    error: function(error){
      console.log(error);
      Swal.fire({
        icon: 'error',
        title: 'Try Again',
        text: 'Logout unsuccessfully!',
        confirmButtonText:"Ok",
        confirmButtonColor: '#932828',
      })
    }
  });
}
/*
function getCalender(){
  // alert("Calender");
  // document.addEventListener('DOMContentLoaded', function() {
  let calendarEl = document.getElementById("calendar_maintainer");
  let calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: 'dayGridMonth',
    headerToolbar: { center: 'dayGridMonth,timeGridWeek' }, // buttons for switching between views

    views: {
      dayGridMonth: { // name of view
        titleFormat: { year: 'numeric', month: '2-digit', day: '2-digit' }
        // other view-specific options here
      },
      timeGridWeek: { // name of view
        titleFormat: { year: 'numeric', month: '2-digit', day: '2-digit' }
        // other view-specific options here
      }
    }
  });

  calendar.batchRendering(function() {
    calendar.changeView('dayGridMonth');
    calendar.addEvent({ title: 'new event', start: '2021-12-08' });
  });
  calendar.render();
  // });
}
*/




