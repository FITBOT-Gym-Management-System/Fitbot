

function physical_member_profile(){
    let profile_workout = document.getElementById("phy_mem_profile");
    let profile_workout_i = document.getElementById("phy_mem_profile_i");
    let profile_text = document.getElementById("physical_member_profile_text");
    profile_workout.style.backgroundColor = "white";
    profile_workout_i.style.color = "black";
    profile_text.style.color = "black";
}

function edit_profile_popup(){
    // alert("profile image");
    $('#edit_profile_container').show();
    editProfileBackgroundOn();
}

function close_edit_profile_Popup(){
    $('#edit_profile_container').hide();
    editProfileBackgroundOff();
}

function validateEmptyFeildsInPasswordErrorHide(){
    $('#edit_profile_container_change_new_password1_error').hide();
    $('#edit_profile_container_change_new_password_error').hide();
    $('#edit_profile_container_change_confirm_password_error').hide();
}

function validateEmptyFeildsInPasswordErrorShow(error){
    $('#'+error.trim().toString()).show();
    $('#'+error.trim().toString()).css("color","red");
}

function edit_profile_change_password(){
    $('#edit_profile_container').hide();
    $('#edit_profile_change_password_container').show();
    validateEmptyFeildsInPasswordErrorHide();
    editProfileBackgroundOn();
}

function commonThingsForBack(){
    validateEmptyFeildsInPasswordErrorHide();
    document.getElementById("edit_profile_container_change_new_password1").value = "";
    document.getElementById("edit_profile_container_change_new_password").value = "";
    document.getElementById("edit_profile_container_change_confirm_password").value = "";
}

function close_edit_profile_change_password_Popup(){
    $('#edit_profile_change_password_container').hide();
    editProfileBackgroundOff();
    commonThingsForBack();
}

function edit_profile_change_password_back(){
    $('#edit_profile_change_password_container').hide();
    $('#edit_profile_container').show();
    commonThingsForBack();
}

// $('#date_of_birth').keyup(function () {
//     validateDOB();
// });

function validateFeilds(old_password,new_password,confirm_password){
    if(old_password == ''){
        document.getElementById("edit_profile_container_change_new_password1").value = "";
        validateEmptyFeildsInPasswordErrorShow("edit_profile_container_change_new_password1_error");
        return false;
    }
    if(new_password == ''){
        document.getElementById("edit_profile_container_change_new_password").value = "";
        validateEmptyFeildsInPasswordErrorShow("edit_profile_container_change_new_password_error");
        return false;
    }
    if(confirm_password == ''){
        document.getElementById("edit_profile_container_change_confirm_password").value = "";
        validateEmptyFeildsInPasswordErrorShow("edit_profile_container_change_confirm_password_error");
        return false;
    }
    return true;
}

function edit_profile_change_password_submit(){
    //swal - Are You sure?
    // $('#edit_profile_change_password_container').hide();
    let old_password = $('#edit_profile_container_change_new_password1').val().trim();
    let new_password = $('#edit_profile_container_change_new_password').val().trim();
    let confirm_password = $('#edit_profile_container_change_confirm_password').val().trim();

    let resultValue = validateFeilds(old_password,new_password,confirm_password);

    if(resultValue == false){
        //$('#phone_number_check').html("**Phone number length can contain only numbers between 10 to 12");
        //$('#phone_number_check').css("color","red");
        return;
    }else {
        if ((new_password.length < 6) || (new_password.length > 16)){
            $('#edit_profile_container_change_new_password_error').show();
            $('#edit_profile_container_change_new_password_error').html("**length of your password must be between 6 and 16 and spaces must be unacceptable");
            $('#edit_profile_container_change_new_password_error').css("color", "red");
            return;
        }
        if ((confirm_password.length < 6) || (confirm_password.length > 16)){
            $('#edit_profile_container_change_confirm_password_error').show();
            $('#edit_profile_container_change_confirm_password_error').html("**length of your confirm password must be between 6 and 16 and spaces must be unacceptable");
            $('#edit_profile_container_change_confirm_password_error').css("color", "red");
            return;
        }
        if (confirm_password.trim().toString() != new_password.trim().toString()){
            $('#edit_profile_container_change_confirm_password_error').show();
            $('#edit_profile_container_change_confirm_password_error').html("**length of your password must be between 6 and 16 and spaces must be unacceptable");
            $('#edit_profile_container_change_confirm_password_error').css("color", "red");
            return;
        }
        if(old_password){
            $.ajax({
                url: 'checkPassword',
                type: 'post',
                data: {old_password:old_password,new_password:new_password},
                success: function (response) {
                    if (response.trim() == "1") {
                        $('#edit_profile_change_password_container').hide();
                        commonThingsForBack();
                        editProfileBackgroundOff();
                        Swal.fire({
                            icon: 'success',
                            title: 'Password reset successfully!',
                            // text: 'Logout unsuccessfully!',
                            confirmButtonText:"Ok",
                            confirmButtonColor: '#0E2C4B',
                        })
                    } else {
                        Swal.fire({
                            icon: 'error',
                            title: 'Password reset unsuccessfully!',
                            // text: 'Logout unsuccessfully!',
                            confirmButtonText:"Ok",
                            confirmButtonColor: '#932828',
                        })
                    }
                }, error: function (error) {
                    console.log(error);
                    Swal.fire({
                        icon: 'error',
                        title: 'Password reset unsuccessfully!',
                        // text: 'Logout unsuccessfully!',
                        confirmButtonText:"Ok",
                        confirmButtonColor: '#932828',
                    })
                }
            });
        }

    }


}

