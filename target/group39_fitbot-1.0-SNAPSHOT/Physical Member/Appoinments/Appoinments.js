function physical_member_appointments() {
    // let payments_physical = document.querySelector(".payments_physical");
    let anchor_appointments = document.getElementById("phy_mem_appointments");
    let anchor_appointments_i = document.getElementById("phy_mem_appointments_i");
    let appointments_text = document.getElementById("physical_member_appointments_text");

    anchor_appointments.style.backgroundColor = "white";
    anchor_appointments_i.style.color = "black";
    appointments_text.style.color = "black";
}


function makeAppointmentPhysical(){
    // alert("Make appointment");
    // $('#appointment_details_popup').show();
    $('#appointment_details_popup').fadeIn(500);
    editProfileBackgroundOn();
    // $(document).css("background-color","black");
    // $('.edit_profile_container_detail').fadeTo(500, 0.5);
    $('#appointment_date_error').hide();
    $('#appointment_start_time_error').hide();
    $('#appointment_finish_time_error').hide();
}
function close_appointment_Popup(){
    // $('#appointment_details_popup').hide();
    $('#appointment_details_popup').fadeOut(500);
    editProfileBackgroundOff();
    // $(".edit_profile_container_detail").fadeOut(500);
}

function appointment_save_changes(){
    $('#appointment_container_form').submit(function(e){
        e.preventDefault();

        let flagValue1 = true;
        let flagValue2 = true;
        let flagValue3 = true;
        let equipment = $('#edit_profile_container_detail_last_name').val();
        let appointmentDate = $('#edit_profile_container_detail_name').val();

        // $('#edit_profile_container_detail_name').keyup(function () {
        //     validateAppoinmentDate();
        // });

        validateAppoinmentDate();

        function validateAppoinmentDate() {

            if(appointmentDate.length == 0){
                //alert("Yohan");
                $('#appointment_date_error').show();
                flagValue1 = false;
                return;
            }else{
                $('#appointment_date_error').hide();
                flagValue1 = true;
            }
            let arr_date = appointmentDate.split('-');
            const date = new Date();
            let year_age = date.getFullYear() - arr_date[0];
            let month_age = (date.getMonth()+1) - arr_date[1];
            let date_age =  arr_date[2] - date.getDate();

            function tempory(){
                $('#appointment_date_error').show();
                $('#appointment_date_error').html("**Make appointment should before 24 hours");
                $('#appointment_date_error').css("color", "red");
                flagValue1 = false;
            }

            if (!(year_age == 0)) {
                // alert("Year"+year_age);
                tempory();
                return;
            }
            if(!(month_age == 0)){
                // alert("Month"+month_age);
                tempory();
                return;
            }
            if(!(date_age == 0 || date_age == 1)){
                // alert("Date0 "+date_age);
                tempory();
                return;
            }
            $('#appointment_date_error').hide();
            flagValue1 = true;
        }

        $('#edit_profile_container_detail_weight').keyup(function () {
            validateAppoinmentStartTime();
        });
        function validateAppoinmentStartTime(){
            let startTime = $('#edit_profile_container_detail_weight').val();
            let finishTime = $('#edit_profile_container_detail_last_height').val();

            let arr_startTime = startTime.split(':');
            if(startTime.length == 0){
                $('#appointment_start_time_error').show();
                flagValue2 = false;
                return;
            }else if(startTime > finishTime){
                $('#appointment_start_time_error').show();
                $('#appointment_start_time_error').html("**Start Time must be less than Finish Time");
                $('#appointment_start_time_error').css("color", "red");
                flagValue2 = false;
                return;
            }else if(arr_startTime[0] < 8){
                $('#appointment_start_time_error').show();
                $('#appointment_start_time_error').html("**Start Time must be greater than 8 O'Clock");
                $('#appointment_start_time_error').css("color", "red");
                flagValue2 = false;
                return;
            }else{
                $('#appointment_start_time_error').hide();
                flagValue2 = true;
            }
        }
        $('#edit_profile_container_detail_last_height').keyup(function () {
            validateAppoinmentFinishTime();
        });
        function validateAppoinmentFinishTime(){
            let finishTime = $('#edit_profile_container_detail_last_height').val();
            let arr_finishTime = finishTime.split(':');
            if(finishTime.length == 0){
                $('#appointment_finish_time_error').show();
                flagValue3 = false;
                return;
            }else if(arr_finishTime[0] > 22){
                $('#appointment_finish_time_error').show();
                $('#appointment_finish_time_error').html("**Start Time must be less than 22 O'Clock");
                $('#appointment_finish_time_error').css("color", "red");
                flagValue2 = false;
                return;
            }else {
                $('#appointment_finish_time_error').hide();
                flagValue3 = true;
            }
        }
        validateAppoinmentDate();
        validateAppoinmentStartTime();
        validateAppoinmentFinishTime();
        if(flagValue1 == false || flagValue2 == false || flagValue3 == false) {
            return;
        }
        //editProfileBackgroundOff();
        Swal.fire({
            title: 'Are you sure?',
            text: "Appointment are not completed,You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#0E2C4B',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, complete!'
        }).then((resultData) => {
            if (resultData.isConfirmed) {
                    let form_data = $("form").serializeArray();
                    console.log(form_data);

                    let data = {};
                    $.each(form_data, function(i, field){
                        // $("#results").append(field.name + ":" + field.value + " ");
                        data[field.name] = field.value;
                    });
                    console.log("Data"+data);

                    $.ajax({
                        method:"POST",
                        url:"physicalMember/appointment",
                        data: data,
                        // dataType:"json",
                        // contentType:"application/json",
                        success: function (result){
                            editProfileBackgroundOff();
                            if(result.trim() == "1"){
                                // alert(result);

                                Swal.fire({
                                    icon: 'success',
                                    title: 'Appointment Successfully',
                                    // text: 'Physical Member!',
                                    confirmButtonText:"Ok",
                                    confirmButtonColor: '#0E2C4B',
                                });

                                $('.payment_history_container_row').remove();

                                $.map(result,function (x){
                                    $('#appointment_container_table').append(
                                        '<tr class="payment_history_container_row">'+
                                        '<td>'+x.appointment_date["year"]+"-"+("0" + x.appointment_date["month"]).slice(-2)+"-"+("0" + x.appointment_date["day"]).slice(-2)+'</td>'+
                                        '<td>'+("0" + x.start_time["hour"]).slice(-2)+":"+("0" + x.start_time["minute"]).slice(-2)+":"+("0" + x.start_time["second"]).slice(-2)+'</td>'+
                                        '<td>'+("0" + x.finish_time["hour"]).slice(-2)+":"+("0" + x.finish_time["minute"]).slice(-2)+":"+("0" + x.finish_time["second"]).slice(-2)+'</td>'+
                                        // '<td>'+x.equipment+'</td>'+
                                        '<td>'+'<a href="#" class="show_more_button">SHOW MORE</a>'+'</td>'+
                                        '</tr>'
                                    );
                                });

                            }else {
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Appointment Unsuccessfully!',
                                    text: 'Appointment cannot placed!',
                                    confirmButtonText:"Ok",
                                    confirmButtonColor: '#932828',
                                })
                            }

                        },
                        error: function(error){
                            Swal.fire({
                                icon: 'error',
                                title: 'Appointment Unsuccessfully!',
                                text: 'Cannot resolve, System issue!!',
                                confirmButtonText:"Ok",
                                confirmButtonColor: '#932828',
                            })
                        }
                    });
                    editProfileBackgroundOff();
                    document.getElementById("edit_profile_container_detail_name").value = "";
                    document.getElementById("edit_profile_container_detail_last_name").value = "";
                    document.getElementById("edit_profile_container_detail_weight").value = "";
                    document.getElementById("edit_profile_container_detail_last_height").value = "";

                    $('#appointment_details_popup').fadeOut(500);


                    $('.payment_history_container_row').hide();
                    getAppointmentData();

            }else if (resultData.isDenied){
                Swal.fire('Changes are not saved', '', 'info')
            }
        })
        editProfileBackgroundOff();
        e.preventDefault();
    });
}

// appoitment history popup
function viewAppoitmentData(appoit_date,startTime,finishTime){
    $('#after_appointment_popup_details').show();
    editProfileBackgroundOn();

    $('#appoitment_history_detail_container').append(
        `<div class="payment_detail_container_input appoitment_detail_container_input">
                            <div>
                                <span><b>Appointment Date</b></span><br>
                                <span>${appoit_date}</span>
                            </div>

                            <div>
                                <span><b>Start Time</b></span><br>
                                <span>${startTime}</span>
                            </div>
                        </div>

                        <div class="payment_detail_container_input appoitment_detail_container_input">
                            <div>
                                <span><b>Finish Time</b></span><br>
                                <span>${finishTime}</span>
                            </div>

                        </div>`
    );
}

function close_after_appointment_details(){
    $('.appoitment_detail_container_input').remove();
    $('#after_appointment_popup_details').hide();
    editProfileBackgroundOff();
}