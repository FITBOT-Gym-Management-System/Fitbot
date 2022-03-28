function Instructor_appoinments() {
    let anchor_appoinment = document.getElementById("ins_appoinment");
    let anchor_appoinment_i = document.getElementById("ins_appoinment_i");
    let appoinment_text = document.getElementById("Instructor_appoinments_text");
    console.log("mokada meee dashboard");
    anchor_appoinment.style.backgroundColor = "white";
    anchor_appoinment_i.style.color = "black";
    appoinment_text.style.color = "black";
  }

  function loadAppointmentPage(){

      $('#instructor_appointment_tab_body').html(' ');
      $.ajax({
          method:'POST',
          url:"instructorsAppointmentpage",
          dataType: 'json',
          contentType: "application/json",
      }).done(function (result){
          $.map(result,function(x){
              let appoin_date = x.appointment_date["year"]+"-"+("0" + x.appointment_date["month"]).slice(-2)+"-"+("0" + x.appointment_date["day"]).slice(-2);
              let appoin_time = ("0" + x.start_time["hour"]).slice(-2)+":"+("0" + x.start_time["minute"]).slice(-2)+":"+("0" + x.start_time["second"]).slice(-2);
              let finishTime = ("0" + x.finish_time["hour"]).slice(-2)+":"+("0" + x.finish_time["minute"]).slice(-2)+":"+("0" + x.finish_time["second"]).slice(-2);
              $('#instructor_appointment_tab_body').append(
                  '<tr class="member_appoinment_row">'+
                  '<td>'+x.member_id+'</td>'+
                  '<td>'+appoin_date +'</td>'+
                  '<td>'+x.equipment+'</td>'+
                  '<td>'+appoin_time+'</td>'+
                  '<td>'+finishTime +'</td>'+

                  '</tr>'

              );
          });

      }).fail(function (a,b,err) {
          console.log(a,b,err);

      });

  }