// $(document).ready(function(){
//     $('#phy_mem_profile').click(function(){
//         alert("Iam here babe");
//     });
// });

function editProfileBackgroundOn(){
    $('.profile_physical_big_container_background').css('display','block');
}
function editProfileBackgroundOff(){
    $('.profile_physical_big_container_background').css('display','none');
}

function saveImage(imageData){
    let edit_profile_container_detail_name = $('#edit_profile_container_detail_name').val().trim();
    let edit_profile_container_detail_last_name = $('#edit_profile_container_detail_last_name').val().trim();
    let edit_profile_container_detail_last_conatct = $('#edit_profile_container_detail_last_conatct').val().trim();
    //let edit_profile_container_detail_last_profile_image = null;

    let fd = new FormData();
    let files = $('#edit_profile_container_detail_last_profile_image')[0].files;

    // Check file selected or not
    if(files.length > 0 ){
        fd.append('file',files[0]);

        $.ajax({
            url: 'upload',
            type: 'post',
            data: fd,
            contentType: false,
            processData: false,
            success: function(response){
                if(response != 0){
                    $("#img").attr("src",response);
                    $(".preview img").show(); // Display image element
                }else{
                    alert('file not uploaded');
                }
            },
        });
    }else{
        alert("Please select a file.");
    }
}

