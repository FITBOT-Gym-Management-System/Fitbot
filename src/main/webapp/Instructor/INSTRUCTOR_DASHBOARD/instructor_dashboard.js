function Instructor_dashboard() {
    let anchor_dashboard = document.getElementById("ins_dashboard");
    let anchor_dashboard_i = document.getElementById("ins_dashboard_i");
    let dashboard_text = document.getElementById("Instructor_dashboard_text");
    console.log("mokada meee dashboard");
    anchor_dashboard.style.backgroundColor = "white";
    anchor_dashboard_i.style.color = "black";
    dashboard_text.style.color = "black";
}


// $(document).ready(function(){
//     $.ajax({
//         method:'POST',
//         url:"instructors",
//         dataType:'json',
//
//     }).done(function(maintainer){
//         console.log(result);
//         // alert(maintainer.first_name);
//
//     }).fail(function(a,b,err){
//         console.log(a,b,err)
//     });
//
// });

function mystudentcount(){
    $.ajax({
        method:'POST',
        url:"instructorstudentcount",
        dataType:'json',
        // contentType:"application/json",
    }).done(function(result){
        $('#phy_number_fit').html('');
        $('#vir_number_fit').html('');
        $('#tot_number_fit').html('');

        $('#phy_number_fit').append(

            `<p>${result[0]}</p>`
        );
        $('#vir_number_fit').append(

            `<p>${result[1]}</p>`
        );

        $('#tot_number_fit').append(

            `<p>${result[0]+result[1]}</p>`
        );

    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });
}

function getInstrcutorCalender(){
    // document.addEventListener('DOMContentLoaded', function() {
    let calendarEl = document.getElementById("instructor_calendar");
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