function edit_profile_submit(){
    //alert("Yohan");
    let edit_profile_container_detail_name = $('#edit_profile_container_detail_name').val();
    let edit_profile_container_detail_last_name = $('#edit_profile_container_detail_last_name').val();
    let edit_profile_container_detail_last_conatct = $('#edit_profile_container_detail_last_conatct').val();
    //let edit_profile_container_detail_last_profile_image = null;

    //console.log("Image type: "+edit_profile_container_detail_last_profile_image);

    let completed_flag = 0;
    let result_object;
    // files.length <= 0
    let fd = new FormData();
    let files = $('#edit_profile_container_detail_last_profile_image')[0].files;

    if((edit_profile_container_detail_name == '' && edit_profile_container_detail_last_name == '') && edit_profile_container_detail_last_conatct == ''){
        Swal.fire({
            icon: 'error',
            title: 'Update Unsuccessfully!',
            text: 'Cannot empty every field!',
            confirmButtonText: "Ok",
            confirmButtonColor: '#932828',
        })
        completed_flag = 0;
        return;
    }else if(files.length > 0){
        //alert("Yohan");
        fd.append('edit_profile_container_detail_last_profile_image',files[0]);
        //console.log(fd);
        //let dataval = new FormData($("#image-form")[0]);
        //let dataval = new FormData($("#image-form")[0]);
        console.log(fd);
        //doesnt upload a image
        $.ajax({
            method: "POST",
            url: "saveImageData",
            data: fd,
            // data: dataval,
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            cache: false,
            // dataType:"json",
            // contentType:"application/json",
            success: function (result) {
                // alert(result);
                console.log(result);
                if(result.trim() == "1"){
                    console.log("Image save success");
                }else {
                    console.log("Image save unsuccessful");
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }else {
        //alert("Yohan");
        completed_flag = 1;
    }


    if(completed_flag == 1){
        $.ajax({
            method:"POST",
            url:"memberDetails",
            dataType:"json",
            // contentType:"application/json",
            success: function (result){
                console.log(result);
                result_object = result;

                $('#edit_profile_error_contact_number').hide();
                $('#edit_profile_error_dob').hide();
                $('#edit_profile_error_profile_image').hide();

                console.log(result_object);
                if(edit_profile_container_detail_name == ''){
                    edit_profile_container_detail_name = result_object.first_name.toString();
                }

                if(edit_profile_container_detail_last_name == ''){
                    edit_profile_container_detail_last_name = result_object.last_name.toString();
                }

                let regexPattern = new RegExp(/^[0-9-+]+$/);
                if(edit_profile_container_detail_last_conatct == ''){
                    edit_profile_container_detail_last_conatct = result_object.contact_number.toString();
                }else if(!regexPattern.test(edit_profile_container_detail_last_conatct)){
                    $('#edit_profile_error_contact_number').show();
                    $('#edit_profile_error_contact_number').html("**Phone number can contain only numbers from 0-9 and + or - sign");
                    $('#edit_profile_error_contact_number').css("color","red");
                    return false;
                }else if('+' == edit_profile_container_detail_last_conatct[0]){
                    $('#edit_profile_error_contact_number').show();
                    $('#edit_profile_error_contact_number').html("**Phone number doesnt start with country code");
                    $('#edit_profile_error_contact_number').css("color","red");
                    return false;
                }

                $.ajax({
                    method: "POST",
                    url: "editProfile",
                    data: {
                        edit_profile_container_detail_name: edit_profile_container_detail_name,
                        edit_profile_container_detail_last_name: edit_profile_container_detail_last_name,

                        edit_profile_container_detail_last_conatct: edit_profile_container_detail_last_conatct
                        // edit_profile_container_detail_last_profile_image: fd,
                    },
                    // dataType:"json",
                    // contentType:"application/json",
                    success: function (result) {
                        // alert(result);
                        console.log(result);
                        console.log(typeof (result));
                        result.toString();
                        console.log(typeof (result));
                        if (result.trim() == "1") {
                            // alert(result);
                            editProfileBackgroundOff();
                            Swal.fire({
                                icon: 'success',
                                title: 'Successfully Updated',
                                text: 'Profile Updated!',
                                confirmButtonText: "Ok",
                                confirmButtonColor: '#0E2C4B',
                            })
                            // setTimeout(function() {
                            //     window.location.href = 'http://localhost:8080/group39_fitbot_war_exploded/physicalMember';
                            // }, 2000);
                            $('#edit_profile_container_detail').find("input[type=text], input[type=number], input[type=date], input[type=tel]").val("");
                            $('#edit_profile_container').hide();

                            //after update data profile page update
                            getRegisterDetails();

                        } else {
                            Swal.fire({
                                icon: 'error',
                                title: 'Update Unsuccessfully!',
                                text: 'Cannot update, System issue!',
                                confirmButtonText: "Ok",
                                confirmButtonColor: '#932828',
                            })
                        }

                    },
                    error: function (error) {
                        Swal.fire({
                            icon: 'error',
                            title: 'Update Unsuccessfully!',
                            text: 'Check the details!',
                            confirmButtonText: "Ok",
                            confirmButtonColor: '#932828',
                        })
                    }
                });

            },
            error: function(error){
                console.log(error+"edit profile");
            }
        });



        // if(edit_profile_container_detail_last_profile_image == ''){
        //     edit_profile_container_detail_last_profile_image = result_object.weight.toString();
        // }else if(edit_profile_container_detail_last_profile_image <= 25 || edit_profile_container_detail_last_profile_image >= 170){
        //     $('#edit_profile_error_profile_image').show();
        //     $('#edit_profile_error_profile_image').html("**Your image size should be less than 1MB");
        //     $('#edit_profile_error_profile_image').css("color", "red");
        //     return false;
        // }

        // let image_value = $("#edit_profile_container_detail_last_profile_image").val();
        // if (image_value.files && image_value.files[0]) {
        //     let reader = new FileReader();
        //
        //     edit_profile_container_detail_last_profile_image = "http://localhost:8080/group39_fitbot_war_exploded/Physical%20Member/Images/"+this.files[0]["name"];
        //
        //     console.log(image_value.files[0]);
        //     console.log(image_value.files[0]["name"]);
        //     console.log(image_value.files[0]["type"]);
        //     console.log(image_value.files[0]["size"]);
        //
        //     reader.onload = function (e) {
        //         $('#imgshow').attr('src', e.target.result);
        //     }
        //     reader.readAsDataURL(image_value.files[0]);
        // }
        // $("#edit_profile_container_detail_last_profile_image").change(function () {
        //
        //
        // });
    }

    // if(completed_flag == "1") {
    //
    // }
}

//leftsidebar repeated code
function getRegisterDetails(){
    $('#profile_physical_container_member').html('');
    $.ajax({
        method:"POST",
        url:"memberDetails",
        dataType:"json",
        // contentType:"application/json",
        success: function (result){
            // alert(result);
            const date = new Date();
            let year_age = date.getFullYear() - result.date_of_birth['year'];
            $('#profile_physical_container_member').append(
                '<span>'+result.first_name+" "+result.last_name+'</span><br>'
            );
            $('#profile_physical_container_member').append(
                '<span>'+'Age - '+year_age+'</span><br>'
            );
            $('#profile_physical_container_member').append(
                '<div class="profile_physical_container_member_div"><span>'+'Weight - '+result.weight+' Kg'+'</span><button class="profile_change_weight" id="profile_change_weight" onclick="update_weight()">Change Weight</button></div>'
            );
            $('#profile_physical_container_member').append(
                '<span>'+'Height - '+result.height+' cm'+'</span>'
            );

            console.log(result);
        },
        error: function(error){
            console.log(error+"edit profile");
        }
    });
}
function update_weight(){
    $('#edit_weight_detail_container_error').hide();
    $('#profile_change_weight').replaceWith($('#edit_weight_detail_container').show());
}
function close_edit_weight_Popup(){
    $('#edit_weight_detail_container').replaceWith($('#profile_change_weight').show());
    // $('#edit_weight_detail_container').replaceWith($('#profile_change_weight'));
    // $('#edit_weight_detail_container').hide();
    // $('#profile_change_weight').show();
}

// function checkUpdateWeight(){
//     let previous_weight = 0;
//     let dateCount = 0;
//     let todayDateNew;
//     let arr = new Array(0,0,null);
//     $.ajax({
//         method:"POST",
//         url:"updateWeightRetrive",
//         dataType:"json",
//         // contentType:"application/json",
//         success: function (result){
//             console.log(result);
//             if(result[0] != null) {
//                 previous_weight = result[0].new_weight;
//                 todayDateNew = result[0].update_date["year"]+"-"+("0"+result[0].update_date["month"]).slice(-2)+"-"+("0"+result[0].update_date["day"]).slice(-2);
//                 dateCount = result[0].daily_count;
//                 console.log(previous_weight," ",todayDateNew," ",dateCount);
//                 arr[0] = previous_weight;
//                 arr[1] = dateCount;
//                 arr[2] = todayDateNew;
//                 console.log(arr[0]," ",arr[1]," ",arr[2]);
//             }else {
//                 previous_weight = 0;
//                 todayDateNew = null;
//                 dateCount = 0;
//             }
//         },
//         error: function(error){
//             console.log(error+"edit profile");
//             return previous_weight;
//         }
//     });
//
//     console.log("previous weight"+arr);
//     return arr;
// }

function close_edit_weight_submit(){
    // let arr_new = new Array();
    // arr_new = checkUpdateWeight();
    let weightVal = $('#edit_weight_detail').val();

    if(weightVal.length == 0){
        $('#edit_weight_detail_container_error').show();
        $('#edit_weight_detail_container_error').css("color","red");
        document.getElementById("edit_weight_detail").value = "";
        // alert("length is zero")
        return;
    }
    let currentDate = new Date();
    currentDate = currentDate.getFullYear()+"-"+("0"+(currentDate.getMonth()+1)).slice(-2)+"-"+("0"+currentDate.getDate()).slice(-2);

    // let arr = new Array(0,0,null);
    let countNew = 0;
    let newWeightChange = 0;
    $.ajax({
        method:"POST",
        url:"updateWeightRetrive",
        dataType:"json",
        // contentType:"application/json",
        success: function (result){
            console.log(result);

            if(result[0] != null) {
                let previous_weight = result[0].new_weight;
                let todayDateNew = result[0].update_date["year"]+"-"+("0"+result[0].update_date["month"]).slice(-2)+"-"+("0"+result[0].update_date["day"]).slice(-2);
                let dateCount = result[0].daily_count;
                //console.log(previous_weight," ",todayDateNew," ",dateCount);

                //console.log("todayDateNew"+todayDateNew+" currentDate"+currentDate);
                if(todayDateNew == currentDate ){
                    $('#edit_weight_detail_container_error').show();
                    $('#edit_weight_detail_container_error').html("**Could be updated only once");
                    $('#edit_weight_detail_container_error').css("color","red");
                    // alert("alert")
                    // return;

                }else{
                    updateRealWeight(weightVal,currentDate,previous_weight);
                }
                // else if(parseInt(previous_weight) == 0){
                //     newWeightChange+=1;
                // }
                countNew += 1;

            }else {
                countNew = 0;
                newWeightChange = 0;

                $.ajax({
                    method:"POST",
                    url:"memberDetails",
                    dataType:"json",
                    // contentType:"application/json",
                    success: function (result){
                        // alert(result);
                        let previous_weight_new = parseFloat(result.weight);
                        updateRealWeight(weightVal,currentDate,previous_weight_new);
                        console.log(result);
                        //console.log(previous_weight);
                    },
                    error: function(error){
                        console.log(error+"edit profile");
                    }
                });
            }
        },
        error: function(error){
            console.log(error+"edit profile");
        }
    });

    document.getElementById("edit_weight_detail").value = "";
}

function updateRealWeight(weightVal,currentDate,previous_weight){
    $.ajax({
        method:"POST",
        url:"updateWeight",
        data:{weightVal:weightVal,currentDate:currentDate,previous_weight:previous_weight},
        // dataType:"json",
        // contentType:"application/json",
        success: function (result){
            console.log(result);
            if(result.trim().toString() == "1"){
                Swal.fire({
                    icon: 'success',
                    title: 'Successfully Update Weight',
                    // text: 'Password is successfully updated!',
                    confirmButtonText:"Ok",
                    confirmButtonColor: '#0E2C4B',
                })
                $('#edit_profile_container_detail').find("input[type=text], input[type=number], input[type=date], input[type=tel]").val("");
                $('#edit_profile_container').hide();

                getRegisterDetails();
            }else {
                Swal.fire({
                    icon: 'error',
                    title: 'Try Again',
                    text: 'Update unsuccessfully!',
                    confirmButtonText:"Ok",
                    confirmButtonColor: '#932828',
                })
            }
        },
        error: function(error){
            console.log(error+"edit profile");
        }
    });
}

function send_goal_weight(){
    let weight = $('#profile_physical_container_edit_monthly_goal_input1').val();
    $('#profile_physical_container_edit_monthly_goal_input_h5').hide();

    if(weight == ''){
        $('#profile_physical_container_edit_monthly_goal_input_h5').show();
        $('#profile_physical_container_edit_monthly_goal_input_h5').css("color","red")
    }else {
        $.ajax({
            method:"POST",
            url:"memberGoal",
            data:{profile_physical_container_edit_monthly_goal_input1:weight,profile_physical_container_edit_monthly_goal_input2:"0"},
            // dataType:"json",
            // contentType:"application/json",
            success: function (result){
                console.log(result);
                $('#profile_physical_container_edit_monthly_goal_input1').val('');
                if(result.trim().toString() == "1"){
                    Swal.fire({
                        icon: 'success',
                        title: 'Successfully set the goal',
                        // text: 'Password is successfully updated!',
                        confirmButtonText:"Ok",
                        confirmButtonColor: '#0E2C4B',
                    })
                }else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Try Again',
                        text: 'Goal set unsuccessfully!',
                        confirmButtonText:"Ok",
                        confirmButtonColor: '#932828',
                    })
                }
            },
            error: function(error){
                console.log(error+"edit profile");
            }
        });
    }
}

function send_goal_calory(){
    let calory = $('#profile_physical_container_edit_monthly_goal_input2').val();

    if(calory == ''){
        $('#profile_physical_container_edit_monthly_goal_input_h51').show();
        $('#profile_physical_container_edit_monthly_goal_input_h51').css("color","red")
    }else {
        $.ajax({
            method:"POST",
            url:"memberGoal",
            data:{profile_physical_container_edit_monthly_goal_input1:"0",profile_physical_container_edit_monthly_goal_input2:calory},
            // dataType:"json",
            // contentType:"application/json",
            success: function (result){
                console.log(result);
                $('#profile_physical_container_edit_monthly_goal_input2').val('');
                if(result.trim().toString() == "1"){
                    Swal.fire({
                        icon: 'success',
                        title: 'Successfully set the goal',
                        // text: 'Password is successfully updated!',
                        confirmButtonText:"Ok",
                        confirmButtonColor: '#0E2C4B',
                    })
                }else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Try Again',
                        text: 'Goal set unsuccessfully!',
                        confirmButtonText:"Ok",
                        confirmButtonColor: '#932828',
                    })
                }
            },
            error: function(error){
                console.log(error+"edit profile");
            }
        });
    }
}